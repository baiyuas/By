package com.baiyuas.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/2 0002
 * description:
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface WomanScope {
}
