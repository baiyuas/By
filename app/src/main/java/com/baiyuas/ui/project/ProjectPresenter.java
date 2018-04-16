package com.baiyuas.ui.project;

import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.http.NetRepo;
import com.baiyuas.utils.Utils;
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
public class ProjectPresenter extends RxPresenter<ProjectContact.View> implements ProjectContact.Presenter {

    private NetRepo netRepo;

    @Inject
    public ProjectPresenter(NetRepo netRepo) {
        this.netRepo = netRepo;
    }

    @Override
    public void fetchProjectCatalog() {
        addSubscribe(netRepo.fetchProjectCatList()
                .compose(composeScheduler())
                .flatMap(response -> createData(response))
                .subscribe(projectCatalogBeanList -> {
                    dismmissLoading();
                    if (isEmptyList(projectCatalogBeanList)) {
                        ByLogger.log("request project catalog is Empty!");
                        return;
                    }
                    if (!checkNull(mView.get())) {
                        mView.get().showProjectCatalog(projectCatalogBeanList);
                    }
                }, throwable -> showError("request project catalog error:" + throwable.getMessage())));

    }

    @Override
    public void fetchCatUnderProject(int catId, int page) {
        addSubscribe(netRepo.fetchCatUnderProject(page, catId)
                .compose(composeScheduler())
                .flatMap(response -> createData(response))
                .subscribe(projectListBean -> {
                    dismmissLoading();
                    if (checkNull(projectListBean)) {
                        ByLogger.log("request catalog`s project is empty!");
                        return;
                    }
                    if (isEmptyList(projectListBean.getDatas())) {
                        ByLogger.log("request catId:" + catId + " under projects empty!");
                        return;
                    }

                    if (!checkNull(mView.get())) {
                        mView.get().showCatUnderProject(projectListBean);
                    }
                }, throwable -> showError("request fetchCatUnderProject error:" + throwable.getMessage())));
    }
}
