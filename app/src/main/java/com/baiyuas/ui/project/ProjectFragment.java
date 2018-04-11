package com.baiyuas.ui.project;

import android.support.v7.widget.Toolbar;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;
import com.baiyuas.utils.StatusBarUtil;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class ProjectFragment extends MvpFragment<ProjectPresenter> {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Inject
    public ProjectFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initEvent() {
        mToolbar.setTitle(getString(R.string.tab_project));

    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setFullStatusbarForFragment(getActivity(), getResources().getColor(R.color.colorPrimary), mToolbar);
    }
}
