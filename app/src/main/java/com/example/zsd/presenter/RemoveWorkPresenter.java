package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.RemoveWork;
import com.example.zsd.model.RemoveWorkCallBack;
import com.example.zsd.model.RemoveWorkModel;
import com.example.zsd.view.RemoveWorkView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RemoveWorkPresenter extends BasePresenter<RemoveWorkView> {
    private RemoveWorkModel removeWorkModel;
    public RemoveWorkPresenter(RemoveWorkView mView) {
        super(mView);
        if(removeWorkModel == null){
            removeWorkModel = new RemoveWorkModel();
        }
    }
    public void getRemoveWorkData(String uid,String wid){
        removeWorkModel.getRemoveWorkData(uid, wid, new RemoveWorkCallBack() {
            @Override
            public void removeWorkScuuess(RemoveWork removeWork) {
                mView.removeWorkScuuess(removeWork);
            }

            @Override
            public void removeWorkFailure(String msg) {
                mView.removeWorkFailure(msg);
            }
        });
    }
}
