package com.baiyuas.model.http;

import com.baiyuas.model.bean.local.FloorBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
public class NetRepImpl implements NetRepo {

    @Inject
    public NetRepImpl() {
    }

    @Override
    public List<FloorBean> fetchFloorInfo() {
        List<FloorBean> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FloorBean bean = new FloorBean();
            bean.setId(i);
            data.add(bean);
        }
        return data;
    }
}
