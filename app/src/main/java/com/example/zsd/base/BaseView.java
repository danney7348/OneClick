package com.example.zsd.base;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface BaseView<T> {

    void success(T t);
    void error(String msg);
    void failure(String msg);

}
