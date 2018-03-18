package com.baiyuas.ui;

import com.baiyuas.di.scope.FragmentScope;
import com.baiyuas.ui.home.HomeFragment;
import com.baiyuas.ui.home.HomeModule;
import com.baiyuas.ui.navigation.NavFragment;
import com.baiyuas.ui.navigation.NavModule;
import com.baiyuas.ui.person.PersonFragment;
import com.baiyuas.ui.person.PersonModule;
import com.baiyuas.ui.project.ProjectFragment;
import com.baiyuas.ui.project.ProjectModule;
import com.baiyuas.ui.system.SysFragment;
import com.baiyuas.ui.system.SysModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
@Module
public abstract class MainModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {HomeModule.class})
    abstract HomeFragment takeHomeFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {NavModule.class})
    abstract NavFragment takeNavigationFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {ProjectModule.class})
    abstract ProjectFragment takeProjectFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {SysModule.class})
    abstract SysFragment takeSystemFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {PersonModule.class})
    abstract PersonFragment takePersonFragment();


}
