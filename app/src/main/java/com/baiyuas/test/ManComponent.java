package com.baiyuas.test;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
@Singleton
@Component(modules = {ManModule.class})
public interface ManComponent {

    //Man getMan();

    void injectMan(Man man);

    @Component.Builder
    interface Builder {

        /**
         * 这里@BindsInstance 类似给ManModule构造函数注入
         */
        @BindsInstance
        Builder plus(Pen pan);

        ManComponent build();
    }
}
