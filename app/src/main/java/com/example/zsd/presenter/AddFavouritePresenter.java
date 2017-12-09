package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.AddFavourite;
import com.example.zsd.model.AddFavouriteCallBack;
import com.example.zsd.model.AddFavouriteModel;
import com.example.zsd.view.AddFavouriteView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/8.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class AddFavouritePresenter extends BasePresenter<AddFavouriteView> {
    private AddFavouriteModel addFavouriteModel;
    public AddFavouritePresenter(AddFavouriteView mView) {
        super(mView);
        if(addFavouriteModel == null){
            addFavouriteModel = new AddFavouriteModel();
        }
    }
    public void getAddFavouriteData(String uid, String wid){
        addFavouriteModel.getAddFavouriteData(uid, wid, new AddFavouriteCallBack() {
            @Override
            public void addFavouriteSuccess(AddFavourite addFavourite) {
                mView.addFavouriteSuccess(addFavourite);
            }

            @Override
            public void addFavouriteFailure(String msg) {
                mView.addFavouriteFailure(msg);
            }
        });
    }
}
