package com.example.zsd.module;

import com.example.zsd.view.GetWorkInfoView;

import dagger.Module;
import dagger.Provides;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */
@Module
public class GetWorkInfoMudule {
    private GetWorkInfoView getWorkInfoView;

    public GetWorkInfoMudule(GetWorkInfoView getWorkInfoView) {
        this.getWorkInfoView = getWorkInfoView;
    }
    @Provides
    GetWorkInfoView getWorkInfoView(){
        return getWorkInfoView;
    }
}
