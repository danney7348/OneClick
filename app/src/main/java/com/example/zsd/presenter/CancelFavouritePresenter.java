package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.AddFavourite;
import com.example.zsd.entity.CancelFavourite;
import com.example.zsd.model.AddFavouriteCallBack;
import com.example.zsd.model.AddFavouriteModel;
import com.example.zsd.model.CancelFavouriteCallBack;
import com.example.zsd.model.CancelFavouriteModel;
import com.example.zsd.view.AddFavouriteView;
import com.example.zsd.view.CancelFavouriteView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/8.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class CancelFavouritePresenter extends BasePresenter<CancelFavouriteView> {
    private CancelFavouriteModel cancelFavouriteModel;
    public CancelFavouritePresenter(CancelFavouriteView mView) {
        super(mView);
        if(cancelFavouriteModel == null){
            cancelFavouriteModel = new CancelFavouriteModel();
        }
    }
    public void getAddFavouriteData(String uid, String wid){
        cancelFavouriteModel.getCancelFavouriteData(uid, wid, new CancelFavouriteCallBack() {
            @Override
            public void cancelFavouriteSuccess(CancelFavourite cancelFavourite) {
                mView.cancelFavouriteSuccess(cancelFavourite);
            }

            @Override
            public void cancelFavouriteFailure(String msg) {
                mView.cancelFavouriteFailure(msg);
            }
        });
    }
}
