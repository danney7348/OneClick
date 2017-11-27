package com.example.zsd.view;

import com.example.zsd.base.BaseView;

import retrofit2.Response;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface UserLoginView extends BaseView{
    void userloginSuccess(String string);
    void userloginFailue(String string);
}
