package com.baiyuas.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.baiyuas.base.BaseFragment;
import com.baiyuas.utils.log.ByLogger;
import com.baiyuas.utils.log.LogLevel;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public abstract class MvpFragment<T extends RxPresenter> extends BaseFragment implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.takeView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.dropView();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showNoData() {

    }

    @Override
    public void showError(String msg) {
        ByLogger.log(msg, LogLevel.E);
    }
}
