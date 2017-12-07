package com.example.zsd.model;

import com.example.zsd.entity.GetNearVideos;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/12/6.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetNearVideosModel implements IGetNearVideosModel {
    @Override
    public void getNearVideosData(String page, String latitude, String longitude, final GetNearVideosCallBack getNearVideosCallBack) {

        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getNearVideos(page,latitude,longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetNearVideos>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetNearVideos getNearVideos) {

                        if(getNearVideos.code.equals("0")){
                            getNearVideosCallBack.getNearVideosSuccess(getNearVideos);
                        }else{
                            getNearVideosCallBack.getNearVideosFailure(getNearVideos.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        getNearVideosCallBack.getNearVideosFailure(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
