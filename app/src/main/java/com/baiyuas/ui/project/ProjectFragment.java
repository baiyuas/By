package com.baiyuas.ui.project;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class ProjectFragment extends MvpFragment<ProjectPresenter> {

    @Inject
    public ProjectFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.project_fragment;
    }

    @Override
    protected void initEvent() {

    }
}
