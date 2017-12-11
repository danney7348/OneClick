package com.example.zsd.service;

import com.example.zsd.entity.AddFavourite;
import com.example.zsd.entity.CancelFavourite;
import com.example.zsd.entity.Follow;
import com.example.zsd.entity.GetAd;
import com.example.zsd.entity.GetFollowUsers;
import com.example.zsd.entity.GetHotVideos;
import com.example.zsd.entity.GetJokes;
import com.example.zsd.entity.GetNearVideos;
import com.example.zsd.entity.GetUserInfo;
import com.example.zsd.entity.GetUserVideos;
import com.example.zsd.entity.GetVersion;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.entity.JokePraise;
import com.example.zsd.entity.LoginBean;
import com.example.zsd.entity.Praise;
import com.example.zsd.entity.PublishJoke;
import com.example.zsd.entity.PublishVideo;
import com.example.zsd.entity.RemoveWork;
import com.example.zsd.entity.UpdateNickName;
import com.example.zsd.entity.Upload;

import java.util.List;
import java.util.jar.Manifest;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
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

    @Multipart
    @POST("file/upload")
    Call<ResponseBody> upload(@Query("uid") String uid, @Part MultipartBody.Part img);

    @POST("user/getUserInfo")
    @FormUrlEncoded
    Observable<GetUserInfo> getUserInfo(@Field("uid") String uid,@Field("token") String token);

    @POST("quarter/getJokes")
    @FormUrlEncoded
    Observable<GetJokes> getJokes(@Field("page") String page);

    @GET("quarter/getJokes")
    Observable<GetJokes> getGetJokes(@Query("page") String page);

    @POST("quarter/getVideos")
    @FormUrlEncoded
    Observable<GetVideos> getVideos(@Field("uid") String uid,@Field("type") String type,@Field("page") String page);

    @POST("quarter/publishJoke")
    @Multipart
    Observable<PublishJoke> getPublishJoke(@Part() List<MultipartBody.Part> jokeFiles);

    @POST("quarter/publishVideo")
    @Multipart
    Observable<PublishVideo> getPublishVideo(@Part() List<MultipartBody.Part> videoFile);

    @POST("file/upload")
    @Multipart
    Observable<Upload> getUpload();

    @GET("quarter/getAd")
    Observable<GetAd> getAd();

    @GET("quarter/getVersion")
    Observable<GetVersion> getVersion();

    @POST("user/updateNickName")
    @FormUrlEncoded
    Observable<UpdateNickName> getUpdateNickName(@Field("uid") String uid,@Field("nickname") String nickname);

    @POST("quarter/getUserVideos")
    @FormUrlEncoded
    Observable<GetUserVideos> getUserVideos(@Field("uid") String uid,@Field("page") String page);

    @POST("quarter/follow")
    @FormUrlEncoded
    Observable<Follow> getFollow(@Field("uid") String uid, @Field("followId") String followId);

    @POST("quarter/getFollowUsers")
    @FormUrlEncoded
    Observable<GetFollowUsers> getFollowUsers(@Field("uid") String uid);

    @POST("quarter/getHotVideos")
    @FormUrlEncoded
    Observable<GetHotVideos> getHotVideos(@Field("page") String page);

    @POST("quarter/getNearVideos")
    @FormUrlEncoded
    Observable<GetNearVideos> getNearVideos(@Field("page") String page,@Field("latitude") String latitude,@Field("longitude") String longitude);

    @POST("quarter/praise")
    @FormUrlEncoded
    Observable<Praise> getPraise(@Field("uid") String uid,@Field("wid") String wid);

    @POST("quarter/removeWork")
    @FormUrlEncoded
    Observable<RemoveWork> getRemoveWork(@Field("uid") String uid, @Field("wid") String wid);

    @POST("quarter/jokePraise")
    @FormUrlEncoded
    Observable<JokePraise> getJokePraise(@Field("uid") String uid, @Field("jid") String jid);

    @POST("quarter/addFavorite")
    @FormUrlEncoded
    Observable<AddFavourite> getAddFavoourite(@Field("uid") String uid, @Field("wid") String wid);

    @POST("quarter/cancelFavorite")
    @FormUrlEncoded
    Observable<CancelFavourite> getCancelFavoourite(@Field("uid") String uid, @Field("wid") String wid);
}
