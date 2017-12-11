package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.JokePraise;
import com.example.zsd.model.JokePraiseCallBack;
import com.example.zsd.model.JokePraiseModel;
import com.example.zsd.view.JokePraiseView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class JokePraisePresenter extends BasePresenter<JokePraiseView> {
    private JokePraiseModel jokePraiseModel;
    public JokePraisePresenter(JokePraiseView mView) {
        super(mView);
        if(jokePraiseModel == null){
            jokePraiseModel = new JokePraiseModel();
        }
    }
    public void getJokePraiseData(String uid,String jid){
        jokePraiseModel.getJokePraiseData(uid, jid, new JokePraiseCallBack() {
            @Override
            public void getJokePraiseSuccess(JokePraise jokePraise) {
                mView.getJokePraiseSuccess(jokePraise);
            }

            @Override
            public void getJokePraiseFailure(String msg) {
                mView.getJokePraiseFailure(msg);
            }
        });
    }
}
