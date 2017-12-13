package com.example.zsd.model;

import com.example.zsd.entity.CommentJoke;

/**
 * 作者： 张少丹
 * 时间：  2017/12/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface CommentJokeCallBack {
    void getCommentJokeSuccess(CommentJoke commentJoke);
    void getCommentJokeFailure(String msg);
}
