package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.GetAd;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.model.GetAdModel;

/**
 * 作者： 张少丹
 * 时间：  2017/11/29.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetAdView extends BaseView {
    void getAdseccuss(GetAd ad);

    void getVideosseccuss(GetVideos videos);

    void error(String msg);

    void failue(String msg);

}
