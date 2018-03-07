package com.baiyuas.model.bean.local;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description: 楼层实体类
 */
public class FloorBean extends RealmObject{

    /**
     * 主键
     */
    @PrimaryKey
    private int id;

    /**
     * 名称
     */
    private String name;

    /**
     * 分类
     */
    private String category;

    /**
     * 图片资源明曾
     */
    private String image;

    /**
     * 需要跳转的路由
     */
    private String class_name_url;

    /**
     * 排序字段
     */
    private int sort;

    /**
     *
     */
    private int unSelected;

    /**
     * 是否需要登录
     */
    private int need_login;

    /**
     * 是否主页面展示
     */
    private int isCheck;

    /**
     * 图片地址
     */
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
