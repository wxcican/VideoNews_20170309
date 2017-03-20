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
import com.fuicuiedu.xc.videonew_20170309.bombapi.BombClient;
import com.fuicuiedu.xc.videonew_20170309.bombapi.UserApi;
import com.fuicuiedu.xc.videonew_20170309.bombapi.result.UserResult;
import com.fuicuiedu.xc.videonew_20170309.commons.ToastUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.IDN;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by Administrator on 2017/3/15 0015.
 */

public class LoginFragment extends DialogFragment{

    private Unbinder mUnbinder;

    @BindView(R.id.etUsername)
    EditText mEtUsername;
    @BindView(R.id.etPassword)
    EditText mEtPassword;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //无标题栏
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_login, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnLogin)
    public void onClick(){
        Log.e("okhttp","点击了！");
        String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        //用户名和密码不能为空
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            ToastUtils.showShort(R.string.username_or_password_can_not_be_null);
            return;
        }

        //登录的网络请求
        UserApi userApi = BombClient.getInstance().getUserApi();
        Call<UserResult> call = userApi.login(username,password);
        call.enqueue(new retrofit2.Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, retrofit2.Response<UserResult> response) {
                UserResult userResult = response.body();
                ToastUtils.showShort("Id = " + userResult.getObjectId());
                //添加完转换器后，Gson直接帮我们吧ResponseBody，转换为了我们想要一个结果类（放到泛型中）
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {

            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
