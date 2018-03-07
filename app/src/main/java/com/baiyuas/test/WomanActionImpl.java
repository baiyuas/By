package com.baiyuas.test;

import javax.inject.Inject;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/2 0002
 * description:
 */
@WomanScope
public class WomanActionImpl implements WomanAction {

    @Inject
    public Computer mComputer;

    @Inject
    public Pen mPen;

    @Override
    public void draw() {
        mPen.action();
    }

    @Override
    public void play() {
        mComputer.run();
    }
}
