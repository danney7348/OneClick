package com.example.zsd.model;

import com.example.zsd.utils.HttpUtils;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetUserVideos {
    public void getUsesrVideos(String uid,String page){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()

    }
}
