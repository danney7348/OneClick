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
                .getUserVideos(uid,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetUserVideos>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetUserVideos value) {

                        String code = value.code;
                        if(code.equals("0")){
                            getUserVideosMessage.getVersionSuccess(value);
                        }else {
                            getUserVideosMessage.getVersionFailure(value.msg);
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
    private GetUserVideosMessage getUserVideosMessage;

    public void setGetUserVideosMessage(GetUserVideosMessage getUserVideosMessage) {
        this.getUserVideosMessage = getUserVideosMessage;
    }

    public interface GetUserVideosMessage{
        void getVersionSuccess(GetUserVideos value);
        void getVersionFailure(String msg);
    }
}
