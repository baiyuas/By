package com.baiyuas.di;

import com.baiyuas.test.DaggerBindComponent;
import com.baiyuas.test.DaggerManComponent;
import com.baiyuas.test.Man;
import com.baiyuas.test.ManComponent;
import com.baiyuas.test.ManModule;
import com.baiyuas.test.Pen;
import com.baiyuas.test.Woman;

import org.junit.Test;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
public class DiTest {

    @Test
    public void testDi() {
        Man originMan = new Man();
        ManComponent manComponent = DaggerManComponent.builder().plus(new Pen()).build();
        manComponent.injectMan(originMan);
        originMan.play();
        originMan.action2();
        originMan.draw();
        //manComponent.getMan().action();
        System.out.println(originMan.mBike);
        System.out.println(originMan.mBike2);
    }


    @Test
    public void testDi2() {
        Woman woman = DaggerBindComponent.builder().plus(new Woman()).build().getWoman();
        woman.draw();
        woman.play();
    }
}
