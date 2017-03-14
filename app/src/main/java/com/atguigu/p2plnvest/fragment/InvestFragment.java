package com.atguigu.p2plnvest.fragment;

import android.graphics.Color;
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
    @InjectView(R.id.tv_invest_all)
    TextView tvInvestAll;
    @InjectView(R.id.tv_invest_recommend)
    TextView tvInvestRecommend;
    @InjectView(R.id.tv_invest_hot)
    TextView tvInvestHot;

    @Override
    protected void initListener() {

        investVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //偏移量
            }

            @Override
            public void onPageSelected(int position) {
                selectText(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tvInvestAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                investVp.setCurrentItem(0);
            }
        });
        tvInvestHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                investVp.setCurrentItem(2);
            }
        });
        tvInvestRecommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                investVp.setCurrentItem(1);
            }
        });

    }

    private void selectText(int id) {
        //把所有的背景色还原成默认值
        hiddenTextViewState();
        switch (id) {
            case 0:
                //改变当前的背景色
                tvInvestAll.setBackgroundColor(Color.BLUE);
                break;
            case 1:
                tvInvestRecommend.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                tvInvestHot.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    private void hiddenTextViewState() {
        tvInvestRecommend.setBackgroundColor(Color.WHITE);
        tvInvestHot.setBackgroundColor(Color.WHITE);
        tvInvestAll.setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void initData(String json) {
        //设置标题
        initTitle();
        //初始化Fragmet
        initFragments();
        //初始化viewPager
        initViewPager();
        //设置默认选中的tab
        initTab();
    }

    private void initTab() {
        selectText(0);
    }

    private void initViewPager() {
        investVp.setAdapter(new InvesAdapter(getChildFragmentManager(), fragments));
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
