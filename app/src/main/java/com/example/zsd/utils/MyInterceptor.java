package com.example.zsd.utils;

import android.content.Context;
import android.util.Log;

import com.example.zsd.activity.MyApp;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by asus on 2017/11/5.
 */

public class MyInterceptor implements Interceptor {
    public String TAG = "LogInterceptor";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        long endTime = System.currentTimeMillis();
        long duration=endTime-startTime;
        MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        Log.d(TAG,"\n");
        Log.d(TAG,"----------Start----------------");
        Log.d(TAG, "| "+request.toString());
        String method=request.method();
        /*if("POST".equals(method)){
            FormBody.Builder sb = new FormBody.Builder();

            if (request.body() instanceof FormBody) {
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    sb.add(body.encodedName(i) , body.encodedValue(i));
                }
                body=sb.add("source","android").add("appVersion","101").add("token",MyApp.context.getSharedPreferences("TOKEN",Context.MODE_PRIVATE).getString("token",null)).build();
                request=request.newBuilder().post(body).build();
                Log.d(TAG, "| RequestParams:{"+sb.toString()+"}");
            }
        }*/
        Log.d(TAG, "| Response:" + content);
        Log.d(TAG,"----------End:"+duration+"毫秒----------");
        return chain.proceed(request);
    /*private int versionCode;
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
                        .addEncoded("appVersion",""+versionCode)
                        .addEncoded("token", MyApp.context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE).getString("token",null))
                        .build();
                request=request.newBuilder().post(formBody).build();
            }
        }
        Response proceed = chain.proceed(request);
        return proceed;*/

    }
}
