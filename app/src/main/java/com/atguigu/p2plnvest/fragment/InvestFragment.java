package com.atguigu.p2plnvest.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.adapter.InvesAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/10.
 * <p>
 * 作用：
 */

public class InvestFragment extends BaseFragment {

    @InjectView(R.id.base_title)
    TextView baseTitle;
    @InjectView(R.id.base_back)
    ImageView baseBack;
    @InjectView(R.id.base_setting)
    ImageView baseSetting;
    @InjectView(R.id.invest_vp)
    ViewPager investVp;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData(String json) {
        //设置标题
        initTitle();
        //初始化Fragmet
        initFragments();
        //初始化viewPager
        initViewPager();
    }

    private void initViewPager() {
        investVp.setAdapter(new InvesAdapter(getChildFragmentManager(),fragments));
    }

    private List<BaseFragment> fragments = new ArrayList<>();
    private void initFragments() {
        fragments.add(new InvestAllFragment());
        fragments.add(new InvestRecommendFragment());
        fragments.add(new InvestHotFragment());
    }

    private void initTitle() {
        baseSetting.setVisibility(View.GONE);
        baseTitle.setText("投资");
        baseBack.setVisibility(View.GONE);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_invest;
    }

    @Override
    public String getChildUrl() {
        return null;
    }


}
