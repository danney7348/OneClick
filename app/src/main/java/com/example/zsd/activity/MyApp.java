package com.example.zsd.activity;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.igexin.sdk.PushManager;
import com.umeng.analytics.MobclickAgent;

/**
 * 作者： 张少丹
 * 时间：  2017/11/14.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class MyApp extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType. E_UM_NORMAL);
        MobclickAgent. startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this, "5a0a80dea40fa3748200016d", "Channel ID"));
        PushManager.getInstance().initialize(this.getApplicationContext(),DemoPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(),DemoIntentService.class);
    }
}
