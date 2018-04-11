package com.baiyuas.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.baiyuas.R;
import com.baiyuas.model.bean.HomeBannerBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.annotation.ItemProviderTag;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.lib.adapter.BaseRecycleViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static com.baiyuas.utils.image.WanAndroidImageLoader.commonload;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
@ItemProviderTag(viewType = HomeMultiEntity.VIEW_TYPE_BANNER, layout = R.layout.home_provider_banner)
public class BannerProvider extends BaseItemProvider<HomeMultiEntity<HomeBannerBean>, BaseViewHolder> {

    private Banner mBanner;

    @Override
    public void convert(BaseViewHolder helper, HomeMultiEntity<HomeBannerBean> data, int position) {
        mBanner = helper.getView(R.id.banner);
        initBanner();
        List<String> images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        Observable.fromIterable(data.list)
                .toSortedList((o1, o2) -> o1.getOrder() > o2.getOrder() ? 1 : -1)
                .subscribe(homeBannerBeans -> Observable.fromIterable(homeBannerBeans)
                        .forEach(homeBannerList -> {
                            images.add(homeBannerList.getImagePath());
                            titles.add(homeBannerList.getTitle());
                        }));
        mBanner.setImages(images);
        mBanner.setBannerTitles(titles);
        mBanner.start();
    }

    @Override
    public void onClick(BaseViewHolder helper, HomeMultiEntity<HomeBannerBean> data, int position) {

    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, HomeMultiEntity<HomeBannerBean> data, int position) {
        return false;
    }

    private void initBanner() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                commonload(context, imageView, String.valueOf(path));
            }
        });
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);

        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
    }


}
