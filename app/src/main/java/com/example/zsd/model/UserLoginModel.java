package com.example.zsd.model;

import com.example.zsd.entity.LoginBean;
import com.example.zsd.presenter.UserLoginPresenter;
import com.example.zsd.service.ApiService;
import com.example.zsd.utils.HttpUtils;

import org.json.JSONObject;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class UserLoginModel {


    public UserLoginMessage userLoginMessage;

    public UserLoginModel(UserLoginMessage userLoginMessage) {
        this.userLoginMessage = userLoginMessage;
    }

    public void getUserLoginData(String mobile, String password){
        new HttpUtils.Builder().addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getUserLogin(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(LoginBean value) {
                        System.out.println(value);
                        if ("0".equals(value.code)){

                            userLoginMessage.userloginSuccess(value);
                        }else {
                            userLoginMessage.userLoginError(value.msg);
                        }
                }

                    @Override
                    public void onError(Throwable e) {
                        userLoginMessage.userloginFailue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface UserLoginMessage{
        void userloginSuccess(LoginBean loginBean);
        void userloginFailue(String e);
        void userLoginError(String e);
    }
}
