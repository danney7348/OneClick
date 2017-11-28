package com.example.zsd.model;

import com.example.zsd.entity.GetUserInfo;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetUserInfoModel {
    public void getUserInfoData(String uid, String token, final GetUserInfoMessage getUserInfoMessage){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getUserInfo(uid,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetUserInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetUserInfo value) {
                        getUserInfoMessage.getUserInfoSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getUserInfoMessage.getUserInfoFaile(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface GetUserInfoMessage{
        void getUserInfoSuccess(GetUserInfo value);
        void getUserInfoFaile(Throwable e);
    }
}
