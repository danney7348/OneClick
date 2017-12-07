package com.example.zsd.model;

import com.example.zsd.entity.GetNearVideos;

/**
 * 作者： 张少丹
 * 时间：  2017/12/6.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetNearVideosCallBack {
    void getNearVideosSuccess(GetNearVideos getNearVideos);
    void getNearVideosFailure(String msg);
}
