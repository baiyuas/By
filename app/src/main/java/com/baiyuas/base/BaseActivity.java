package com.baiyuas.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.baiyuas.base.inter.ISupport;
import com.baiyuas.utils.log.ByLogger;
import com.baiyuas.utils.toast.Toasty;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public abstract class BaseActivity extends AppCompatActivity implements ISupport {


    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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

    @Override
    public void toast(String msg) {
        Toasty.show(getApplication(), msg);
    }

    @Override
    public void log(String log) {
        ByLogger.log(log);
    }
}
