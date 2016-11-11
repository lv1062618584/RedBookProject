package com.example.john.myapplication.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.GridAdapterHome;
import com.example.john.myapplication.base.BaseFragment;
import com.example.john.myapplication.bean.HomeData;
import com.example.john.myapplication.bean.ImageUrl;
import com.example.john.myapplication.bean.User;
import com.example.john.myapplication.comment.APIContent;
import com.example.john.myapplication.ui.search;
import com.example.john.myapplication.utils.HttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;
//    private GridLayoutManager gridLayoutManager;
    private List<HomeData> list;
    private GridAdapterHome gridAdapterHome;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<Integer> heightImage;
    private LinearLayout linearLayout;
    private ImageView imageView;

    public static final String TAG=HomeFragment.class.getName();
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);
        getData();
        return view;
    }

    private void getData() {
        HttpUtil.getStringAsync(APIContent.getHomeUrl(), new HttpUtil.RequestCallBack() {
            @Override
            public void onFailure() {

            }

            @Override
            public void onSuccess(String result) {
                  if(!TextUtils.isEmpty(result)){
                      try {
                          JSONObject json=new JSONObject(result);
                          list=new ArrayList<HomeData>();
                          JSONArray data=json.optJSONArray("data");
                          for (int i = 0; i <data.length() ; i++) {
                              JSONObject jsonobject=data.optJSONObject(i);

                              List<ImageUrl> imageList=new ArrayList<ImageUrl>();
                              JSONArray images=jsonobject.optJSONArray("images_list");
                              for(int j=0;j<images.length();j++){
                                  JSONObject image=images.optJSONObject(j);
                                  ImageUrl imgUrl=new ImageUrl();
                                  imgUrl.setUrl(image.optString("url"));
                                  imageList.add(imgUrl);
                              }
                              //user数据
                              JSONObject user=jsonobject.optJSONObject("user");
                              User use=new User();
                              use.setNickname(user.optString("nickname"));
                              use.setImages(user.optString("images"));

                              //其他数据
                              HomeData allData=new HomeData();
                              allData.setImages_list(imageList);
                              allData.setUser(use);
                              allData.setDesc(jsonobject.optString("desc"));
                              allData.setName(jsonobject.optString("name"));

                              list.add(allData);
                          }
                          gridAdapterHome=new GridAdapterHome(getContext(),list);
                          gridAdapterHome.notifyDataSetChanged();
                          recyclerView.setAdapter(gridAdapterHome);

                      } catch (JSONException e) {
                          e.printStackTrace();
                      }

                  }
            }

            @Override
            public void onFinish() {

            }
        });


    }

    private void initView(View view) {
        recyclerView= (RecyclerView)view.findViewById(R.id.recyclerView_home);
//        gridLayoutManager=new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        staggeredGridLayoutManager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        linearLayout= (LinearLayout) view.findViewById(R.id.linearLayout_home);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"搜索",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),search.class);
                startActivity(intent);
            }
        });

        imageView= (ImageView) view.findViewById(R.id.img_title_home);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"照片",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
