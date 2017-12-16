package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetWorkInfo;
import com.example.zsd.model.GetWorkInfoCallBack;
import com.example.zsd.model.GetWorkInfoModel;
import com.example.zsd.view.GetWorkInfoView;

import javax.inject.Inject;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetWorkInfoPresenter extends BasePresenter<GetWorkInfoView> {

    @Inject
    GetWorkInfoModel getWorkInfoModel;

    @Inject
    public GetWorkInfoPresenter(GetWorkInfoView mView) {
        super(mView);
    }
    public void getWorkInfoData(String uid){
        System.out.println("getWorkInfoData====================== = " + uid);
        if(getWorkInfoModel == null){
            getWorkInfoModel = new GetWorkInfoModel();
        }
        getWorkInfoModel.getWorkInfoData(uid, new GetWorkInfoCallBack() {

            @Override
            public void getWorkInfoSuccess(GetWorkInfo getWorkInfo) {
                mView.getWorkInfoSuccess(getWorkInfo);
                System.out.println("getWorkInfoData====================== = " );
            }

            @Override
            public void getWorkInfoFailure(String msg) {
                mView.getWorkInfoFailure(msg);
            }
        });
    }
}
