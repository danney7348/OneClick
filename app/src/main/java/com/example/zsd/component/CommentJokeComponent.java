package com.example.zsd.component;

import com.example.zsd.fragment.DuanziFragment;
import com.example.zsd.module.CommentJokeMudule;

import dagger.Component;
import dagger.Module;

/**
 * 作者： 张少丹
 * 时间：  2017/12/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

@Component(modules = CommentJokeMudule.class)
public interface CommentJokeComponent {
    void inject(DuanziFragment duanziFragment);
}
