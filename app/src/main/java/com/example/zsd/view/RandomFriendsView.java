package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.RandomFriends;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface RandomFriendsView extends BaseView {
    void getRandomFriendsSuccess(RandomFriends randomFriends);
    void getRandomFriendsFailure(String msg);
}
