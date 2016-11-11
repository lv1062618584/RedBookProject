package com.example.john.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.MyFragmentPagerAdapter;
import com.example.john.myapplication.base.BaseFragment;
import com.example.john.myapplication.fragment.shoppingfragment.AllShoppingFragment;
import com.example.john.myapplication.fragment.shoppingfragment.CosmeticsFragment;
import com.example.john.myapplication.fragment.shoppingfragment.FashionFragment;
import com.example.john.myapplication.fragment.shoppingfragment.SkinFragment;
import com.example.john.myapplication.ui.search;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private List<String> tabList;
    private List<Fragment> fragmentList;
    private AllShoppingFragment allShoppingFragment;
    private SkinFragment skinFragment;
    private CosmeticsFragment cosmeticsFragment;
    private FashionFragment fashionFragment;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private LinearLayout linearLayout;
    private ImageView imageView;



    public static final String TAG=ShoppingFragment.class.getName();
    private TextView titletext;

    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate=inflater.inflate(R.layout.fragment_shopping, container, false);
        imageView= (ImageView) inflate.findViewById(R.id.img_title_home);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"购物车",Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout= (LinearLayout) inflate.findViewById(R.id.linearLayout_home);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"搜索",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),search.class);
                startActivity(intent);
            }
        });
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        tabLayout= (TabLayout) inflate.findViewById(R.id.fg_shopping_tab);
        viewpager= (ViewPager) inflate.findViewById(R.id.fg_shopping_vp);


        titletext = (TextView)inflate.findViewById(R.id.fg_shopping_searchtext);
        titletext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(),"搜索",Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(getActivity(),search.class);
//                startActivity(intent);
            }
        });


        allShoppingFragment=new AllShoppingFragment();
        skinFragment=new SkinFragment();
        cosmeticsFragment=new CosmeticsFragment();
        fashionFragment=new FashionFragment();
        tabList=new ArrayList<String>();
        fragmentList=new ArrayList<Fragment>();
        addTab();

    }

    private void addTab() {
        tabList.add("全部");
        tabList.add("护肤");
        tabList.add("彩妆");
        tabList.add("时尚");
        tabList.add("时尚");
        tabList.add("时尚");
        tabList.add("时尚");
        tabList.add("时尚");
        tabList.add("时尚");

        for(int i=0;i<tabList.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabList.get(i)));
        }
        initViewPager();
        tabLayout.setupWithViewPager(viewpager);
    }

    private void initViewPager() {
        fragmentList.add(allShoppingFragment);
        fragmentList.add(skinFragment);
        fragmentList.add(cosmeticsFragment);
        fragmentList.add(fashionFragment);
        fragmentList.add(new FashionFragment());
        fragmentList.add(new FashionFragment());
        fragmentList.add(new FashionFragment());
        fragmentList.add(new FashionFragment());
        fragmentList.add(new FashionFragment());
        myFragmentPagerAdapter=new MyFragmentPagerAdapter(getChildFragmentManager(),fragmentList,tabList);

        viewpager.setAdapter(myFragmentPagerAdapter);

        viewpager.setOffscreenPageLimit(9);

    }

}
