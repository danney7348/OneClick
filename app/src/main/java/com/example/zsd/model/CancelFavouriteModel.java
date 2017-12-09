package com.example.zsd.model;

import com.example.zsd.entity.AddFavourite;
import com.example.zsd.entity.CancelFavourite;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/12/8.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class CancelFavouriteModel implements ICancelFavouriteModel {
    @Override
    public void getCancelFavouriteData(String uid, String wid, final CancelFavouriteCallBack cancelFavouriteCallBack) {
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getCancelFavoourite(uid,wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CancelFavourite>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CancelFavourite cancelFavourite) {

                        if(cancelFavourite.code.equals("0")){
                            cancelFavouriteCallBack.cancelFavouriteSuccess(cancelFavourite);
                        }else {
                            cancelFavouriteCallBack.cancelFavouriteFailure(cancelFavourite.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        cancelFavouriteCallBack.cancelFavouriteFailure(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
