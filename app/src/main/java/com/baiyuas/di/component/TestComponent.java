package com.baiyuas.di.component;

import com.baiyuas.di.model.NetRepoModule;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
@Singleton
@Component(modules = {NetRepoModule.class})
public interface TestComponent {

    NetRepo getNetRepo();
}
