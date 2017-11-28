package com.example.zsd.model;

import com.example.zsd.entity.GetVideos;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVideosModel {
    public void getVideosData(String uid, String type, String page, final GetVideosMessage getVideosMessage){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getVideos(uid,type,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetVideos>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetVideos value) {
                        getVideosMessage.getVideosSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getVideosMessage.getVideosFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface GetVideosMessage{
        void getVideosSuccess(GetVideos value);
        void getVideosFailure(Throwable e);
    }
}
