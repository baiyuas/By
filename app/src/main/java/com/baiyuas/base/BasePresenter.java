package com.baiyuas.base;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/28 0028
 * description:
 */
public interface BasePresenter<T> {

    void takeView(T view);

    /**
     * Drops the reference to the view when destroyed
     */
    void dropView();
}
