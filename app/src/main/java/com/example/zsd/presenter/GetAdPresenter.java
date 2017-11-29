package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetAd;
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
        if(getAdModel == null){
            getAdModel = new GetAdModel();
        }
        getAdModel.setGetAdMessage(this);
    }
    public void getAdData(){
        getAdModel.getAd();
    }

    @Override
    public void getAdSuccess(GetAd value) {
        mView.success(value);
    }

    @Override
    public void getAdFailure(String msg) {
        mView.failure(msg);
    }
}

