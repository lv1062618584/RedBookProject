package com.example.john.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by John on 2016/10/20.
 */
public class SearchFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragments;
    private List<String> tabsTitles;

    public SearchFragmentPagerAdapter(FragmentManager fm,List<Fragment> listFragments,List<String> tabsTitles) {
        super(fm);
        this.listFragments=listFragments;
        this.tabsTitles=tabsTitles;
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
        return tabsTitles.get(position);
    }
}
