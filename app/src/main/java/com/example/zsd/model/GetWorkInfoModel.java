package com.example.zsd.model;

import android.widget.Toast;

import com.example.zsd.entity.GetWorkInfo;
import com.example.zsd.utils.HttpUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetWorkInfoModel implements IGetWorkInfoModel {
    @Inject
    public GetWorkInfoModel() {
    }
    @Override
    public void getWorkInfoData(String uid, final GetWorkInfoCallBack getWorkInfoCallBack) {
        System.out.println("getWorkInfoData ===================== ");
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getWorkInfo(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<GetWorkInfo>() {
                    @Override
                    public void onNext(GetWorkInfo getWorkInfo) {
                        if(getWorkInfo.code.equals("0")){
                            getWorkInfoCallBack.getWorkInfoSuccess(getWorkInfo);
                        }else {
                            getWorkInfoCallBack.getWorkInfoFailure(getWorkInfo.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        getWorkInfoCallBack.getWorkInfoFailure(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
