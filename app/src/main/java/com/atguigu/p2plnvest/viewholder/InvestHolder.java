package com.atguigu.p2plnvest.viewholder;

import android.view.View;
import android.widget.TextView;

import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.bean.InvestAllBean;
import com.atguigu.p2plnvest.ui.MyProgress;
import com.atguigu.p2plnvest.utils.UiUtils;

import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/14.
 * <p>
 * 作用：
 */

public class InvestHolder extends BaseHolder<InvestAllBean.DataBean> {
    @InjectView(R.id.p_name)
    TextView pName;
    @InjectView(R.id.p_money)
    TextView pMoney;
    @InjectView(R.id.p_yearlv)
    TextView pYearlv;
    @InjectView(R.id.p_suodingdays)
    TextView pSuodingdays;
    @InjectView(R.id.p_minzouzi)
    TextView pMinzouzi;
    @InjectView(R.id.p_minnum)
    TextView pMinnum;
    @InjectView(R.id.p_progresss)
    MyProgress pProgresss;

    @Override
    public View initView() {
        return UiUtils.getView(R.layout.adapter_invest_all);
    }

    @Override
    public void setChildData() {
        InvestAllBean.DataBean dataBean = getT();
        pName.setText(dataBean.getName());
    }
}
