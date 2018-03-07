package com.baiyuas.app;

import android.app.Activity;
import android.app.Application;

import com.baiyuas.di.component.DaggerAndroidAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/2 0002
 * description:
 */
public class ByDaggerAndroidApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAndroidAppComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
