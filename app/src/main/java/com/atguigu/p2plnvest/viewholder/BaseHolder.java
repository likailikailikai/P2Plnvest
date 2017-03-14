package com.atguigu.p2plnvest.viewholder;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by 情v枫 on 2017/3/14.
 * <p>
 * 作用：
 */

public abstract class BaseHolder<T> {

    private final View rootView;

    public BaseHolder(){
        rootView = initView();
        ButterKnife.inject(this,rootView);
        rootView.setTag(this);
    }

    public View getView(){
        return rootView;
    };

    private T t;
    public void setData(T t) {
        this.t = t;
        setChildData();
    }

    public T getT() {
        return t;
    }

    public abstract View initView();
    public abstract void setChildData();


}
