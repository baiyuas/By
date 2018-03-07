package com.baiyuas.test;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
@Module
public class ManModule {

    @Provides
    Car provideCar() {
        return new Car();
    }

    @Provides
    @Singleton
    Bike provideBike() {
        return new Bike();
    }

    @Provides
    Computer provideComputer() {
        return new Computer();
    }

    @Provides
    Man provideMan(Car car, Pen pen) {
        pen.action();
        return new Man(car);
    }

}
