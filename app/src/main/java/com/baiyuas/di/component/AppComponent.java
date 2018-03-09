package com.baiyuas.di.component;

import com.baiyuas.di.model.AppModule;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    NetRepo getNetRepo();
}
