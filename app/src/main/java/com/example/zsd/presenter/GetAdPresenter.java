package com.example.zsd.presenter;


import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetAd;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.model.GetAdModel;
import com.example.zsd.view.GetAdView;


import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/29.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetAdPresenter extends BasePresenter<GetAdView> implements GetAdModel.GetAdMessage {

    private GetAdModel getAdModel;

    public GetAdPresenter(GetAdView mView) {
        super(mView);
        getAdModel = new GetAdModel(this);
    }

    public void getAdData() {
        getAdModel.getAd();
    }

    public void getVideos(String uid, String type, String page) {
        getAdModel.getVideosData(uid, type, page);

    }

    @Override
    public void getAdSuccess(GetAd value) {
        mView.getAdseccuss(value);
    }

    @Override
    public void getVideosSuccess(GetVideos value) {
        mView.getVideosseccuss(value);
        System.out.println("value ==================== " + value);
    }

    @Override
    public void getAdFailure(String msg) {
        mView.failue(msg);
        System.out.println("msg = " + msg);
    }
}

