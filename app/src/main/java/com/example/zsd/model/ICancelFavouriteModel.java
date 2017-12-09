package com.example.zsd.model;

/**
 * 作者： 张少丹
 * 时间：  2017/12/8.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface ICancelFavouriteModel {
    public void getCancelFavouriteData(String uid, String wid, CancelFavouriteCallBack cancelFavouriteCallBack);
}
