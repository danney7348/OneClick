package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.GetWorkInfo;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetWorkInfoView extends BaseView{
    void getWorkInfoSuccess(GetWorkInfo getWorkInfo);
    void getWorkInfoFailure(String msg);
}
