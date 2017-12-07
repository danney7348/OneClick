package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetUserVideos;
import com.example.zsd.entity.GetVersion;
import com.example.zsd.model.GetUserVideosModel;
import com.example.zsd.model.GetVersionModel;
import com.example.zsd.view.GetUserVideosView;
import com.example.zsd.view.GetVersionView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetUserVideosPresenter extends BasePresenter<GetUserVideosView> implements GetUserVideosModel.GetUserVideosMessage {
    private GetUserVideosModel getUserVideosModel;
    public GetUserVideosPresenter(GetUserVideosView mView) {
        super(mView);
        if(getUserVideosModel == null){

            getUserVideosModel = new GetUserVideosModel();
        }
        getUserVideosModel.setGetUserVideosMessage(this);
    }

    public void getUserVideosData(String uid,String page){
        getUserVideosModel.getUsesrVideos(uid,page);
    }
    @Override
    public void getUserVideosSuccess(GetUserVideos value) {
        mView.success(value);
    }

    @Override
    public void getUserVideosFailure(String msg) {
        mView.failure(msg);
    }
}
