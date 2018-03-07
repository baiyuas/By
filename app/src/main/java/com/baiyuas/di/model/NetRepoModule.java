package com.baiyuas.di.model;

import com.baiyuas.model.http.NetRepImpl;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Singleton;

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
public abstract class NetRepoModule {

    @Singleton
    @Binds
    abstract NetRepo bindNetRep(NetRepImpl netRep);

}
