package com.example.zsd.model;

import com.example.zsd.entity.GetUserVideos;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetUserVideosModel {
    public void getUsesrVideos(String uid,String page){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
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
                            getUserVideosMessage.getUserVideosSuccess(value);
                        }else {
                            getUserVideosMessage.getUserVideosFailure(value.msg);
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
        void getUserVideosSuccess(GetUserVideos value);
        void getUserVideosFailure(String msg);
    }
}
