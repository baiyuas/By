package com.baiyuas.di.model;

import android.app.Application;
import android.content.Context;

import com.baiyuas.app.ByDaggerAndroidApp;

import dagger.Binds;
import dagger.Module;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/7 0007
 * description:
 */
@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(ByDaggerAndroidApp application);
}
