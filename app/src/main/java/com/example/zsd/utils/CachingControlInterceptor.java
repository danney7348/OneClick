package com.example.zsd.utils;

import com.example.zsd.activity.MyApp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * 作者： 张少丹
 * 时间：  2017/12/10.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class CachingControlInterceptor {
    private static final int TIMEOUT_CONNECT = 5; //5秒
    private static final int TIMEOUT_DISCONNECT = 60 * 60 * 24 * 7; //7天

    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            //获取retrofit @headers里面的参数，参数可以自己定义，在本例我自己定义的是cache，跟@headers里面对应就可以了
            String cache = chain.request().header("cache");
            okhttp3.Response originalResponse = chain.proceed(chain.request());
            String cacheControl = originalResponse.header("Cache-Control");
            //如果cacheControl为空，就让他TIMEOUT_CONNECT秒的缓存，本例是5秒，方便观察。注意这里的cacheControl是服务器返回的
            if (cacheControl == null) {
                //如果cache没值，缓存时间为TIMEOUT_CONNECT，有的话就为cache的值
                if (cache == null || "".equals(cache)) {
                    cache = TIMEOUT_CONNECT + "";
                }
                originalResponse = originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + cache)
                        .build();
                return originalResponse;
            } else {
                return originalResponse;
            }
        }
    };

    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //离线的时候为7天的缓存。
            if (!NetUtils.isConnected(MyApp.context)) {
                request = request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale="+TIMEOUT_DISCONNECT)
                        .build();
            }
            return chain.proceed(request);
        }
    };
}
