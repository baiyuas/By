package com.baiyuas.di.model;

import com.baiyuas.model.http.NetRepImpl;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@Module
public abstract class NetRepoModule {

    @Singleton
    @Binds
    abstract NetRepo bindNetRep(NetRepImpl netRep);

}
