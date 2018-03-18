package com.baiyuas.ui.home;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
public class HomeFragment extends MvpFragment<HomePresenter> {

    @Inject
    public HomeFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initEvent() {

    }
}
