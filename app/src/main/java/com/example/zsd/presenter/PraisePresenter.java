package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.Praise;
import com.example.zsd.model.PraiseCallBack;
import com.example.zsd.model.PraiseModel;
import com.example.zsd.view.PraiseView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/8.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class PraisePresenter extends BasePresenter<PraiseView> {
    private PraiseModel praiseModel;
    public PraisePresenter(PraiseView mView) {
        super(mView);
        if(praiseModel == null){
            praiseModel = new PraiseModel();
        }
    }
    public void getPraiseData(String uid,String wid){
        praiseModel.getPraiseData(uid, wid, new PraiseCallBack() {
            @Override
            public void getPraiseSuccess(Praise praise) {
                mView.getPraiseSuccess(praise);
            }

            @Override
            public void getPraiseFailure(String msg) {
                mView.getPraiseFailure(msg);
            }
        });
    }
}
