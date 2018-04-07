package com.baiyuas.ui.home;

import com.baiyuas.base.mvp.BasePresenter;
import com.baiyuas.base.mvp.BaseView;
import com.baiyuas.model.bean.HomeArticleBean;
import com.baiyuas.model.bean.HomeBannerBean;

import java.util.List;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public interface HomeContact {

    interface Presenter extends BasePresenter<HomeContact.View> {

        void fetchHomeBannerList();

        void fetchHomeArticleList(int page);
    }

    interface View extends BaseView {

        void showHomeBannerList(List<HomeBannerBean> list);

        void showHomeArticle(HomeArticleBean homeArticleBean);
    }
}
