package com.fuicuiedu.xc.videonew_20170309.bombapi;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 用户相关网络接口
 */

public interface UserApi {

    //登录
    @GET("1/login")
    Call<ResponseBody> login(@Query("username") String username, @Query("password") String password);

    //注册
    @POST("1/users")
    Call<ResponseBody> register(@Body RequestBody requestBody);

}
