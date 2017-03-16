package com.fuicuiedu.xc.videonew_20170309.ui.likes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;


import com.fuicuiedu.xc.videonew_20170309.R;
import com.fuicuiedu.xc.videonew_20170309.commons.ToastUtils;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/12/21 0021.
 */

public class RegisterFragment extends DialogFragment {

    @BindView(R.id.etUsername)
    EditText mEtUsername;
    @BindView(R.id.etPassword)
    EditText mEtPassword;
    @BindView(R.id.btnRegister)
    Button mBtnRegister;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //取消标题栏
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_register,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btnRegister)
    public void onClick(){
        final String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();

        //用户名和密码不能为空
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            ToastUtils.showShort(R.string.username_or_password_can_not_be_null);
            return;
        }

        // TODO: 2017/3/15 0015 注册的网络请求


        //首先要有一个客户端
        OkHttpClient okHttpClient = new OkHttpClient();

        //构建一个请求的请求体（根据服务器要求）
        RequestBody requestBody = new FormBody.Builder()
                .add("username",username)
                .add("password",password)
                .build();

        //要构建一个请求，（
        Request request = new Request.Builder()
        //              请求方式（get，post）(默认是Get请求)
                        .post(requestBody)
        //              请求路径（服务器接口），
                        .url("https://api.bmob.cn/1/users")
        //              请求头信息（根据服务器需要）
                        //用于让bomb服务器，区分是哪一个应用
                        .addHeader("X-Bmob-Application-Id", "623aaef127882aed89b9faa348451da3")
                        //用于授权
                        .addHeader("X-Bmob-REST-API-Key", "c00104962a9b67916e8cbcb9157255de")
                        //请求和响应统一使用json格式
                        .addHeader("Content-Type","application/json")
//                      构建出来
                        .build();
        //通过客户端执行请求   --->   拿到响应
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //超时或没有网络连接
                Log.e("okhttp","超时或没有网络连接");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("okhttp","请求失败,响应码 = " +response.code());
                Log.e("okhttp","请求失败,响应体 = " +response.body().string());
//              判断是否请求成功（响应码=200 -- 299）
                if (response.isSuccessful()){
//              拿到响应体（解析，并展示）
                    Log.e("okhttp","请求成功");
                }
            }
        });



    }

}
