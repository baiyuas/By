package com.baiyuas.di.component;

import com.baiyuas.di.scope.ActivityScope;
import com.baiyuas.ui.MainActivity;

import dagger.Component;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/2 0002
 * description:
 */
@ActivityScope
@Component(dependencies = {AppComponent.class})
public interface ActivityComponent {

    MainActivity inject(MainActivity mainActivity);

}
