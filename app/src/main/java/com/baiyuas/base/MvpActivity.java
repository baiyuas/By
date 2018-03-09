package com.baiyuas.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public abstract class MvpActivity<T extends RxPresenter> extends BaseActivity implements BaseView {

    @Inject
    T mPresenter;

    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        int layoutId = bindLayout();
        if (layoutId == 0) {
            throw new IllegalStateException(
                    "layout id need to set");
        }
        setContentView(bindLayout());
        unbinder = ButterKnife.bind(this);
        initEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected abstract int bindLayout();

    protected abstract void initEvent();
}
