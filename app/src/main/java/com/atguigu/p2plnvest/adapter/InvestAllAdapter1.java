package com.atguigu.p2plnvest.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.bean.InvestAllBean;
import com.atguigu.p2plnvest.ui.MyProgress;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/14.
 * <p>
 * 作用：
 */

public class InvestAllAdapter1 extends BaseInvestAllAdapter<InvestAllBean.DataBean> {

    public InvestAllAdapter1(List<InvestAllBean.DataBean> list) {
        super(list);
    }

    @Override
    public View getChildView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.adapter_invest_all, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        InvestAllBean.DataBean dataBean = list.get(position);

        viewHolder.pName.setText(dataBean.getName());

        return convertView;
    }

    static class ViewHolder {
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

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
