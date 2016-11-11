package com.example.john.myapplication.fragment.messagefragment;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.ListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class informFragment extends Fragment {

    private ListView listView;
    private ListAdapter listAdapter;


    public informFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_inform, container, false);
        listView= (ListView) view.findViewById(R.id.listView_fragment_inform);
        listAdapter=new ListAdapter(getActivity());
        listView.setAdapter(listAdapter);
        return view;
    }

}
