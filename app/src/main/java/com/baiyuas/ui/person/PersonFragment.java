package com.baiyuas.ui.person;

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
public class PersonFragment extends MvpFragment<PersonPresenter> {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Inject
    public PersonFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initEvent() {
        mToolbar.setTitle("个人");
    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setFullStatusbarForFragment(getActivity(), getResources().getColor(R.color.colorPrimary), mToolbar);
    }
}
