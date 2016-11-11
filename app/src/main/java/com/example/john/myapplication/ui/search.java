package com.example.john.myapplication.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.SearchFragmentPagerAdapter;
import com.example.john.myapplication.fragment.searchfragment.GoodsFragment;
import com.example.john.myapplication.fragment.searchfragment.NoteFragment;
import com.example.john.myapplication.fragment.searchfragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager vpShow;
    private List<String> tabsTitle;

    private List<Fragment> listFragments;

    private SearchFragmentPagerAdapter searchFragmentPagerAdapter;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        textView= (TextView) findViewById(R.id.textView_search_activity);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        tabLayout= (TabLayout) findViewById(R.id.tablayout_activity_search);
        vpShow= (ViewPager) findViewById(R.id.viewPager_activity_search);
        tabsTitle=new ArrayList<>();
        listFragments=new ArrayList<>();

        addTabs();
    }

    private void initVP() {
        listFragments.add(new NoteFragment());
        listFragments.add(new GoodsFragment());
        listFragments.add(new UserFragment());
        searchFragmentPagerAdapter=new SearchFragmentPagerAdapter(getSupportFragmentManager(),listFragments,tabsTitle);
        vpShow.setAdapter(searchFragmentPagerAdapter);
        vpShow.setOffscreenPageLimit(2);
    }

    private void addTabs() {
        tabsTitle.add("笔记");
        tabsTitle.add("商品");
        tabsTitle.add("用户");
        for(int i=0;i<tabsTitle.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabsTitle.get(i)));
        }
        initVP();
        tabLayout.setupWithViewPager(vpShow);
    }

}
