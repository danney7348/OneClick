package com.example.zsd.utils;

import android.util.Log;

import com.example.zsd.activity.MyApp;
import com.example.zsd.base.BaseApi;
import com.example.zsd.service.ApiService;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
        long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MiB
        //缓存路径
        String cacheFile = MyApp.context.getCacheDir()+"/http";
        Cache cache = new Cache(new File(cacheFile), SIZE_OF_CACHE);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx", message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
        //加日志级别

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new MyInterceptor())
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                //有网络时的拦截器
                .addNetworkInterceptor(CachingControlInterceptor.REWRITE_RESPONSE_INTERCEPTOR)
                //没网络时的拦截器
                .addInterceptor(CachingControlInterceptor.REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
                .cache(cache)
                .build();
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
