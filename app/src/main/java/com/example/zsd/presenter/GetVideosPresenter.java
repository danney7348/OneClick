package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.model.GetVideosModel;
import com.example.zsd.view.GetVideosView;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVideosPresenter extends BasePresenter<GetVideosView> {
    private GetVideosModel getVideosModel;

    public GetVideosPresenter(GetVideosView mView) {
        super(mView);
        if (getVideosModel == null) {
            getVideosModel = new GetVideosModel();

        }
        //getVideosModel.setGetVideosMessage(this);
    }

    public void getVideosData(String uid, String type, String page) {
       // getVideosModel.getVideosData(uid, type, page);
    }

    /*@Override
    public void getVideosSuccess(GetVideos value) {
        mView.success(value);
    }

    @Override
    public void getVideosFailure(Throwable e) {
        mView.failure(e.getMessage().toString());
    }*/
}
