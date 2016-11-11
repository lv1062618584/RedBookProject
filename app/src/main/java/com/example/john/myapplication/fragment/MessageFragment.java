package com.example.john.myapplication.fragment;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.MessageFragmentPagerAdapter;
import com.example.john.myapplication.base.BaseFragment;
import com.example.john.myapplication.fragment.messagefragment.TrendsFragment;
import com.example.john.myapplication.fragment.messagefragment.YouFragment;
import com.example.john.myapplication.fragment.messagefragment.informFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment {

    public static final String TAG=MessageFragment.class.getName();

    private TabLayout tabLayout;
    private ViewPager vpShow;
    private List<String> tabsTitle;

    private List<Fragment> listFragments;

    private MessageFragmentPagerAdapter messageFragmentPagerAdapter;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate= inflater.inflate(R.layout.fragment_message, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tabLayout= (TabLayout) inflate.findViewById(R.id.tablayout_fragment_message);
        vpShow= (ViewPager) inflate.findViewById(R.id.viewPager_fragment_message);
        tabsTitle=new ArrayList<>();
        listFragments=new ArrayList<>();

        addTabs();
    }

    private void initVP() {
        listFragments.add(new TrendsFragment());
        listFragments.add(new YouFragment());
        listFragments.add(new informFragment());
        messageFragmentPagerAdapter=new MessageFragmentPagerAdapter(getChildFragmentManager(),listFragments,tabsTitle);
        vpShow.setAdapter(messageFragmentPagerAdapter);
        vpShow.setOffscreenPageLimit(2);
    }

    private void addTabs() {
        tabsTitle.add("动态");
        tabsTitle.add("关于你");
        tabsTitle.add("通知");
        for(int i=0;i<tabsTitle.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabsTitle.get(i)));
        }
        initVP();
        tabLayout.setupWithViewPager(vpShow);
    }



}
