package com.example.zsd.model;

import com.example.zsd.entity.GetFavorites;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetFavoritesModel implements IGetFavoritesModel{

    @Override
    public void getFavoritesData(String uid, final GetFavoritesCallBack favoritesCallBack) {
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getFavorites(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<GetFavorites>() {
                    @Override
                    public void onNext(GetFavorites getFavorites) {
                        if(getFavorites.code.equals("0")){
                            favoritesCallBack.getFavoritesSuccess(getFavorites);
                        }else {
                            favoritesCallBack.getFavoritesFailure(getFavorites.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        favoritesCallBack.getFavoritesFailure(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
