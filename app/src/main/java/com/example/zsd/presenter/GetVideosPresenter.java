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

public class GetVideosPresenter extends BasePresenter {
    private GetVideosModel getVideosModel;
    private GetVideosView getVideosView;
    public GetVideosPresenter(GetVideosView getVideosView) {
        super(getVideosView);
        this.getVideosView = getVideosView;
        if(getVideosModel == null){
            getVideosModel = new GetVideosModel();
        }
    }
    public void getVideosData(String uid,String type,String page){
        getVideosModel.getVideosData(uid, type, page, new GetVideosModel.GetVideosMessage() {
            @Override
            public void getVideosSuccess(GetVideos value) {
                String code = value.code;
                if(code.equals("0")){
                    getVideosView.getVideosSuccess(value);
                }else {
                    getVideosView.getVideosFailure(value.msg);
                }
            }
            @Override
            public void getVideosFailure(Throwable e) {
                getVideosView.failure("");
            }
        });
    }
}
