package com.baiyuas.ui.home;

import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.bean.HomeArticleBean;
import com.baiyuas.model.bean.HomeBannerBean;
import com.baiyuas.model.bean.WanResponse;
import com.baiyuas.model.http.NetRepo;
import com.baiyuas.ui.home.adapter.HomeMultiEntity;
import com.baiyuas.utils.log.ByLogger;
import com.baiyuas.utils.log.LogLevel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

import static com.baiyuas.utils.Utils.checkNull;
import static com.baiyuas.utils.Utils.isEmptyList;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class HomePresenter extends RxPresenter<HomeContact.View> implements HomeContact.Presenter {

    private NetRepo netRepo;

    @Inject
    public HomePresenter(NetRepo netRepo) {
        this.netRepo = netRepo;
    }

    @Override
    public void fetchHomeArticleList(int page) {
        addSubscribe(netRepo.fetchHomeArticleList(page)
                .compose(composeScheduler())
                .flatMap(response -> createData(response))
                .subscribe(homeArticleBean -> {
                    if (checkNull(homeArticleBean)) {
                        ByLogger.log("home log is Empty!");
                        return;
                    }
                    if (!checkNull(mView.get())) {
                        List<HomeMultiEntity> list = new ArrayList<>();
                        Flowable.fromIterable(homeArticleBean.getDatas())
                                .forEach(articleBean -> list.add(new HomeMultiEntity(HomeMultiEntity.VIEW_TYPE_ARTICLE, articleBean)));
                        mView.get().showHomeArticle(list, homeArticleBean.getPageCount() == page);
                    }
                }, throwable -> ByLogger.log("request home banner error" + throwable.getMessage(), LogLevel.E)));
    }

    @Override
    public void fetchHomeData() {
        addSubscribe(Flowable.zip(netRepo.fetchHomeBannerList(),
                netRepo.fetchHomeArticleList(0),
                (bannerResp, articleResp) -> createHomeData(bannerResp, articleResp))
                .compose(composeScheduler())
                .subscribe(result -> {
                    if (isEmptyList(result)) {
                        ByLogger.log("request home page data empty!");
                        return;
                    }

                    if (!checkNull(mView.get())) {
                        mView.get().showHomePageData(result);
                    }
                }, throwable -> ByLogger.log("request home data error:" + throwable.getMessage(), LogLevel.E)));
    }

    private List<HomeMultiEntity> createHomeData(WanResponse<List<HomeBannerBean>> resp1, WanResponse<HomeArticleBean> resp2) {
        List<HomeMultiEntity> list = new ArrayList<>();

        if (!checkNull(resp1) && resp1.getErrorCode() == 0) {
            list.add(new HomeMultiEntity(HomeMultiEntity.VIEW_TYPE_BANNER, resp1.getData()));
        }

        if (!checkNull(resp2) && resp2.getErrorCode() == 0) {
            Flowable.fromIterable(resp2.getData().getDatas())
                    .forEach(articleBean -> list.add(new HomeMultiEntity(HomeMultiEntity.VIEW_TYPE_ARTICLE, articleBean)));
        }
        return list;
    }
}
