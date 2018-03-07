package com.baiyuas.test;

import javax.inject.Inject;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/2 0002
 * description:
 */
public class Woman {

    @Inject
    WomanAction action;

    public void draw() {
        action.draw();
    }

    public void play() {
        action.play();
    }

}
