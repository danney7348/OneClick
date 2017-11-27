package com.example.zsd.service;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
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
    Observable<Response> getUserLogin(@Query("mobile") String mobile,@Query("password") String password,@Query("token") String token);

    @POST("user/reg")
    @FormUrlEncoded
    Observable<Response> getUserReg(@Query("mobile") String mobile,@Query("password") String password,@Query("token") String token);

    @POST("file/upload")
    @FormUrlEncoded
    Observable<Response> getFileUpload();

}
