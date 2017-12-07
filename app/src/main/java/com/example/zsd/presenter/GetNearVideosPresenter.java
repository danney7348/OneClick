package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetNearVideos;
import com.example.zsd.model.GetNearVideosCallBack;
import com.example.zsd.model.GetNearVideosModel;
import com.example.zsd.view.GetNearVideosView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/6.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetNearVideosPresenter extends BasePresenter<GetNearVideosView> {
    private GetNearVideosModel getNearVideosModel;
    public GetNearVideosPresenter(GetNearVideosView mView) {
        super(mView);
        if(getNearVideosModel == null){
            getNearVideosModel = new GetNearVideosModel();
        }
    }
    public void getNearVideosData(String page, String latitude, String longitude){
        getNearVideosModel.getNearVideosData(page, latitude, longitude, new GetNearVideosCallBack() {
            @Override
            public void getNearVideosSuccess(GetNearVideos getNearVideos) {
                if(getNearVideos != null){
                    mView.success(getNearVideos);
                }
            }

            @Override
            public void getNearVideosFailure(String msg) {
                mView.failure(msg);
            }
        });
    }
}
