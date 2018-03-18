package com.baiyuas.model.http;

import com.baiyuas.model.bean.UserBean;
import com.baiyuas.model.bean.WanResponse;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public interface NetRepo {

    /**
     * 注册
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @FormUrlEncoded
    @POST("user/register")
    Flowable<WanResponse<UserBean>> register(@Query("username") String username,
                                             @Query("password") String password,
                                             @Query("repassword") String repassword);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Flowable<WanResponse<UserBean>> login(@Field("username") String username,
                                             @Field("password") String password);

}
