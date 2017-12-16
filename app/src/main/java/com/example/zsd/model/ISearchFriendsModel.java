package com.example.zsd.model;

import com.example.zsd.entity.SearchFriends;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface ISearchFriendsModel {
    void getSearchFridendsData(String keywords,String page,SearchFridendsCallBack searchFridendsCallBack);
}
