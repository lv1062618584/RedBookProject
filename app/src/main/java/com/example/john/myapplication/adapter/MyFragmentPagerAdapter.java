package com.example.john.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 徐陈承 on 2016/9/19.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragments;
    private List<String> listTital;
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> listFragments, List<String> listTital) {
        super(fm);

        this.listTital=listTital;
        this.listFragments=listFragments;
    }

    @Override
    public Fragment getItem(int position) {

        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTital.get(position);
    }
}
