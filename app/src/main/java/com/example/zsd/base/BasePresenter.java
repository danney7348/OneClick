package com.example.zsd.base;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class BasePresenter<V> {
    private V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public void deatach(){
        this.mView = null;
    }
}
