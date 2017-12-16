package com.example.zsd.model;

import com.example.zsd.entity.ResetPass;
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

public class ResetPassModel implements IResetPassModel {
    @Override
    public void getResetPassData(String uid, String oldPassword, String newPassword, final ResetPassCallBack resetPassCallBack) {
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getResetPass(uid,oldPassword,newPassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ResetPass>() {
                    @Override
                    public void onNext(ResetPass resetPass) {
                        if(resetPass.code.equals("0")){
                            resetPassCallBack.getResetPassSuccess(resetPass);
                        }else {
                            resetPassCallBack.getResetPassFailure(resetPass.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        resetPassCallBack.getResetPassFailure(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
