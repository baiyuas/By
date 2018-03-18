package com.baiyuas.model.bean;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
public class WanResponse<T> {
    /**
     * data : null
     * errorCode : -1
     * errorMsg : 用户名已经被注册！
     */

    private T data;
    private int errorCode;
    private String errorMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "WanResponse{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WanResponse<?> that = (WanResponse<?>) o;

        if (errorCode != that.errorCode) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return errorMsg != null ? errorMsg.equals(that.errorMsg) : that.errorMsg == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + errorCode;
        result = 31 * result + (errorMsg != null ? errorMsg.hashCode() : 0);
        return result;
    }
}
