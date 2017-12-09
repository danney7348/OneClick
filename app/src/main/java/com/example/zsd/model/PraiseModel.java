package com.example.zsd.model;

import com.example.zsd.entity.Praise;
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

public class PraiseModel implements IPraiseModel {
    @Override
    public void getPraiseData(String uid, String wid, final PraiseCallBack praiseCallBack) {
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getPraise(uid,wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Praise>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Praise praise) {

                        if(praise.code.equals("0")){
                            praiseCallBack.getPraiseSuccess(praise);
                        }else {
                            praiseCallBack.getPraiseFailure(praise.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        praiseCallBack.getPraiseFailure(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
