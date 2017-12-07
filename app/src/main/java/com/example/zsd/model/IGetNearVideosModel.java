package com.example.zsd.model;

/**
 * 作者： 张少丹
 * 时间：  2017/12/6.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface IGetNearVideosModel {
    public void getNearVideosData(String page,String latitude, String longitude,GetNearVideosCallBack getNearVideosCallBack);
}

