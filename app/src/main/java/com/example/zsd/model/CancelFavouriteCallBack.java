package com.example.zsd.model;

import com.example.zsd.entity.AddFavourite;
import com.example.zsd.entity.CancelFavourite;

/**
 * 作者： 张少丹
 * 时间：  2017/12/8.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface CancelFavouriteCallBack {
    void cancelFavouriteSuccess(CancelFavourite cancelFavourite);
    void cancelFavouriteFailure(String msg);
}
