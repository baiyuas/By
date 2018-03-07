package com.baiyuas.test;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/2 0002
 * description:
 */
@Module
public abstract class BindModule {
    @Binds
    public abstract WomanAction bindWomanAction(WomanActionImpl womanAction);

}
