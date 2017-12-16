package com.example.zsd.component;


import com.example.zsd.fragment.YiShangchuanFragment;
import com.example.zsd.module.GetWorkInfoMudule;

import dagger.Component;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */
@Component(modules = GetWorkInfoMudule.class)
public interface GetWorkInfoComponent {
    void inject(YiShangchuanFragment yiShangchuanFragment);
}
