package com.example.zsd.model;

import com.example.zsd.entity.PublishJoke;
import com.example.zsd.service.ApiService;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observable;
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

public class GetPublishJokeModel {
    public void getPublishJoke(String uid, String content, final GetPublishJokeMessage getPublishJokeMessage){
        HttpUtils build = new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build();
        System.out.println("build = " + build.toString());
        ApiService myQusetUtils = build.getMyQusetUtils();
        System.out.println("myQusetUtils = " + myQusetUtils.toString());
        Observable<PublishJoke> publishJoke = myQusetUtils.getPublishJoke(uid, content);
        publishJoke.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<PublishJoke>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PublishJoke value) {

                        getPublishJokeMessage.getPublishJokeSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getPublishJokeMessage.getPublishJokeFaliure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface GetPublishJokeMessage{
        void getPublishJokeSuccess(PublishJoke value);
        void getPublishJokeFaliure(Throwable e);
    }
}
