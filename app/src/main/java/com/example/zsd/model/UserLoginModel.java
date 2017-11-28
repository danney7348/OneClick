package com.example.zsd.model;

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
    public void getUserLoginData(String mobile, String password, String taken, final UserLoginMessage userLoginMessage){
        new HttpUtils.Builder().addConverterFactory()
                .addCallAdapterFactory().build().getMyQusetUtils().getUserLogin(mobile,password,null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(ResponseBody value) {
                        String json = null;
                        try {
                            json = value.string().toString();
                            JSONObject jsonObject=new JSONObject(json);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");
                            userLoginMessage.userloginSuccess(code,msg);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        userLoginMessage.userloginFailue(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface UserLoginMessage{
        void userloginSuccess(String msg,String code);
        void userloginFailue(Throwable e);
    }
}
