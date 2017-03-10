package com.atguigu.p2plnvest.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.atguigu.p2plnvest.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.main_rg)
    RadioGroup mainRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initData();

        initListener();
    }

    private void initListener() {
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switchFragment(checkedId);
            }
        });
    }

    private void switchFragment(int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        hiddenFragment(transaction);

        switch (checkedId){
            case R.id.rb_main:

                break;
            case R.id.rb_invest:

                break;
            case R.id.rb_propert:

                break;
            case R.id.rb_more:

                break;
        }

    }

    private void hiddenFragment(FragmentTransaction transaction) {

    }

    private void initData() {

    }
}
