package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.LoginBean;
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

public class UserLoginPresenter  extends BasePresenter<UserLoginView> implements UserLoginModel.UserLoginMessage{
    private UserLoginModel userLoginModel;


    public UserLoginPresenter(UserLoginView userLoginView) {
        super(userLoginView);
            userLoginModel = new UserLoginModel(this);

    }

    public void getUserLoginData(String mobile, String password) {
        userLoginModel.getUserLoginData(mobile, password);
    }




    @Override
    public void userloginSuccess(LoginBean loginBean) {
        mView.success(loginBean);
    }

    @Override
    public void userloginFailue(String e) {
        mView.failure(e);
    }

    @Override
    public void userLoginError(String e) {
        mView.error(e);
    }


}
