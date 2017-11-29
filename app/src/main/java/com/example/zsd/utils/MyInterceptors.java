package com.example.zsd.utils;

import android.content.Context;
import android.util.Log;

import com.example.zsd.activity.MyApp;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 木子 on 2017/11/27.
 */

public class MyInterceptors implements Interceptor {

    private int versionCode;
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if(request.method().equals("POST"))
        {
            if(request.body() instanceof FormBody)
            {
                FormBody.Builder bodyBuilder=new FormBody.Builder();
                FormBody formBody= (FormBody) request.body();
                for (int i = 0; i < formBody.size(); i++) {
                    bodyBuilder.addEncoded(formBody.encodedName(i),formBody.encodedValue(i));
                }
                formBody=bodyBuilder
                        .addEncoded("source","android")
                        .addEncoded("appVersion","101")
                        .addEncoded("token", MyApp.context.getSharedPreferences("TOKEN",Context.MODE_PRIVATE).getString("token","A0C48974F2BBBA4EC3053CDE21328D70"))
                        .build();
                request=request.newBuilder().post(formBody).build();
            }
        }
        Response proceed = chain.proceed(request);
        Log.d("procees============",proceed.message().toString());
        return proceed;

    }
}
