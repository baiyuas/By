package com.baiyuas.app;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class ByDaggerAndroidApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
