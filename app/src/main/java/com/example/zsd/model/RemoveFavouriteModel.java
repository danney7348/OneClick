package com.example.zsd.model;

import com.example.zsd.entity.RemoveFavourite;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RemoveFavouriteModel {
    public void getRemoveFavouriteData(String uid, String fid, final RemoveFavouriteCallBack removeFavouriteCallBack){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getRemoveFavorite(uid,fid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<RemoveFavourite>() {
                    @Override
                    public void onNext(RemoveFavourite removeFavourite) {
                        if(removeFavourite.code.equals("0")){
                            removeFavouriteCallBack.getRemoveFavouriteSuccess(removeFavourite);
                        }else {
                            removeFavouriteCallBack.getRemoveFavouriteFailure(removeFavourite.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        removeFavouriteCallBack.getRemoveFavouriteFailure(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
