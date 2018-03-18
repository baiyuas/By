package com.baiyuas.base.mvp;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public interface BasePresenter<T extends BaseView> {

    void takeView(T view);

    /**
     * Drops the reference to the view when destroyed
     */
    void dropView();
}
