package com.example.john.myapplication.fragment.shoppingfragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.SHoppingRecycleAdapter;
import com.example.john.myapplication.base.BaseFragment;


public class AllShoppingFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private SHoppingRecycleAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    public AllShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate=inflater.inflate(R.layout.fragment_all_shopping, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        recyclerView= (RecyclerView) inflate.findViewById(R.id.fg_allshopping_recycle);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new SHoppingRecycleAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }

}
