package com.atguigu.p2plnvest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by 情v枫 on 2017/3/15.
 * <p>
 * 作用：
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutid());
        ButterKnife.inject(this);
        initTitle();
        initData();
        initListener();
    }

    protected abstract void initListener() ;

    protected abstract void initData() ;

    protected abstract void initTitle() ;

    public abstract int getLayoutid() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.inject(this);
    }

    //弹出土司
    public void showToast(String context){
        Toast.makeText(this, context, Toast.LENGTH_SHORT).show();
    }

}
