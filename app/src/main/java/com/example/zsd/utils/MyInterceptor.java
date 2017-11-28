package com.example.zsd.utils;

import android.util.Log;

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
        /*//获取request
        Request request = chain.request();
        //判断当前的请求
        if (request.method().equals("POST")){
            //判断当前的请求Boby
            if (request.body() instanceof FormBody){
                //创建一个新的FromBoby
                FormBody.Builder bobyBuilder = new FormBody.Builder();
                //获取原先的boby
                FormBody body = (FormBody) request.body();
                //遍历boby
                for (int i = 0; i < body.size(); i++) {
                    //取出原先boby的数据  存入新的boby里
                    bobyBuilder.add(body.encodedName(i),body.encodedValue(i));
                }
                //添加制定的公共参数到新的boby里  把原先的boby给替换掉
                body=bobyBuilder.add("source","android").build();
                bobyBuilder.add("token","D9C75CAADF0EE4C106A4C4D9B4DE1B19").build();
                bobyBuilder.add("appVersion","100").build();
                //获取新的request  取代原先的request
                request=request.newBuilder().post(body).build();
                Log.e(TAG,request.toString()+"===============================");
            }
        }
        //进行返回
        return chain.proceed(request);*/
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
            if("POST".equals(method)){
                StringBuilder sb = new StringBuilder();
                if (request.body() instanceof FormBody) {
                    FormBody.Builder bobyBuilder = new FormBody.Builder();
                    FormBody body = (FormBody) request.body();
                    for (int i = 0; i < body.size(); i++) {
                        sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
                    }
                    body = bobyBuilder.add("source","android").build();
                    sb.append(body);
                    sb.append(bobyBuilder.add("token","D9C75CAADF0EE4C106A4C4D9B4DE1B19").build());
                    sb.append(bobyBuilder.add("source","android").build());
                    sb.append(bobyBuilder.add("appVersion","101").build());
                    sb.delete(sb.length() - 1, sb.length());
                    request.newBuilder().post(body).build();
                }
            }
            Log.d(TAG, "| Response:" + content);
            Log.d(TAG,"----------End:"+duration+"毫秒----------");
            return response.newBuilder()
                    .body(ResponseBody.create(mediaType, content))
                    .build();
        /*Request request = chain.request();
        if(request.method().equals("POST"))
        {
            if(request.body() instanceof FormBody)
            {
                FormBody.Builder builder=new FormBody.Builder();
                //获取原先的body
                FormBody body= (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    builder.add(body.encodedName(i),body.encodedValue(i));
                }
                //添加制定的公共参数到新的boby里,把原先的boby替换掉
                builder.add("source","android");
                builder.add("appVersion","101");
                builder.add("token","D9C75CAADF0EE4C106A4C4D9B4DE1B19");
                request = request.newBuilder().post(body).build();
            }
        }
        return chain.proceed(request);*/

    }
}
