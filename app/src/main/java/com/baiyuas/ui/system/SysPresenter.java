package com.baiyuas.ui.system;

import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class SysPresenter extends RxPresenter<SysContact.View> implements SysContact.Presenter {

    private NetRepo netRepo;

    @Inject
    public SysPresenter(NetRepo netRepo) {
        this.netRepo = netRepo;
    }
}
