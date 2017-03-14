package com.atguigu.p2plnvest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.adapter.InvestAllAdapter;
import com.atguigu.p2plnvest.adapter.InvestAllAdapter2;
import com.atguigu.p2plnvest.bean.InvestAllBean;
import com.atguigu.p2plnvest.command.AppNetConfig;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/10.
 * <p>
 * 作用：
 */

public class InvestAllFragment extends BaseFragment {

    @InjectView(R.id.invest_all_lv)
    ListView investAllLv;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData(String json) {
        InvestAllBean investAllBean = JSON.parseObject(json, InvestAllBean.class);

//        InvestAllAdapter adapter =
//                new InvestAllAdapter(investAllBean.getData());
//        InvestAllAdapter1 adapter =
//                new InvestAllAdapter1(investAllBean.getData());
        InvestAllAdapter2 adapter =
                new InvestAllAdapter2(investAllBean.getData());



        investAllLv.setAdapter(adapter);
    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_invest_all;
    }

    @Override
    public String getChildUrl() {
        return AppNetConfig.PRODUCT;
    }


}
