package com.fuicuiedu.xc.videonew_20170309.bombapi;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2017/3/16 0016.
 */

public class BombClient {
    private static BombClient bombClient;

    public static BombClient getInstance(){
        if (bombClient == null){
            bombClient = new BombClient();
        }
        return bombClient;
    }

    private OkHttpClient okHttpClient;

    private BombClient(){
        //构建“日志拦截器”
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //设置“日志拦截器”的拦截级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                //添加Bomb必要的头字段的拦截器
                .addInterceptor(new BombIntercepted())
                //添加日志拦截器
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public Call register(String username, String password){
        //构建一个请求的请求体（根据服务器要求）
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username",username);
            jsonObject.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String json = jsonObject.toString();

        RequestBody requestBody = RequestBody.create(null,json);

        Request request = new Request.Builder()
                .url("https://api.bmob.cn/1/users")
                .post(requestBody)
                .build();

        return okHttpClient.newCall(request);
    }


    public Call login(String username,String password){
        Request request = new Request.Builder()
                .get()
                .url("https://api.bmob.cn/1/login" + "?"
                        +"username=" + username + "&"
                        +"password=" + password)
                .build();

        return okHttpClient.newCall(request);
    }





}
