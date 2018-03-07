package com.baiyuas.di.component;

import android.app.Application;
import android.content.Context;

import com.baiyuas.app.ByDaggerAndroidApp;
import com.baiyuas.di.model.AndroidBindingModule;
import com.baiyuas.di.model.AppModule;
import com.baiyuas.di.model.ApplicationModule;
import com.baiyuas.di.model.NetRepoModule;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
@Singleton
@Component(modules = {NetRepoModule.class,
        AndroidBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AndroidAppComponent extends AndroidInjector<ByDaggerAndroidApp>{

    void inject(Application application);
}
