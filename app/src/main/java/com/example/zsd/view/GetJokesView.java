package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.GetJokes;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetJokesView extends BaseView {
    void getJokesSuccess(GetJokes value);
    void getJokesFailure(String e);
}
