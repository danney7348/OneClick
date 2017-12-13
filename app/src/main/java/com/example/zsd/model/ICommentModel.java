package com.example.zsd.model;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface ICommentModel {
    void getCommentData(String uid,String wid,String content,CommentCallBack commentCallBack);
}
