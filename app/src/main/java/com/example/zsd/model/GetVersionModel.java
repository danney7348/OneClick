package com.example.zsd.model;

import com.example.zsd.entity.GetAd;
import com.example.zsd.entity.GetUserVideos;
import com.example.zsd.entity.GetVersion;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/11/29.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVersionModel {
    public void getVersionData(String uid,String page){
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getVersion()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetVersion>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetVersion value) {

                        String code = value.code;
                        if(code.equals("0")){
                            getVersionMessage.getVersionSuccess(value);
                        }else {
                            getVersionMessage.getVersionFailure(value.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    private GetVersionMessage getVersionMessage;

    public void setGetVersionMessage(GetVersionMessage getVersionMessage) {
        this.getVersionMessage = getVersionMessage;
    }

    public interface GetVersionMessage{
        void getVersionSuccess(GetVersion value);
        void getVersionFailure(String msg);
    }
}
