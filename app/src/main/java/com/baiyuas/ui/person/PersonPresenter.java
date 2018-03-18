package com.baiyuas.ui.person;

import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class PersonPresenter extends RxPresenter<PersonContact.View> implements PersonContact.Presenter{

    private NetRepo netRepo;

    @Inject
    public PersonPresenter(NetRepo netRepo) {
        this.netRepo = netRepo;
    }
}
