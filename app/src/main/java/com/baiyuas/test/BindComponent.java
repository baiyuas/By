package com.baiyuas.test;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/2 0002
 * description:
 */
@WomanScope
@Component(modules = {BindModule.class})
public interface BindComponent {

    Woman getWoman();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder plus(Woman woman);

        BindComponent build();
    }
}
