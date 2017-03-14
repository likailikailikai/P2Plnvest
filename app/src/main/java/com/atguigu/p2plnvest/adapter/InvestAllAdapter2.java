package com.atguigu.p2plnvest.adapter;

import android.view.View;
import android.widget.TextView;

import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.bean.InvestAllBean;
import com.atguigu.p2plnvest.utils.UiUtils;

import java.util.List;

/**
 * Created by 情v枫 on 2017/3/14.
 * <p>
 * 作用：
 */

public class InvestAllAdapter2 extends BaseInvestAllAdapter02<InvestAllBean.DataBean> {

    public InvestAllAdapter2(List<InvestAllBean.DataBean> list) {
        super(list);
    }

    @Override
    public View initView() {
        return UiUtils.getView(R.layout.adapter_invest_all);
    }

    @Override
    public void setData(InvestAllBean.DataBean dataBean, View view) {
        TextView pname = (TextView) view.findViewById(R.id.p_name);
        pname.setText(dataBean.getName());
    }
}
