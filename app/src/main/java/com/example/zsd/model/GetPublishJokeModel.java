package com.example.zsd.model;

import com.example.zsd.entity.PublishJoke;
import com.example.zsd.service.ApiService;
import com.example.zsd.utils.HttpUtils;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetPublishJokeModel {
    public void getPublishJoke(String uid, String content, List<String> jokeFiles, final GetPublishJokeMessage getPublishJokeMessage){
        HttpUtils build = new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build();
        System.out.println("build = " + build.toString());
        ApiService myQusetUtils = build.getMyQusetUtils();
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        builder.addFormDataPart("uid",uid+"");
        builder.addFormDataPart("content",content);
        for (int i = 0; i < jokeFiles.size(); i++) {
            File file = new File(jokeFiles.get(i));
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
            builder.addFormDataPart("jokeFiles", file.getName(), requestBody);
        }
        List<MultipartBody.Part> parts = builder.build().parts();
        Observable<PublishJoke> publishJoke = myQusetUtils.getPublishJoke(parts);
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
