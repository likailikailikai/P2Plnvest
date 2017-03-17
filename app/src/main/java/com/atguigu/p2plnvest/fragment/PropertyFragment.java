package com.atguigu.p2plnvest.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.activity.MainActivity;
import com.atguigu.p2plnvest.bean.UserInfo;
import com.atguigu.p2plnvest.command.AppNetConfig;
import com.atguigu.p2plnvest.fragment.activity.ColumnActivity;
import com.atguigu.p2plnvest.fragment.activity.LineChartActivity;
import com.atguigu.p2plnvest.fragment.activity.PieActivity;
import com.atguigu.p2plnvest.fragment.activity.ReChargeActivity;
import com.squareup.picasso.Picasso;

import butterknife.InjectView;
import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by 情v枫 on 2017/3/10.
 * <p>
 * 作用：
 */

public class PropertyFragment extends BaseFragment {

    @InjectView(R.id.tv_settings)
    TextView tvSettings;
    @InjectView(R.id.iv_me_icon)
    ImageView ivMeIcon;
    @InjectView(R.id.rl_me_icon)
    RelativeLayout rlMeIcon;
    @InjectView(R.id.tv_me_name)
    TextView tvMeName;
    @InjectView(R.id.rl_me)
    RelativeLayout rlMe;
    @InjectView(R.id.recharge)
    ImageView recharge;
    @InjectView(R.id.withdraw)
    ImageView withdraw;
    @InjectView(R.id.ll_touzi)
    TextView llTouzi;
    @InjectView(R.id.ll_touzi_zhiguan)
    TextView llTouziZhiguan;
    @InjectView(R.id.ll_zichan)
    TextView llZichan;

    @Override
    protected void initListener() {
        llZichan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),PieActivity.class));
            }
        });

        llTouziZhiguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ColumnActivity.class));
            }
        });

        llTouzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LineChartActivity.class));
            }
        });

        //充值的监听
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ReChargeActivity.class));
            }
        });

    }

    @Override
    protected void initData(String json) {
        initListener();
        MainActivity activity = (MainActivity) getActivity();
        UserInfo user = activity.getUser();
        //设置用户名
        tvMeName.setText(user.getData().getName());
        //设置头像
       /* Picasso.with(getActivity())
                .load(AppNetConfig.BASE_URL + "/images/tx.png")
                .transform(new Transformation() {
                    @Override
                    public Bitmap transform(Bitmap bitmap) {
                        Bitmap circleBitmap = BitmapUtils.circleBitmap(bitmap);

                        bitmap.recycle(); //必须把原来的释放掉
                        return circleBitmap;
                    }

                    @Override
                    public String key() {
                        return "";//不能为空否则会报错
                    }
                }).into(ivMeIcon);*/
        Picasso.with(getActivity()).load(AppNetConfig.BASE_URL + "/images/tx.png")
                .transform(new CropCircleTransformation())
                .transform(new ColorFilterTransformation(Color.parseColor("#66FFccff")))
                .transform(new BlurTransformation(getActivity(), 15))
                .into(ivMeIcon);

    }

    @Override
    public int getLayoutid() {
        return R.layout.fragment_property;
    }

    @Override
    public String getChildUrl() {
        return null;
    }

}
