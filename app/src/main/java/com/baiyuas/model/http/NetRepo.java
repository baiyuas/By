package com.baiyuas.model.http;

import com.baiyuas.model.bean.local.FloorBean;

import java.util.List;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
public interface NetRepo {
    List<FloorBean> fetchFloorInfo();
}
