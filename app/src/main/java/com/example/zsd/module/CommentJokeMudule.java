package com.example.zsd.module;

import com.example.zsd.view.CommentJokeView;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： 张少丹
 * 时间：  2017/12/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

@Module
public class CommentJokeMudule {
    private CommentJokeView commentJokeView;

    public CommentJokeMudule(CommentJokeView commentJokeView) {
        this.commentJokeView = commentJokeView;
    }
    @Provides
    CommentJokeView commentJokeView(){
        return  commentJokeView;
    }
}
