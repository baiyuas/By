package com.baiyuas.di.component;

import com.baiyuas.di.scope.ActivityScope;
import com.baiyuas.ui.MainActivity;

import dagger.Component;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@ActivityScope
@Component(dependencies = {AppComponent.class})
public interface ActivityComponent {

    MainActivity inject(MainActivity mainActivity);

}
