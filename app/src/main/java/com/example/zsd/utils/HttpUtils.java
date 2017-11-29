package com.example.zsd.utils;
import android.util.Log;

import com.example.zsd.base.BaseApi;
import com.example.zsd.service.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * 作者： 张少丹
 * 时间：  2017/11/14.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class HttpUtils {
    public static final int TIMEOUT=1000*60;
    public static HttpUtils myQusetUtils;
    private ApiService questInterface;

    public HttpUtils(ApiService questInterface) {
        this.questInterface = questInterface;
    }

    public  ApiService getMyQusetUtils() {
        return questInterface;
    }

    public static class  Builder{
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new MyIntercept())
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false).build();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BaseApi.BASE_API).client(okHttpClient);
        public  Builder addConverterFactory(){
            builder.addConverterFactory(GsonConverterFactory.create());
            return   this;
        }
        public  Builder addCallAdapterFactory(){
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            return  this;
        }
        public HttpUtils build(){
            ApiService questInterface=builder.build().create(ApiService.class);
            return   myQusetUtils=new HttpUtils(questInterface);
        }

    }
}
