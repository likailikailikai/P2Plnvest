package com.atguigu.p2plnvest.fragment;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.p2plnvest.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/10.
 * <p>
 * 作用：
 */

public class InvestHotFragment extends BaseFragment {

    @InjectView(R.id.ivest_hot_fl)
    TagFlowLayout ivestHotFl;

    private String[] datas = new String[]{"北国风光", "千里冰封", "万里雪飘", "望长城内外", "惟余莽莽", "大河上下",
            "顿失滔滔", "山舞银蛇", "原驰蜡象", "欲与天公试比高", "须晴日", "看红装素裹",
            "分外妖娆", "江山如此多娇", "引无数英雄竞折腰", "惜秦皇汉武",
            "略输文采", "唐宗宋祖", "稍逊风骚", "一代天骄",
            "成吉思汗", "只识弯弓射大雕", "俱往矣", "数风流人物", "还看今朝"
    };

    @Override
    protected void initListener() {

    }

    private Random random = new Random();

    @Override
    protected void initData(String json) {
        ivestHotFl.setAdapter(new TagAdapter<String>(datas) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = new TextView(getActivity());
                tv.setText(s);
                //设置shape
                tv.setBackgroundDrawable(
                        getResources().getDrawable(R.drawable.hot_shape));
                //获取shapeDrawable
                GradientDrawable drawable = (GradientDrawable) tv.getBackground();

                int red = random.nextInt(200 - 50) + 50;
                int green = random.nextInt(211);
                int blue = random.nextInt(211);
                //设置shape的背景色
                drawable.setColor(Color.rgb(red, green, blue));
                //tv.setBackgroundDrawable(DrawableUtils.getDrawable());

                return tv;
            }
        });

    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_invest_hot;
    }

    @Override
    public String getChildUrl() {
        return null;
    }


}
