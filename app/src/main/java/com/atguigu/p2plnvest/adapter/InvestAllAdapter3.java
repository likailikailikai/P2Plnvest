package com.atguigu.p2plnvest.adapter;

import com.atguigu.p2plnvest.bean.InvestAllBean;
import com.atguigu.p2plnvest.viewholder.BaseHolder;
import com.atguigu.p2plnvest.viewholder.InvestHolder;

import java.util.List;

/**
 * Created by 情v枫 on 2017/3/14.
 * <p>
 * 作用：
 */

public class InvestAllAdapter3 extends BaseInvestAllAdapter03<InvestAllBean.DataBean> {

    public InvestAllAdapter3(List<InvestAllBean.DataBean> list) {
        super(list);
    }

    @Override
    public BaseHolder getHolder() {
        return new InvestHolder();
    }
}
