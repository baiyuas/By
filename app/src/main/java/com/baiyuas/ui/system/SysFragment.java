package com.baiyuas.ui.system;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class SysFragment extends MvpFragment<SysPresenter> {

    @Inject
    public SysFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.sys_fragment;
    }

    @Override
    protected void initEvent() {

    }
}
