package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetVideosDetail;
import com.example.zsd.model.GetVideosDetailCallBack;
import com.example.zsd.model.GetVideosDetailModel;
import com.example.zsd.view.GetVideosDetailView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVideosDetailPresenter extends BasePresenter<GetVideosDetailView> {
    private GetVideosDetailModel getVideosDetailModel;
    public GetVideosDetailPresenter(GetVideosDetailView mView) {
        super(mView);
        if(getVideosDetailModel == null){
            getVideosDetailModel = new GetVideosDetailModel();
        }
    }
    public void getVideosDetailData(String wid){
        getVideosDetailModel.getVideosDetail(wid, new GetVideosDetailCallBack() {
            @Override
            public void getVideosDetailSuccess(GetVideosDetail getVideosDetail) {
                mView.getVideosDetailSuccess(getVideosDetail);
            }

            @Override
            public void getVideosDetailFailure(String msg) {
                mView.getVideosDetailFailure(msg);
            }
        });
    }
}
