package com.example.zsd.model;

import com.example.zsd.entity.AddFavourite;
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

public class AddFavouriteModel implements IAddFavouriteModel {
    @Override
    public void getAddFavouriteData(String uid, String wid, final AddFavouriteCallBack addFavouriteCallBack) {
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getAddFavoourite(uid,wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddFavourite>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddFavourite addFavourite) {

                        if(addFavourite.code.equals("0")){
                            addFavouriteCallBack.addFavouriteSuccess(addFavourite);
                        }else {
                            addFavouriteCallBack.addFavouriteFailure(addFavourite.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        addFavouriteCallBack.addFavouriteFailure(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
