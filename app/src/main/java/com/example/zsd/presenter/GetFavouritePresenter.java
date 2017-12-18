package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.base.BaseView;
import com.example.zsd.entity.GetFavorites;
import com.example.zsd.model.GetFavoritesCallBack;
import com.example.zsd.model.GetFavoritesModel;
import com.example.zsd.view.GetFavouriteView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetFavouritePresenter extends BasePresenter<GetFavouriteView> {
    private GetFavoritesModel getFavoritesModel;
    public GetFavouritePresenter(GetFavouriteView mView) {
        super(mView);
        if(getFavoritesModel == null){
            getFavoritesModel = new GetFavoritesModel();
        }
    }
    public void getFavouriteData(String uid){
        getFavoritesModel.getFavoritesData(uid, new GetFavoritesCallBack() {
            @Override
            public void getFavoritesSuccess(GetFavorites getFavorites) {
                mView.getFavoritesSuccess(getFavorites);
            }

            @Override
            public void getFavoritesFailure(String msg) {
                mView.getFavoritesFailure(msg);
            }
        });
    }
}
