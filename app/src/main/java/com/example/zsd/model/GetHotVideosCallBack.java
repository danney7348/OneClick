package com.example.zsd.model;

import com.example.zsd.entity.GetHotVideos;

/**
 * 作者： 张少丹
 * 时间：  2017/12/5.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetHotVideosCallBack {
    void getHotVideosSuccess(GetHotVideos data);
    void getHotVideosFailure(String msg);
}
