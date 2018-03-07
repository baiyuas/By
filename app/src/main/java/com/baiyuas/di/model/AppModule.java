package com.baiyuas.di.model;

import com.baiyuas.model.http.NetRepImpl;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    NetRepo provideNetRepo(NetRepImpl netRep) {
        return netRep;
    }
}
