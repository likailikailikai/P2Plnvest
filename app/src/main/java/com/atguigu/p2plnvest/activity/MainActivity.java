package com.atguigu.p2plnvest.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.fragment.HomeFragment;
import com.atguigu.p2plnvest.fragment.InvestFragment;
import com.atguigu.p2plnvest.fragment.MoreFragment;
import com.atguigu.p2plnvest.fragment.PropertyFragment;
import com.atguigu.p2plnvest.utils.AppManager;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.main_rg)
    RadioGroup mainRg;
    private HomeFragment homeFragment;
    private MoreFragment moreFragment;
    private InvestFragment investFragment;
    private PropertyFragment propertyFragment;


    public void initListener() {
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switchFragment(checkedId);
            }
        });
    }

    private void switchFragment(int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        hiddenFragment(transaction);

        switch (checkedId) {
            case R.id.rb_main:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.main_fl, homeFragment);
                }
                transaction.show(homeFragment);
                break;
            case R.id.rb_invest:
                if (investFragment == null) {
                    investFragment = new InvestFragment();
                    transaction.add(R.id.main_fl, investFragment);
                }
                transaction.show(investFragment);
                break;
            case R.id.rb_propert:
                if (propertyFragment == null) {
                    propertyFragment = new PropertyFragment();
                    transaction.add(R.id.main_fl, propertyFragment);
                }
                transaction.show(propertyFragment);

                break;
            case R.id.rb_more:
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    transaction.add(R.id.main_fl, moreFragment);
                }
                transaction.show(moreFragment);

                break;
        }
        transaction.commit();
    }

    private void hiddenFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (investFragment != null) {
            transaction.hide(investFragment);
        }
        if (propertyFragment != null) {
            transaction.hide(propertyFragment);
        }
        if (moreFragment != null) {
            transaction.hide(moreFragment);
        }
    }

    public void initData() {
        //添加到APPManager
        AppManager.getInstance().addActivity(this);
        //选默认页面
        switchFragment(R.id.rb_main);
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutid() {
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏顶部的状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_main;
    }

    //点两次退出
    private boolean isDouble = false;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isDouble) {
                //退出
                finish();
            }
            Toast.makeText(this, "再点击一次退出应用", Toast.LENGTH_SHORT).show();
            isDouble = true;
            //超两秒改为isDouble
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isDouble = false;
                }
            }, 2000);

//            CountDownTimer timer = new CountDownTimer(10000,1000) {
//                //第一个参数是总时间，，第二个参数是间隔时间
//                @Override
//                public void onTick(long millisUntilFinished) {
//                    //每倒计时一次调用一次
//                }
//
//                @Override
//                public void onFinish() {
//                    //执行完成后调用
//                }
//            }.start();

            return true;

        }
        return super.onKeyUp(keyCode, event);
    }
}
