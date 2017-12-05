package com.example.zsd.model;

import com.example.zsd.entity.GetHotVideos;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/12/5.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetHotVideosModel implements IGetHotVideosModel {
    @Override
    public void getHotVideosData(String page, final GetHotVideosCallBack getHotVideosCallBack) {
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getHotVideos(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetHotVideos>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetHotVideos getHotVideos) {


                        if(getHotVideos.code.equals("0")){
                            getHotVideosCallBack.getHotVideosSuccess(getHotVideos);
                        }else {
                            getHotVideosCallBack.getHotVideosFailure(getHotVideos.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                        getHotVideosCallBack.getHotVideosFailure(e.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
