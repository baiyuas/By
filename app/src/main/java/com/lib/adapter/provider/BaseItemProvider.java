package com.lib.adapter.provider;

import android.content.Context;

import com.lib.adapter.BaseRecycleViewHolder;

import java.util.List;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
public abstract class BaseItemProvider<T> {
    public Context mContext;
    public List<T> mData;

    public abstract void convert(BaseRecycleViewHolder helper, T data, int position);

    public abstract void onClick(BaseRecycleViewHolder helper, T data, int position);

    public abstract boolean onLongClick(BaseRecycleViewHolder helper, T data, int position);
}
