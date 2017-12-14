package com.example.zsd.component;

import com.example.zsd.MainActivity;
import com.example.zsd.adapter.RemenRecycleViewAdapter;
import com.example.zsd.entity.Comment;
import com.example.zsd.fragment.DuanziFragment;
import com.example.zsd.fragment.RemenFragment;
import com.example.zsd.fragment.ShipinFragment;
import com.example.zsd.module.CommentMudule;

import dagger.Component;

/**
 * 作者： 张少丹
 * 时间：  2017/12/12.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

@Component(modules = CommentMudule.class)
public interface CommentComponent {
    void inject(RemenFragment remenFragment);
    //void inject1(RemenRecycleViewAdapter adapter);
}
