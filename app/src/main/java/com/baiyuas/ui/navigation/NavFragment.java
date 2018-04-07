package com.baiyuas.ui.navigation;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class NavFragment extends MvpFragment<NavPresenter> {

    @Inject
    public NavFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initEvent() {

    }
}
