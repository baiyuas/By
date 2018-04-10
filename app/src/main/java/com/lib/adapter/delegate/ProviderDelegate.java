package com.lib.adapter.delegate;

import android.util.SparseArray;

import com.lib.adapter.annotation.ItemViewBind;
import com.lib.adapter.provider.BaseItemProvider;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
public class ProviderDelegate {

    private SparseArray<BaseItemProvider> mItemProviders = new SparseArray<>();

    public void registerProvider(BaseItemProvider provider) {
        ItemViewBind tag = provider.getClass().getAnnotation(ItemViewBind.class);
        if (tag == null) {
            throw new IllegalArgumentException("ItemViewBind not def layout");
        }

        int viewType = tag.viewType();
        if (mItemProviders.get(viewType) == null) {
            mItemProviders.put(viewType, provider);
        }
    }

    public SparseArray<BaseItemProvider> getItemProviders() {
        return mItemProviders;
    }

}
