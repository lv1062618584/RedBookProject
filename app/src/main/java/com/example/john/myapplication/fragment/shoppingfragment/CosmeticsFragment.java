package com.example.john.myapplication.fragment.shoppingfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john.myapplication.R;
import com.example.john.myapplication.base.BaseFragment;

public class CosmeticsFragment extends BaseFragment {


    public CosmeticsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cosmetics, container, false);
    }

}
