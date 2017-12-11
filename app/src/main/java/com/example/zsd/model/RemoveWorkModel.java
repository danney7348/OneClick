package com.example.zsd.model;

import com.example.zsd.entity.RemoveWork;
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

public class RemoveWorkModel implements IRemoveWorkModel {
    @Override
    public void getRemoveWorkData(String uid, String wid, final RemoveWorkCallBack removeWorkCallBack) {
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getRemoveWork(uid,wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RemoveWork>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RemoveWork removeWork) {

                        if(removeWork.code.equals("0")){
                            removeWorkCallBack.removeWorkScuuess(removeWork);
                        }else {
                            removeWorkCallBack.removeWorkFailure(removeWork.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                        removeWorkCallBack.removeWorkFailure(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
