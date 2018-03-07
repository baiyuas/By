package com.baiyuas.di.component;

import com.baiyuas.di.model.AppModule;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    NetRepo getNetRepo();
}
