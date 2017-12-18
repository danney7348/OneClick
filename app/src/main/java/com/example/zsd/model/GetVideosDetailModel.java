package com.example.zsd.model;

import com.example.zsd.entity.GetVideosDetail;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVideosDetailModel implements IGetVideosDetailModel{
    @Override
    public void getVideosDetail(String wid, final GetVideosDetailCallBack getVideosDetailCallBack) {
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getVideosDetail(wid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<GetVideosDetail>() {
                    @Override
                    public void onNext(GetVideosDetail getVideosDetail) {
                        if(getVideosDetail.code.equals("0")){
                            getVideosDetailCallBack.getVideosDetailSuccess(getVideosDetail);
                        }else {
                            getVideosDetailCallBack.getVideosDetailFailure(getVideosDetail.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        getVideosDetailCallBack.getVideosDetailFailure(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
