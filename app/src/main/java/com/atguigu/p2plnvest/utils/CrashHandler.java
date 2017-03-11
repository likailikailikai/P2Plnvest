package com.atguigu.p2plnvest.utils;

import android.util.Log;

/**
 * Created by 情v枫 on 2017/3/11.
 * <p>
 * 作用：
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private CrashHandler(){};

    private static CrashHandler crashHandler = new CrashHandler();

    public static CrashHandler getInstance(){
        return crashHandler;
    }

    public void init(){
        //把当前的类设置成默认的处理未捕获异常
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.e("uncaughtException", "uncaughtException:");
    }
}
