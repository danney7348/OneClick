package com.example.zsd.view;

import com.example.zsd.base.BaseView;
import com.example.zsd.entity.PublishJoke;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface GetPublishJokeView extends BaseView {
        void getPublishJokeSuccess(PublishJoke value);
        void getPublishJokeFaliure(String s);
        void getPublishJokeTokenFaliure(String s);
}
