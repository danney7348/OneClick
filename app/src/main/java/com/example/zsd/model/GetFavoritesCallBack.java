package com.example.zsd.model;

import com.example.zsd.entity.GetFavorites;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetFavoritesCallBack {
    void getFavoritesSuccess(GetFavorites getFavorites);
    void getFavoritesFailure(String msg);
}
