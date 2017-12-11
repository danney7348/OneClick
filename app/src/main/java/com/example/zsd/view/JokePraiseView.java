package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.JokePraise;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface JokePraiseView extends BaseView {
    void getJokePraiseSuccess(JokePraise jokePraise);
    void getJokePraiseFailure(String msg);
}
