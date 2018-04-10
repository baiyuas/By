package com.lib.adapter;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
public class BaseRecycleViewHolder extends RecyclerView.ViewHolder {

    private BaseRecycleViewAdapter mAdapter;
    /**
     * 缓存item中的View
     */
    private SparseArray<View> views;

    View itemView;


    public BaseRecycleViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }


    public void setAdapter(BaseRecycleViewAdapter adapter) {
        mAdapter = adapter;
    }

    /**
     * itemView中的findviewbyid并缓存
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }


}
