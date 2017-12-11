package com.example.zsd.model;

import com.example.zsd.entity.RemoveWork;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface RemoveWorkCallBack {
    void removeWorkScuuess(RemoveWork removeWork);
    void removeWorkFailure(String msg);
}
