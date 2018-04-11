package com.baiyuas.ui.system;

import com.baiyuas.app.ByDaggerAndroidApp;
import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.bean.ArticleBean;
import com.baiyuas.model.bean.HierarchyBean;
import com.baiyuas.model.bean.HomeArticleBean;
import com.baiyuas.model.bean.WanResponse;
import com.baiyuas.model.http.NetRepo;
import com.baiyuas.utils.Utils;
import com.baiyuas.utils.log.ByLogger;
import com.baiyuas.utils.log.LogLevel;
import com.baiyuas.utils.toast.Toasty;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import static com.baiyuas.utils.Utils.checkNull;
import static com.baiyuas.utils.Utils.isEmptyList;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class SysPresenter extends RxPresenter<SysContact.View> implements SysContact.Presenter {

    private NetRepo netRepo;
    private int cid;

    @Inject
    public SysPresenter(NetRepo netRepo) {
        this.netRepo = netRepo;
    }

    @Override
    public void fetchHierarchyArticleList() {
        addSubscribe(netRepo.fetchHierarchyList()
                .flatMap(response -> {
                    if (!isEmptyList(response.getData())) {
                        Random random = new Random();
                        int index = response.getData().size() > 1 ? random.nextInt(response.getData().size() - 1) : 0;
                        List<HierarchyBean> children = response.getData().get(index).getChildren();
                        if (isEmptyList(children)) {
                            return null;
                        }
                        int childIndex = children.size() > 1 ? random.nextInt(children.size() - 1) : 0;
                        cid = children.get(childIndex).getId();
                        return netRepo.fetchHierarchyArticleList(0, cid);
                    }
                    return null;
                }).compose(composeScheduler())
                .flatMap(response -> createData(response))
                .subscribe(hierarchyArticleBean -> {
                    if (checkNull(hierarchyArticleBean)) {
                        ByLogger.log("system article is Empty!");
                        return;
                    }

                    // 数据太少重新请求
                    if (hierarchyArticleBean.getDatas().size() < 5) {
                        fetchHierarchyArticleList();
                        return;
                    }

                    if (!checkNull(mView.get())) {
                        mView.get().showHierarchyArticle(hierarchyArticleBean);
                    }
                }, throwable -> ByLogger.log(throwable.getMessage(), LogLevel.E)));
    }

    @Override
    public void fetchMoreHierarchyArticleList(int page) {
        addSubscribe(netRepo.fetchHierarchyArticleList(page, cid)
                .compose(composeScheduler())
                .flatMap(response -> createData(response))
                .subscribe(hierarchyArticleBean -> {
                    if (checkNull(hierarchyArticleBean)) {
                        ByLogger.log("system article is Empty!");
                        return;
                    }

                    if (!checkNull(mView.get())) {
                        mView.get().showHierarchyArticle(hierarchyArticleBean);
                    }
                }, throwable -> ByLogger.log(throwable.getMessage(), LogLevel.E)));
    }
}
