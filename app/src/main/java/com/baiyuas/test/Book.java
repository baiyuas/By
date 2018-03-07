package com.baiyuas.test;

import javax.inject.Inject;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
public class Book {

    @Inject
    public Book() {
        System.out.println("This is Book constructor");
    }

    public void read() {
        System.out.println("man is reading");
    }
}
