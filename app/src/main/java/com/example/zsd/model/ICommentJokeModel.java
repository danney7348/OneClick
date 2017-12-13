package com.example.zsd.model;

/**
 * 作者： 张少丹
 * 时间：  2017/12/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface ICommentJokeModel {
        void getCommentJoke(String uid,String jid,String content,CommentJokeCallBack commentJokeCallBack);
}
