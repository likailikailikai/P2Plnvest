package com.atguigu.p2plnvest.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.bean.UserInfo;
import com.atguigu.p2plnvest.command.AppNetConfig;
import com.atguigu.p2plnvest.utils.LoadNet;
import com.atguigu.p2plnvest.utils.LoadNetHttp;

import java.util.HashMap;
import java.util.Map;

import butterknife.InjectView;

public class LoginActivity extends BaseActivity {

    @InjectView(R.id.base_title)
    TextView baseTitle;
    @InjectView(R.id.base_back)
    ImageView baseBack;
    @InjectView(R.id.base_setting)
    ImageView baseSetting;
    @InjectView(R.id.tv_login_number)
    TextView tvLoginNumber;
    @InjectView(R.id.login_et_number)
    EditText loginEtNumber;
    @InjectView(R.id.rl_login)
    RelativeLayout rlLogin;
    @InjectView(R.id.tv_login_pwd)
    TextView tvLoginPwd;
    @InjectView(R.id.login_et_pwd)
    EditText loginEtPwd;
    @InjectView(R.id.btn_login)
    Button btnLogin;
    @InjectView(R.id.login_regitster_tv)
    TextView loginRegitsterTv;

    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        loginRegitsterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegesterActivity.class));
            }
        });

    }

    private void login() {
        //校验
        String phone = loginEtNumber.getText().toString().trim();
        String pw = loginEtPwd.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            showToast("账号不能为空");
            return;
        }
        if (TextUtils.isEmpty(pw)) {
            showToast("密码不能为空");
            return;
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("phone", phone);
        map.put("password", pw);
        //去服务器登录
        LoadNet.getDataPost(AppNetConfig.LOGIN, map, new LoadNetHttp() {
            @Override
            public void success(String context) {
                Log.i("login", "success: " + context);
                JSONObject jsonObject = JSON.parseObject(context);
                Boolean success = jsonObject.getBoolean("success");
                if (success) {
                    //解析数据
                    UserInfo userInfo = JSON.parseObject(context, UserInfo.class);
                    //保存数据到sp
                    saveUser(userInfo);
                    //跳转
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    //结束当前页面
                    finish();
                } else {
                    showToast("账号不存在或者密码错误");
                }
            }

            @Override
            public void failure(String error) {
                Log.i("error", "success: " + error);
            }
        });
    }
        @Override
        protected void initData () {

        }

        @Override
        protected void initTitle () {
            baseBack.setVisibility(View.INVISIBLE);
            baseSetting.setVisibility(View.INVISIBLE);
            baseTitle.setText("登录");
        }

        @Override
        public int getLayoutid () {
            return R.layout.activity_login;
        }


    }
