package com.atguigu.p2plnvest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.atguigu.p2plnvest.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 情v枫 on 2017/3/14.
 * <p>
 * 作用：
 */

public class InvesAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments = new ArrayList<>();


    public InvesAdapter(FragmentManager fm,List<BaseFragment> fragments) {
        super(fm);
        if(fragments != null && fragments.size() > 0) {
            this.fragments = fragments;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}