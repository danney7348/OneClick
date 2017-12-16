package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.ResetPass;
import com.example.zsd.model.ResetPassCallBack;
import com.example.zsd.model.ResetPassModel;
import com.example.zsd.view.ResetPassView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class ResetPassPresenter extends BasePresenter<ResetPassView> {
    private ResetPassModel resetPassModel;
    public ResetPassPresenter(ResetPassView mView) {
        super(mView);
        if(resetPassModel == null){
            resetPassModel = new ResetPassModel();
        }
    }
    public void getResetPassData(String uid,String oldPassword,String newPassword){
        resetPassModel.getResetPassData(uid, oldPassword, newPassword, new ResetPassCallBack() {
            @Override
            public void getResetPassSuccess(ResetPass resetPass) {
                mView.getResetPassSuccess(resetPass);
            }

            @Override
            public void getResetPassFailure(String msg) {
                mView.getResetPassFailure(msg);
            }
        });
    }
}
