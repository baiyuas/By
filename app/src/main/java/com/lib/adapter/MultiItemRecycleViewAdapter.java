package com.lib.adapter;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.View;

import com.lib.adapter.annotation.ItemViewBind;
import com.lib.adapter.delegate.MultiTypeDelegate;
import com.lib.adapter.delegate.ProviderDelegate;
import com.lib.adapter.provider.BaseItemProvider;

import java.util.List;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
public abstract class MultiItemRecycleViewAdapter<T> extends BaseRecycleViewAdapter<T, BaseRecycleViewHolder> {

    private SparseArray<BaseItemProvider> mItemProviders;
    private ProviderDelegate mProviderDelegate;

    public MultiItemRecycleViewAdapter(@Nullable List<T> data) {
        super(data);
    }

    /**
     * 初始化
     */
    protected void initialize() {
        mProviderDelegate = new ProviderDelegate();
        setMultiTypeDelegate(new MultiTypeDelegate<T>() {
            @Override
            protected int getItemType(T o) {
                return getViewType(o);
            }
        });

        registerItemProvider();
        this.mItemProviders = mProviderDelegate.getItemProviders();
        for (int i = 0; i < mItemProviders.size(); i++) {
            int key = mItemProviders.keyAt(i);

            BaseItemProvider provider = mItemProviders.get(key);
            provider.mData = data;

            ItemViewBind tag = provider.getClass().getAnnotation(ItemViewBind.class);
            getMultiTypeDelegate().registerItemType(key, tag.layoutId());
        }
    }

    protected abstract int getViewType(T t);

    public abstract void registerItemProvider();

    @Override
    protected void convert(BaseRecycleViewHolder helper, T item) {
        int itemViewType = helper.getItemViewType();
        BaseItemProvider provider = mItemProviders.get(itemViewType);

        provider.mContext = helper.itemView.getContext();

        int position = helper.getLayoutPosition();
        provider.convert(helper, item, position);

        bindClick(helper, item, position, provider);
    }

    private void bindClick(final BaseRecycleViewHolder helper, final T item, final int position, final BaseItemProvider provider) {
        View itemView = helper.itemView;

        itemView.setOnClickListener(v -> provider.onClick(helper, item, position));

        itemView.setOnLongClickListener(v -> provider.onLongClick(helper, item, position));
    }

    protected void addProvide(BaseItemProvider provider) {
        mProviderDelegate.registerProvider(provider);
    }
}
