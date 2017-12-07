package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetAd;
import com.example.zsd.entity.GetVersion;
import com.example.zsd.model.GetVersionModel;
import com.example.zsd.view.GetVersionView;

/**
 * 作者： 张少丹
 * 时间：  2017/11/29.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVersionPresenter extends BasePresenter<GetVersionView> implements GetVersionModel.GetVersionMessage {
    private GetVersionModel getVersionModel;
    public GetVersionPresenter(GetVersionView mView) {
        super(mView);
        if(getVersionModel == null){
            getVersionModel = new GetVersionModel();
        }
        getVersionModel.setGetVersionMessage(this);
    }
    public void getVersionData(){
        getVersionModel.getVersionData();
    }
    @Override
    public void getVersionSuccess(GetVersion value) {
        mView.success(value);
    }

    @Override
    public void getVersionFailure(String msg) {
        mView.failure(msg);
    }
}
