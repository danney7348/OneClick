package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.ResetPass;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface ResetPassView extends BaseView {
    void getResetPassSuccess(ResetPass resetPass);
    void getResetPassFailure(String msg);
}
