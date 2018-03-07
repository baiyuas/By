package com.baiyuas.ui.welcome;

import com.baiyuas.model.http.NetRepo;

import javax.inject.Inject;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/7 0007
 * description:
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
            mView.showFloorList(mNetRepo.fetchFloorInfo());
        }
    }
}
