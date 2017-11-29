package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetUserInfo;
import com.example.zsd.model.GetUserInfoModel;
import com.example.zsd.view.GetUserInfoView;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetUserInfoPresenter extends BasePresenter {
    private GetUserInfoModel getUserInfoModel;
    private GetUserInfoView getUserInfoView;
    public GetUserInfoPresenter(GetUserInfoView getUserInfoView) {
        super(getUserInfoView);
        this.getUserInfoView = getUserInfoView;
        if(getUserInfoModel == null){
            getUserInfoModel = new GetUserInfoModel();
        }
    }
    public void getUserInfoData(String uid,String token){
        getUserInfoModel.getUserInfoData(uid, token, new GetUserInfoModel.GetUserInfoMessage() {
            @Override
            public void getUserInfoSuccess(GetUserInfo value) {
                String code = value.code;
                if(code.equals("0")){
                    getUserInfoView.getUserInfoSuccess(value);
                }else {
                    getUserInfoView.getUserInfoFaile(value.msg);
                }
            }

            @Override
            public void getUserInfoFaile(Throwable e) {

                getUserInfoView.failure("");
            }
        });
    }
}
