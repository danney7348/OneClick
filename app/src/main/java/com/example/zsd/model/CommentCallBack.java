package com.example.zsd.model;

import com.example.zsd.entity.Comment;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface CommentCallBack {
    void getCommentSuccess(Comment comment);
    void getCommentFailure(String msg);
}
