package com.baiyuas.ui.home;

import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.http.NetRepo;
import com.baiyuas.utils.log.ByLogger;
import com.baiyuas.utils.log.LogLevel;

import javax.inject.Inject;

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
    public void fetchHomeBannerList() {
        addSubscribe(netRepo.fetchHomeBannerList()
                .compose(composeScheduler())
                .flatMap(response -> createData(response))
                .subscribe(homeBannerBeans -> {
                            if (isEmptyList(homeBannerBeans)) {
                                ByLogger.log("home log is Empty!");
                                return;
                            }
                            if (!checkNull(mView.get())) {
                                mView.get().showHomeBannerList(homeBannerBeans);
                            }
                        },
                        throwable -> ByLogger.log("request home banner error" + throwable.getMessage(), LogLevel.E)));
        return;
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
                        mView.get().showHomeArticle(homeArticleBean);
                    }
                }, throwable -> ByLogger.log("request home banner error" + throwable.getMessage(), LogLevel.E)));
    }
}
