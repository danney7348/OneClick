package com.example.zsd.service;

import com.example.zsd.entity.GetAd;
import com.example.zsd.entity.GetJokes;
import com.example.zsd.entity.GetUserInfo;
import com.example.zsd.entity.GetVersion;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.entity.LoginBean;
import com.example.zsd.entity.PublishJoke;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 作者： 张少丹
 * 时间：  2017/11/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface ApiService {
    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginBean> getUserLogin(@Field("mobile") String mobile, @Field("password") String password);

    @POST("user/reg")
    @FormUrlEncoded
    Observable<ResponseBody> getUserReg(@Field("mobile") String mobile,@Field("password") String password,@Field("token") String token);

    @POST("file/upload")
    @FormUrlEncoded
    Observable<ResponseBody> getFileUpload();

    @POST("user/getUserInfo")
    @FormUrlEncoded
    Observable<GetUserInfo> getUserInfo(@Field("uid") String uid,@Field("token") String token);

    @POST("quarter/getJokes")
    @FormUrlEncoded
    Observable<GetJokes> getJokes(@Field("page") String page);

    @POST("quarter/getVideos")
    @FormUrlEncoded
    Observable<GetVideos> getVideos(@Field("uid") String uid,@Field("type") String type,@Field("page") String page);

    @POST("quarter/publishJoke")
    @FormUrlEncoded
    Observable<PublishJoke> getPublishJoke(@Part("uid") String uid, @Part("content") String content, @Part("jokeFiles") String jokeFiles);

    @GET("quarter/getAd")
    Observable<GetAd> getAd();

    @GET("quarter/getVersion")
    Observable<GetVersion> getVersion();
}
