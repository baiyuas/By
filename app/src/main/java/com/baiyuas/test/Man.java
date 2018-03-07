package com.baiyuas.test;

import javax.inject.Inject;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
public class Man {

    private Car mCar;
//
//    @Inject
//    private Bike mBike;

    @Inject
    public Pen mPen;

    @Inject
    public Bike mBike;

    @Inject
    public Bike mBike2;


    @Inject
    public Book mBook;

    @Inject
    public Computer mComputer;

    public Man() {
        System.out.println("This is man constructor");
    }

    public Man(Car car) {
        mCar = car;
        System.out.println("This is man constructor 2");
    }

    public void action() {
        mCar.run();
    }

    public void play() {
        mComputer.run();
    }

    public void action2() {
        mBook.read();
    }

    public void action3() {
        mBike.run();
    }

    public void draw() {
        mPen.action();
    }

}
