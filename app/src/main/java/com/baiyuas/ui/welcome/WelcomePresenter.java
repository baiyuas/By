package com.baiyuas.ui.welcome;

import com.baiyuas.model.http.NetRepo;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class WelcomePresenter implements WelcomeContact.Presenter{

    private WelcomeContact.View mView;

    private NetRepo mNetRepo;

    @Inject
    public WelcomePresenter(NetRepo netRepo) {
        mNetRepo = netRepo;
    }

    @Override
    public void takeView(WelcomeContact.View view) {
        this.mView = view;
    }

    @Override
    public void dropView() {
        this.mView = null;
    }

    @Override
    public void reqFloorInfo() {
        if (mView != null) {
           // mView.showFloorList(mNetRepo.fetchFloorInfo());
        }
    }
}
