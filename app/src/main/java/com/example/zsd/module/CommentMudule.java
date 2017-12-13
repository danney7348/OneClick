package com.example.zsd.module;

import com.example.zsd.view.CommentView;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： 张少丹
 * 时间：  2017/12/12.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

@Module
public class CommentMudule {

    private CommentView commentView;

    public CommentMudule(CommentView commentView) {
        this.commentView = commentView;
    }

    @Provides
    CommentView commentView(){
        return commentView;
    }
}
