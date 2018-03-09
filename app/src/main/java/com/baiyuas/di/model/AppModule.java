package com.baiyuas.di.model;

import com.baiyuas.model.http.NetRepImpl;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    NetRepo provideNetRepo(NetRepImpl netRep) {
        return netRep;
    }
}
