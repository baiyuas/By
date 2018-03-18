package com.baiyuas.ui.navigation;

import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class NavPresenter extends RxPresenter<NavContact.View> implements NavContact.Presenter {

    private NetRepo netRepo;

    @Inject
    public NavPresenter(NetRepo netRepo) {
        this.netRepo = netRepo;
    }
}
