package com.example.zsd.model;

import com.example.zsd.entity.RemoveFavourite;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface RemoveFavouriteCallBack {
    void getRemoveFavouriteSuccess(RemoveFavourite removeFavourite);
    void getRemoveFavouriteFailure(String msg);
}
