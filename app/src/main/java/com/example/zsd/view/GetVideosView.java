package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.GetVideos;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetVideosView extends BaseView {
    void getVideosSuccess(GetVideos value);
    void getVideosFailure(String e);
}
