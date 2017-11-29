package com.example.zsd.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.zsd.activity.MyApp;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by DELL on 2017/11/27.
 */

public class MyIntercept implements Interceptor {

    private int versionCode;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if(request.method().equals("POST"))
        {

            if(request.body() instanceof FormBody)
            {
                System.out.println("开始添加公共参数");

                PackageManager pm = MyApp.context.getPackageManager();
                PackageInfo pi = null;
                try {
                    pi = pm.getPackageInfo(MyApp.context.getPackageName(), 0);

                    versionCode = pi.versionCode;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                SharedPreferences token = MyApp.context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE);
                String token1 = token.getString("token", "");
                FormBody.Builder builder=new FormBody.Builder();
                //获取原先的body
                FormBody body= (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    builder.add(body.encodedName(i),body.encodedValue(i));

                }
                //添加制定的公共参数到新的boby里,把原先的boby替换掉
                builder.add("source","android")
                .add("appVersion",versionCode+"")
                .add("token",token1);

                /*builder.addEncoded("appVersion",versionCode+"");
                builder.addEncoded("token",token1);*/

                request = request.newBuilder().post(builder.build()).build();
                System.out.println("request = " + chain.proceed(request).toString());
                System.out.println("request = " + chain.proceed(request).body().string());
                System.out.println("token++++++++++"+token1+"++++++++++++++");
            }
        }
        return chain.proceed(request);
    }
}
