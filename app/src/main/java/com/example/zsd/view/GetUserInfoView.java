package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.GetUserInfo;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetUserInfoView extends BaseView {
   public void getUserInfoSuccess(GetUserInfo value);
   public void getUserInfoFaile(String string);
}
