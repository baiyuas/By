package com.baiyuas.ui.home.adapter;

import java.util.List;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
public class HomeMultiEntity<T> {
    public static final int VIEW_TYPE_BANNER = 0x01;
    public static final int VIEW_TYPE_ARTICLE = 0x02;

    public int type;
    public List<T> list;
    public T item;

    public HomeMultiEntity(int type, T item) {
        this.type = type;
        this.item = item;
    }

    public HomeMultiEntity(int type, List<T> list) {
        this.type = type;
        this.list = list;
    }
}
