package com.baiyuas.ui.home;

import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class HomePresenter extends RxPresenter<HomeContact.View> implements HomeContact.Presenter {

    private NetRepo netRepo;

    @Inject
    public HomePresenter(NetRepo netRepo) {
        this.netRepo = netRepo;
    }
}
