package com.example.zsd.model;

import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class UserRegModel {
    public void getUserRegData(String regType,String mobile, String password, String token, final UserRegMessage userRegMessage){
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getUserReg(regType,mobile,password,token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        userRegMessage.userregSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        userRegMessage.userregFailue(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface UserRegMessage{
        void userregSuccess(ResponseBody value);
        void userregFailue(Throwable e);
    }
}
