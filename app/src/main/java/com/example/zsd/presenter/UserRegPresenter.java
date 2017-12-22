package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.model.UserRegModel;
import com.example.zsd.view.UserRegView;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class UserRegPresenter extends BasePresenter {
    private UserRegModel userRegModel;
    private UserRegView userRegView;
    public UserRegPresenter(UserRegView userRegView) {
        super(userRegView);
        this.userRegView = userRegView;
        if(userRegModel == null){
            userRegModel = new UserRegModel();
        }
    }
    public void getUserRegData(String regType,final String mobile, String password, String token){
        userRegModel.getUserRegData(regType,mobile, password, token, new UserRegModel.UserRegMessage() {
            @Override
            public void userregSuccess(ResponseBody value) {
                String json = null;
                try {
                    json = value.string().toString();
                    JSONObject jsonObject=new JSONObject(json);
                    String code = jsonObject.getString("code");
                    String msg = jsonObject.getString("msg");
                    if(code.equals("0")){
                        userRegView.userregSuccess(msg);
                    }else {
                        userRegView.userregFailue(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void userregFailue(Throwable e) {
                userRegView.failure("");
            }
        });
    }
}
