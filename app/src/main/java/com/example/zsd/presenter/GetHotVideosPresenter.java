package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetHotVideos;
import com.example.zsd.model.GetHotVideosCallBack;
import com.example.zsd.model.GetHotVideosModel;
import com.example.zsd.view.GetHotVideosView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/5.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetHotVideosPresenter extends BasePresenter<GetHotVideosView> {
    private GetHotVideosModel getHotVideosModel;
    public GetHotVideosPresenter(GetHotVideosView mView) {
        super(mView);
        if(getHotVideosModel == null){
            getHotVideosModel = new GetHotVideosModel();
        }
    }
    public void getHotVideosData(String page){
        getHotVideosModel.getHotVideosData(page, new GetHotVideosCallBack() {
            @Override
            public void getHotVideosSuccess(GetHotVideos data) {
                if(data != null){
                    mView.success(data);
                }
            }
            @Override
            public void getHotVideosFailure(String msg) {
                mView.failure(msg);
            }
        });
    }
}
