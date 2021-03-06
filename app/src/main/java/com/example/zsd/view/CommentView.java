package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.Comment;

/**
 * 作者： 张少丹
 * 时间：  2017/12/12.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface CommentView extends BaseView {
    void getCommentSuccess(Comment comment);
    void getCommentFailure(String msg);
}
