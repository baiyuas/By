package com.lib.adapter.delegate;

import android.support.annotation.LayoutRes;
import android.util.SparseIntArray;

import java.util.List;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
public abstract class MultiTypeDelegate<T> {

    private SparseIntArray layoutIds;

    public final int getDefItemViewType(List<T> data, int position) {
        T item = data.get(position);
        return item != null ? getItemType(item) : -1;
    }

    /**
     * get the item type from specific entity.
     *
     * @param t entity
     * @return item type
     */
    protected abstract int getItemType(T t);

    public final int getLayoutId(int viewType) {
        return this.layoutIds.get(viewType, -1);
    }

    public MultiTypeDelegate registerItemType(int type, @LayoutRes int layoutId) {
        addItemType(type, layoutId);
        return this;
    }

    private void addItemType(int type, @LayoutRes int layoutId) {
        if (layoutIds == null) {
            this.layoutIds = new SparseIntArray();
        }
        this.layoutIds.put(type, layoutId);
    }

}
