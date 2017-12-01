package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetUserVideos;
import com.example.zsd.entity.GetVersion;
import com.example.zsd.model.GetVersionModel;
import com.example.zsd.view.GetUserVideosView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetUserVideosPresenter extends BasePresenter<GetUserVideosView> implements GetVersionModel.GetUserVideosMessage {
    private GetVersionModel getVersionModel;
    public GetUserVideosPresenter(GetUserVideosView mView) {
        super(mView);
        if(getVersionModel == null){

            getVersionModel = new GetVersionModel();
        }
        getVersionModel.setGetUserVideosMessage(this);
    }

    @Override
    public void getVersionSuccess(GetUserVideos value) {
        mView.success(value);
    }

    @Override
    public void getVersionFailure(String msg) {
        mView.failure(msg);
    }
}
