package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.model.UserLoginModel;
import com.example.zsd.view.UserLoginView;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class UserLoginPresenter extends BasePresenter {
    private UserLoginModel userLoginModel;
    private UserLoginView userLoginView;

    public UserLoginPresenter(UserLoginView userLoginView) {
        super(userLoginView);
        this.userLoginView = userLoginView;
        if(userLoginModel == null){
            userLoginModel = new UserLoginModel();
        }
    }

    public void getUserLoginData(String mobile,String password,String taken){
        userLoginModel.getUserLoginData(mobile, password, taken, new UserLoginModel.UserLoginMessage() {
            @Override
            public void userloginSuccess(ResponseBody value) {
                try {
                    String json = value.string().toString();
                    JSONObject jsonObject=new JSONObject(json);
                    String code = jsonObject.getString("code");
                    String msg = jsonObject.getString("msg");
                    if(code.equals("0")){
                        userLoginView.userloginSuccess(value.string().toString());
                    }else {
                        userLoginView.userloginFailue(value.string().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void userloginFailue(Throwable e) {
                userLoginView.failure();
            }
        });
    }
}
