package com.example.zsd.model;

import com.example.zsd.entity.JokePraise;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class JokePraiseModel implements IJokePraiseModel {

    @Override
    public void getJokePraiseData(String uid, String jid, final JokePraiseCallBack jokePraiseCallBack) {
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getJokePraise(uid,jid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokePraise>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JokePraise jokePraise) {
                        if(jokePraise.code.equals("0")){
                            jokePraiseCallBack.getJokePraiseSuccess(jokePraise);
                        }else {
                            jokePraiseCallBack.getJokePraiseFailure(jokePraise.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                            jokePraiseCallBack.getJokePraiseFailure(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
