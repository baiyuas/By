package com.baiyuas.model.bean.local;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/28 0028
 * description:
 */
public class GgItemBean extends RealmObject {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getClass_name_url() {
        return class_name_url;
    }

    public void setClass_name_url(String class_name_url) {
        this.class_name_url = class_name_url;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getUnSelected() {
        return unSelected;
    }

    public void setUnSelected(int unSelected) {
        this.unSelected = unSelected;
    }

    public int getNeed_login() {
        return need_login;
    }

    public void setNeed_login(int need_login) {
        this.need_login = need_login;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
