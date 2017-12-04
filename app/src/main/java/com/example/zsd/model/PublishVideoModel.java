package com.example.zsd.model;

import com.example.zsd.entity.PublishVideo;
import com.example.zsd.service.ApiService;
import com.example.zsd.utils.HttpUtils;

import java.io.File;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 作者： 张少丹
 * 时间：  2017/12/4.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class PublishVideoModel {
    /**
     * uid
     videoFile
     coverFile
     videoDesc
     latitude
     longitude

     */
    public void getPublishVideoData(String uid,File videoFile,File coverFile,String videoDesc,String latitude,String longitude){

        ApiService myQusetUtils = new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils();
        /**
         * uid
         videoFile
         coverFile
         videoDesc
         latitude
         longitude

         */
        MultipartBody.Builder build = new MultipartBody.Builder().setType(MultipartBody.FORM);
        build.addFormDataPart("uid",uid);
        build.addFormDataPart("videoDesc",videoDesc);
        build.addFormDataPart("latitude",latitude);
        build.addFormDataPart("longitude",longitude);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), videoFile);
        build.addFormDataPart("videoFile", videoFile.getName(), requestFile);
        RequestBody re = RequestBody.create(MediaType.parse("multipart/form-data"), coverFile);
        build.addFormDataPart("coverFile", coverFile.getName(),re);
        List<MultipartBody.Part> parts = build.build().parts();
        myQusetUtils.getPublishVideo(parts)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PublishVideo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PublishVideo publishVideo) {

                        if(publishVideo.code.equals("0")){
                            getPublishVideoMessage.getPublishVideoSuccess(publishVideo);
                        }else {
                            getPublishVideoMessage.getPublishVideoFailure(publishVideo.msg);
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
    private GetPublishVideoMessage getPublishVideoMessage;

    public void setGetPublishVideoMessage(GetPublishVideoMessage getPublishVideoMessage) {
        this.getPublishVideoMessage = getPublishVideoMessage;
    }

    public interface GetPublishVideoMessage{
        void getPublishVideoSuccess(PublishVideo publishVideo);
        void getPublishVideoFailure(String msg);
    }
}
