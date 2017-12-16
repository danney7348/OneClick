package com.example.zsd.model;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface IResetPassModel {
    void getResetPassData(String uid,String oldPassword,String newPassword,ResetPassCallBack resetPassCallBack);
}
