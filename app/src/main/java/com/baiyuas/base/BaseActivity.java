package com.baiyuas.base;

import android.support.v7.app.AppCompatActivity;

import com.baiyuas.base.inter.ISupport;
import com.baiyuas.utils.log.ByLogger;
import com.baiyuas.utils.toast.Toasty;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public abstract class BaseActivity extends AppCompatActivity implements ISupport {

    @Override
    public void toast(String msg) {
        Toasty.show(getApplication(), msg);
    }

    @Override
    public void log(String log) {
        ByLogger.log(log);
    }
}
