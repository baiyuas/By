package com.baiyuas.base.mvp;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public interface BaseView {
    void showLoading();

    void dismissLoading();

    void showNoData();

    void showError(String msg);
}
