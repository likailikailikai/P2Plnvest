package com.atguigu.p2plnvest.bean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 情v枫 on 2017/4/6.
 * <p>
 * 作用：
 */

public interface RerofitJk {
    @GET("index")
    Call<HomeBean> getIndex();
}
