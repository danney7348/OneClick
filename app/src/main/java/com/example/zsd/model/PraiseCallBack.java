package com.example.zsd.model;

import com.example.zsd.entity.Praise;

/**
 * 作者： 张少丹
 * 时间：  2017/12/8.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface PraiseCallBack {
    void getPraiseSuccess(Praise praise);
    void getPraiseFailure(String msg);
}
