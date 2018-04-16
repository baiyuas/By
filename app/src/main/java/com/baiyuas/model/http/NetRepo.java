package com.baiyuas.model.http;

import com.baiyuas.model.bean.ArticleBean;
import com.baiyuas.model.bean.HierarchyBean;
import com.baiyuas.model.bean.HomeBannerBean;
import com.baiyuas.model.bean.ListBean;
import com.baiyuas.model.bean.ProjectBean;
import com.baiyuas.model.bean.ProjectCatalogBean;
import com.baiyuas.model.bean.UserBean;
import com.baiyuas.model.bean.WanResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public interface NetRepo {

    /**
     * 注册
     *
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
     *
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Flowable<WanResponse<UserBean>> login(@Field("username") String username,
                                          @Field("password") String password);

    /**
     * 首页Banner列表
     *
     * @return
     */
    @GET("banner/json")
    Flowable<WanResponse<List<HomeBannerBean>>> fetchHomeBannerList();

    /**
     * 获取文章列表
     *
     * @param page 页码
     * @return
     */
    @GET("article/list/{page}/json")
    Flowable<WanResponse<ListBean<ArticleBean>>> fetchHomeArticleList(@Path("page") int page);

    /**
     * 获取体系列表
     *
     * @return
     */
    @GET("tree/json")
    Flowable<WanResponse<List<HierarchyBean>>> fetchHierarchyList();

    /**
     * 获取体系下文章列表
     *
     * @param page 页码
     * @param cid  体系id
     * @return
     */
    @GET("article/list/{page}/json")
    Flowable<WanResponse<ListBean<ArticleBean>>> fetchHierarchyArticleList(@Path("page") int page, @Query("cid") int cid);

    /**
     * 获取项目分类
     *
     * @return
     */
    @GET("project/tree/json")
    Flowable<WanResponse<List<ProjectCatalogBean>>> fetchProjectCatList();

    /**
     * 获取指定分类下的项目
     *
     * @return
     */
    @GET("project/list/{page}/json")
    Flowable<WanResponse<ListBean<ProjectBean>>> fetchCatUnderProject(@Path("page") int page, @Query("cid") int cid);

}
