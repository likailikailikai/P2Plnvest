package com.atguigu.p2plnvest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.p2plnvest.R;
import com.atguigu.p2plnvest.activity.BaseActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class ColumnActivity extends BaseActivity {


    @InjectView(R.id.base_title)
    TextView baseTitle;
    @InjectView(R.id.base_back)
    ImageView baseBack;
    @InjectView(R.id.base_setting)
    ImageView baseSetting;
    @InjectView(R.id.chart)
    BarChart chart;
    @InjectView(R.id.activity_column)
    LinearLayout activityColumn;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Typeface mTf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

        chart.setDescription("");
        chart.setDrawGridBackground(false);
        chart.setDrawBarShadow(false);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTypeface(mTf);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTypeface(mTf);
        leftAxis.setLabelCount(5, false);
        leftAxis.setSpaceTop(20f);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setTypeface(mTf);
        rightAxis.setLabelCount(5, false);
        rightAxis.setSpaceTop(20f);

        BarData barData = generateDataBar(1);
        barData.setValueTypeface(mTf);

        // set data
        chart.setData(barData);

        // do not forget to refresh the chart
        //        chart.invalidate();
        chart.animateY(700);

    }


    @Override
    protected void initTitle() {
        baseBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        baseSetting.setVisibility(View.GONE);
        baseTitle.setText("柱状图");
    }

    @Override
    public int getLayoutid() {
        return R.layout.activity_column;
    }

    /**
     * generates a random ChartData object with just one DataSet
     *
     * @param cnt
     * @return
     */
    private BarData generateDataBar(int cnt) {
        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        for (int i = 0; i < 12; i++) {
            entries.add(new BarEntry((int) (Math.random() * 70) + 30, i));
        }

        BarDataSet d = new BarDataSet(entries, "New DataSet " + cnt);
        d.setBarSpacePercent(20f);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);

        BarData cd = new BarData(getMonths(), d);

        return cd;
    }

    private ArrayList<String> getMonths() {

        ArrayList<String> m = new ArrayList<String>();
        m.add("Jan");
        m.add("Feb");
        m.add("Mar");
        m.add("Apr");
        m.add("May");
        m.add("Jun");
        m.add("Jul");
        m.add("Aug");
        m.add("Sep");
        m.add("Okt");
        m.add("Nov");
        m.add("Dec");

        return m;
    }

}
