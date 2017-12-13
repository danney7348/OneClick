package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.CommentJoke;

/**
 * 作者： 张少丹
 * 时间：  2017/12/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface CommentJokeView extends BaseView {
    void getCommentJokeSuccess(CommentJoke commentJoke);
    void getCommentJokeFailure(String msg);
}
