package com.baiyuas.model.bean;

import java.util.List;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
public class UserBean {
    /**
     * collectIds : [-1,2075]
     * email :
     * icon :
     * id : 3716
     * password : 123456
     * type : 0
     * username : baiyuas
     */

    private String email;
    private String icon;
    private int id;
    private String password;
    private int type;
    private String username;
    private List<Integer> collectIds;

    @Override
    public String toString() {
        return "UserBean{" +
                "email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", username='" + username + '\'' +
                ", collectIds=" + collectIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserBean userBean = (UserBean) o;

        if (id != userBean.id) return false;
        if (type != userBean.type) return false;
        if (email != null ? !email.equals(userBean.email) : userBean.email != null) return false;
        if (icon != null ? !icon.equals(userBean.icon) : userBean.icon != null) return false;
        if (password != null ? !password.equals(userBean.password) : userBean.password != null)
            return false;
        if (username != null ? !username.equals(userBean.username) : userBean.username != null)
            return false;
        return collectIds != null ? collectIds.equals(userBean.collectIds) : userBean.collectIds == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (collectIds != null ? collectIds.hashCode() : 0);
        return result;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<Integer> collectIds) {
        this.collectIds = collectIds;
    }

    //"collectIds":[],"email":"","icon":"","id":3717,"password":"111111","type":0,"username":"baiyuas2"
    //"collectIds":[],"email":"","icon":"","id":3717,"password":"111111","type":0,"username":"baiyuas2"



}
