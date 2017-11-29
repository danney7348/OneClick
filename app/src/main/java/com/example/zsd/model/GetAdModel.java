package com.example.zsd.model;

import com.example.zsd.utils.HttpUtils;
import com.example.zsd.entity.GetAd;;
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

public class GetAdModel {
    public void getAd(){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getAd()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetAd>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetAd value) {
                        String code = value.code;
                        if(code.equals("0")){
                            getAdMessage.getAdSuccess(value);
                        }else {
                            getAdMessage.getAdFailure(value.msg);
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
    private GetAdMessage getAdMessage;

    public void setGetAdMessage(GetAdMessage getAdMessage) {
        this.getAdMessage = getAdMessage;
    }

    public interface GetAdMessage{
        void getAdSuccess(GetAd value);
        void getAdFailure(String msg);
    }
}
