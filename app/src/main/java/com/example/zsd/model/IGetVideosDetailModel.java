package com.example.zsd.model;

import android.view.View;

import com.example.zsd.entity.GetVideosDetail;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface IGetVideosDetailModel {
    void getVideosDetail(String wid, GetVideosDetailCallBack getVideosDetailCallBack);
}
