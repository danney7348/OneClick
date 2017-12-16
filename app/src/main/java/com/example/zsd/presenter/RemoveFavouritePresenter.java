package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.RemoveFavourite;
import com.example.zsd.model.RemoveFavouriteCallBack;
import com.example.zsd.model.RemoveFavouriteModel;
import com.example.zsd.view.RemoveFavouriteView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RemoveFavouritePresenter extends BasePresenter<RemoveFavouriteView> {
    private RemoveFavouriteModel removeFavouriteModel;
    public RemoveFavouritePresenter(RemoveFavouriteView mView) {
        super(mView);
        if(removeFavouriteModel == null){
            removeFavouriteModel = new RemoveFavouriteModel();
        }
    }
    public void getRemoveFavouriteData(String uid,String fid){
        removeFavouriteModel.getRemoveFavouriteData(uid, fid, new RemoveFavouriteCallBack() {
            @Override
            public void getRemoveFavouriteSuccess(RemoveFavourite removeFavourite) {
                mView.getRemoveFavouriteSuccess(removeFavourite);
            }

            @Override
            public void getRemoveFavouriteFailure(String msg) {
                mView.getRemoveFavouriteFailure(msg);
            }
        });
    }
}
