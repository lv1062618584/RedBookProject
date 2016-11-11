                                                                                                                                                                                                                                                 package com.example.john.myapplication.fragment.shoppingfragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.SkinRecycleAdapter;
import com.example.john.myapplication.base.BaseFragment;

public class SkinFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private SkinRecycleAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    public SkinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate=inflater.inflate(R.layout.fragment_skin,container,false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        //recyclerView得到地址
        recyclerView= (RecyclerView) inflate.findViewById(R.id.recyclerView_shop_skin);
        //初始化格式管理者
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //recycle设置一个格式管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        //???这里getactivity和getcontent有什么区别？
        adapter=new SkinRecycleAdapter(getContext());
        //装在适配器里
        recyclerView.setAdapter(adapter);
    }

}
