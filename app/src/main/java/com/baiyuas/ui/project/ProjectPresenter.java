package com.baiyuas.ui.project;

import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class ProjectPresenter extends RxPresenter<ProjectContact.View> implements ProjectContact.Presenter {

    private NetRepo netRepo;

    @Inject
    public ProjectPresenter(NetRepo netRepo) {
        this.netRepo = netRepo;
    }
}
