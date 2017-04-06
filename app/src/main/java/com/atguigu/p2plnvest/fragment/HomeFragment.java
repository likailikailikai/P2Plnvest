package com.atguigu.p2plnvest.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.bean.HomeBean;
import com.atguigu.p2plnvest.bean.RerofitJk;
import com.atguigu.p2plnvest.command.AppNetConfig;
import com.atguigu.p2plnvest.ui.MyProgress;
import com.atguigu.p2plnvest.utils.LoadNet;
import com.atguigu.p2plnvest.utils.LoadNetHttp;
import com.atguigu.p2plnvest.utils.ThreadPool;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 情v枫 on 2017/3/10.
 * <p>
 * 作用：
 */

public class HomeFragment extends BaseFragment {
    @InjectView(R.id.base_title)
    TextView baseTitle;
    @InjectView(R.id.base_back)
    ImageView baseBack;
    @InjectView(R.id.base_setting)
    ImageView baseSetting;
    @InjectView(R.id.banner)
    Banner banner;
    @InjectView(R.id.tv_home_product)
    TextView tvHomeProduct;
    @InjectView(R.id.tv_home_yearrate)
    TextView tvHomeYearrate;
    @InjectView(R.id.home_progress)
    MyProgress homeprogress;

    @Override
    public int getLayoutid() {
        return R.layout.fragment_home;
    }

    @Override
    public String getChildUrl() {
        return null;
    }

    public void initListener() {
        //初始化title
        baseTitle.setText("首页");
        baseBack.setVisibility(View.INVISIBLE);
        baseSetting.setVisibility(View.INVISIBLE);
    }

    public void initData(String json) {
        initRetrofit();
//        HomeBean homeBean = JSON.parseObject(json, HomeBean.class);
//        //Log.i("http", "success: "+homeBean.getImageArr().size());
//        tvHomeYearrate.setText(homeBean.getProInfo().getYearRate() + "%");
//        tvHomeProduct.setText(homeBean.getProInfo().getName());
//        //注意：展示UI一定要判断是不是主线程
//        initProgress(homeBean.getProInfo());
//        initBanner(homeBean);
    }

    private static final String TAG = "tag";

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://47.93.118.241:8081/P2PInvest/")
                //添加解析数据的工厂类
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RerofitJk rerofitJk = retrofit.create(RerofitJk.class);
        Call<HomeBean> index = rerofitJk.getIndex();
        index.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                Log.i(TAG, "onResponse: " + response.body().toString());
                HomeBean body = response.body();
                //Log.i("http", "success: "+homeBean.getImageArr().size());
                tvHomeYearrate.setText(body.getProInfo().getYearRate() + "%");
                tvHomeProduct.setText(body.getProInfo().getName());
                //注意：展示UI一定要判断是不是主线程
                initProgress(body.getProInfo());
                initBanner(body);
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                Log.e("TAG", "失败");
            }
        });

    }

    private void initProgress(final HomeBean.ProInfoBean proInfo) {

        ThreadPool.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {
                int progress = Integer.parseInt(proInfo.getProgress());
                for (int i = 0; i <= progress; i++) {
                    SystemClock.sleep(20);
                    homeprogress.setProgress(i);
                }
            }
        });
    }

    private void initBanner(HomeBean homeBean) {
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //转化成url集合
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < homeBean.getImageArr().size(); i++) {
            urls.add(AppNetConfig.BASE_URL + homeBean.getImageArr().get(i).getIMAURL());
        }
        //设置图片集合
        banner.setImages(urls);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */
            //Picasso 加载图片简单用法
            Picasso.with(context).load((String) path).into(imageView);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }

}
