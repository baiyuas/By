package com.baiyuas.ui.person;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class PersonFragment extends MvpFragment<PersonPresenter> {

    @Inject
    public PersonFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initEvent() {

    }
}
