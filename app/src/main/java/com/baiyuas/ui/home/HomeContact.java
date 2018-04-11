package com.baiyuas.ui.home;

import com.baiyuas.base.mvp.BasePresenter;
import com.baiyuas.base.mvp.BaseView;
import com.baiyuas.ui.home.adapter.HomeMultiEntity;

import java.util.List;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public interface HomeContact {

    interface Presenter extends BasePresenter<HomeContact.View> {

        void fetchHomeArticleList(int page);

        void fetchHomeData();
    }

    interface View extends BaseView {

        void showHomeArticle(List<HomeMultiEntity> data, boolean isEnd);

        void showHomePageData(List<HomeMultiEntity> data);
    }
}
