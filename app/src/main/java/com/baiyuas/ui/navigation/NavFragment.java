package com.baiyuas.ui.navigation;

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
public class NavFragment extends MvpFragment<NavPresenter> {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Inject
    public NavFragment() {
    }

    @Override
    protected void initEvent() {
        mToolbar.setTitle(R.string.tab_navigation);
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_navigation;

    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setFullStatusbarForFragment(getActivity(), getResources().getColor(R.color.colorPrimary), mToolbar);
    }
}
