package com.example.john.myapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.MyFindAdapter;
import com.example.john.myapplication.adapter.MyFindViewPageAdapter;
import com.example.john.myapplication.base.BaseFragment;
import com.example.john.myapplication.bean.FindRemen;
import com.example.john.myapplication.bean.FindRemen_uesr;
import com.example.john.myapplication.bean.FindScrollView;
import com.example.john.myapplication.bean.Find_VP_1;
import com.example.john.myapplication.comment.APIContent;
import com.example.john.myapplication.utils.HttpUtil;
import com.example.john.myapplication.utils.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment {
    private MyFindAdapter myFindAdapter;
    private MyFindViewPageAdapter myFindViewPageAdapter;
    private ListView listView;
    private List<ImageView> imgBanner;
    //是否循环：isLooping
    private boolean isLooping = false;
    public static final String TAG = FindFragment.class.getName();
    //解析
    private List<FindRemen> list1;
    private List<Find_VP_1> list_vp;
    private List<FindScrollView> listScrollView;
    private List<FindScrollView> listScrollView1;
    private List<FindScrollView> listScrollView2;
    private static int viewPagerPosition = 0;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_find, container, false);

        initView(inflate);
        getData();
        return inflate;
    }

    private void getData() {
        HttpUtil.getStringAsync(APIContent.getFindViewPagerURL(), new HttpUtil.RequestCallBack() {
            //viewpager
            @Override
            public void onFailure() {

            }

            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        JSONArray data = jsonObject.optJSONArray("data");
                        //得到data里的大括号
                        JSONObject jsonObject2 = data.optJSONObject(0);
                        JSONArray events = jsonObject2.optJSONArray("events");
                        for (int i = 0; i < events.length(); i++) {
                            //得到第i个大括号里的内容
                            JSONObject jsonObject1 = events.optJSONObject(i);
                            Find_VP_1 find_vp_1 = new Find_VP_1();
                            find_vp_1.setImage(jsonObject1.optString("image"));
                            list_vp.add(find_vp_1);
                        }
                        addHeaderVP();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFinish() {

            }
        });

        //scrollview的解析
        HttpUtil.getStringAsync(APIContent.getFindViewPagerURL(), new HttpUtil.RequestCallBack() {
            @Override
            public void onFailure() {

            }

            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        JSONArray data = jsonObject.optJSONArray("data");
                        //得到data里的大括号
                        JSONObject jsonObject2 = data.optJSONObject(2);
                        JSONArray topic = jsonObject2.optJSONArray("topic");
                        Log.i("xiaoming", topic.length() + "");
                        for (int i = 0; i < topic.length(); i++) {
                            JSONObject jsonObject1 = topic.optJSONObject(i);
                            FindScrollView findScrollView = new FindScrollView();
                            findScrollView.setImage(jsonObject1.getString("image"));
                            findScrollView.setName(jsonObject1.getString("name"));
                            listScrollView.add(findScrollView);
                        }
                        //得到data里的大括号
                        JSONObject jsonObject3 = data.optJSONObject(3);
                        JSONArray scenario = jsonObject3.optJSONArray("scenario");
                        for (int j = 0; j < scenario.length(); j++) {
                            JSONObject jsonObject1 = scenario.optJSONObject(j);
                            FindScrollView findScrollView = new FindScrollView();
                            findScrollView.setImage(jsonObject1.getString("image"));
                            ;
                            listScrollView1.add(findScrollView);
                        }
                        //得到data里的大括号
                        JSONObject jsonObject5 = data.optJSONObject(5);
                        JSONArray destination = jsonObject5.optJSONArray("destination");
                        //进入中括号里
                        for (int k = 0; k < destination.length(); k++) {
                            JSONObject jsonObject1 = destination.optJSONObject(k);
                            FindScrollView findScrollView = new FindScrollView();
                            findScrollView.setImage(jsonObject1.getString("image"));
                            listScrollView2.add(findScrollView);
                        }
                        addHeaderNV();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFinish() {

            }
        });
        //remen的解析.解析到listview中
        HttpUtil.getStringAsync(APIContent.getFindReMenZhuanJiURL(), new HttpUtil.RequestCallBack() {
            @Override
            public void onFailure() {
            }
            @Override
            public void onSuccess(String result) {
                if (!TextUtils.isEmpty(result)) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        JSONArray data = jsonObject.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject jsonObject1 = data.getJSONObject(i);
                            JSONArray images = jsonObject1.getJSONArray("images");
                            JSONObject user = jsonObject1.getJSONObject("user");
                            List<String> aa = new ArrayList<String>();
                            FindRemen_uesr list_user = new FindRemen_uesr();
                            FindRemen findRemen = new FindRemen();
                            for (int j = 0; j < images.length(); j++) {
                                String bb = images.get(j) + "";
                                aa.add(bb);
                            }
                            list_user.setImages(user.optString("images"));
                            list_user.setNickname(user.getString("nickname"));
                            findRemen.setList_user(list_user);
                            findRemen.setList_img(aa);
                            findRemen.setFans(jsonObject1.getString("fans"));
                            findRemen.setName(jsonObject1.getString("name"));
                            findRemen.setTotal(jsonObject1.getString("total"));
                            list1.add(findRemen);
                        }
                        myFindAdapter = new MyFindAdapter(getActivity(), list1);
                        listView.setAdapter(myFindAdapter);
                        myFindAdapter.notifyDataSetChanged();
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

    private void initView(View inflate) {
        listView = (ListView) inflate.findViewById(R.id.ListView_findfragment_jichu);
        list_vp = new ArrayList<>();
        listScrollView = new ArrayList<>();
        listScrollView1 = new ArrayList<>();
        listScrollView2 = new ArrayList<>();
        list1 = new ArrayList<>();
        ImageLoader.init(getActivity());
        addfooter();
    }

    private void addHeaderVP() {
        View header = LayoutInflater
                .from(getActivity()).inflate(R.layout.item_header_findfragment_viewpager, null);
        ViewPager vpHeader = (ViewPager) header.findViewById(R.id.viewpager_findfragment_lunhua);
        imgBanner = new ArrayList<>();
        for (int i = 0; i < list_vp.size(); i++) {
            ImageView img = new ImageView(getActivity());
            ImageLoader.display(img, list_vp.get(i).getImage());
            img.setImageResource(R.mipmap.ic_launcher);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "点击的是第" + viewPagerPosition + "张图片", Toast.LENGTH_LONG).show();
                }
            });
            vpHeader.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }
                @Override
                public void onPageSelected(int position) {
                    viewPagerPosition = position;
                    Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            imgBanner.add(img);
        }

        myFindViewPageAdapter = new MyFindViewPageAdapter(imgBanner);
        vpHeader.setAdapter(myFindViewPageAdapter);
        vpHeader.setCurrentItem(0);
        listView.addHeaderView(header);
    }

    private void addHeaderNV() {
        View header1 = LayoutInflater.from(getActivity()).inflate(R.layout.item_header_findfragment_nextview, null);
        ImageView img0 = (ImageView) header1.findViewById(R.id.rm_1);
        ImageView img1 = (ImageView) header1.findViewById(R.id.rm_2);
        ImageView img2 = (ImageView) header1.findViewById(R.id.rm_3);
        ImageView img3 = (ImageView) header1.findViewById(R.id.rm_4);
        ImageView img4 = (ImageView) header1.findViewById(R.id.rm_5);
        ImageView img5 = (ImageView) header1.findViewById(R.id.rm_6);
        ImageView img6 = (ImageView) header1.findViewById(R.id.rm_7);
        TextView txt0 = (TextView) header1.findViewById(R.id.txt_findfragment_s1);
        TextView txt1 = (TextView) header1.findViewById(R.id.txt_findfragment_s2);
        TextView txt2 = (TextView) header1.findViewById(R.id.txt_findfragment_s3);
        TextView txt3 = (TextView) header1.findViewById(R.id.txt_findfragment_s4);
        TextView txt4 = (TextView) header1.findViewById(R.id.txt_findfragment_s5);
        TextView txt5 = (TextView) header1.findViewById(R.id.txt_findfragment_s6);
        ImageLoader.display(img0, listScrollView.get(0).getImage());
        ImageLoader.display(img1, listScrollView.get(1).getImage());
        ImageLoader.display(img2, listScrollView.get(2).getImage());
        ImageLoader.display(img3, listScrollView.get(3).getImage());
        ImageLoader.display(img4, listScrollView.get(4).getImage());
        ImageLoader.display(img5, listScrollView.get(5).getImage());
        img6.setImageResource(R.mipmap.ic_launcher);
        txt0.setText(listScrollView.get(0).getName());
        txt1.setText(listScrollView.get(1).getName());
        txt2.setText(listScrollView.get(2).getName());
        txt3.setText(listScrollView.get(3).getName());
        txt4.setText(listScrollView.get(4).getName());
        txt5.setText(listScrollView.get(5).getName());
        img0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第1个图片",Toast.LENGTH_LONG).show();
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第2个图片",Toast.LENGTH_LONG).show();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第3个图片",Toast.LENGTH_LONG).show();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第4个图片",Toast.LENGTH_LONG).show();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第5个图片",Toast.LENGTH_LONG).show();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第6个图片",Toast.LENGTH_LONG).show();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第7个图片",Toast.LENGTH_LONG).show();
            }
        });
        ImageView imgR0 = (ImageView) header1.findViewById(R.id.qz_1);
        ImageView imgR1 = (ImageView) header1.findViewById(R.id.qz_2);
        ImageView imgR2 = (ImageView) header1.findViewById(R.id.qz_3);
        ImageView imgR3 = (ImageView) header1.findViewById(R.id.qz_4);
        ImageView imgR4 = (ImageView) header1.findViewById(R.id.qz_5);
        ImageView imgR5 = (ImageView) header1.findViewById(R.id.qz_6);
        ImageView imgR6 = (ImageView) header1.findViewById(R.id.qz_7);
        imgR6.setImageResource(R.mipmap.ic_launcher);
        ImageLoader.display(imgR0, listScrollView1.get(0).getImage());
        ImageLoader.display(imgR1, listScrollView1.get(1).getImage());
        ImageLoader.display(imgR2, listScrollView1.get(2).getImage());
        ImageLoader.display(imgR3, listScrollView1.get(3).getImage());
        ImageLoader.display(imgR4, listScrollView1.get(4).getImage());
        ImageLoader.display(imgR5, listScrollView1.get(5).getImage());
        imgR0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第1个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第2个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第3个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第4个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgR4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第5个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgR5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第6个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgR6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第7个图片",Toast.LENGTH_LONG).show();
            }
        });
        ImageView imgZ0 = (ImageView) header1.findViewById(R.id.qq_1);
        ImageView imgZ1 = (ImageView) header1.findViewById(R.id.qq_2);
        ImageView imgZ2 = (ImageView) header1.findViewById(R.id.qq_3);
        ImageView imgZ3 = (ImageView) header1.findViewById(R.id.qq_4);
        ImageView imgZ4 = (ImageView) header1.findViewById(R.id.qq_5);
        ImageView imgZ5 = (ImageView) header1.findViewById(R.id.qq_6);
        ImageView imgZ6 = (ImageView) header1.findViewById(R.id.qq_7);
        imgZ6.setImageResource(R.mipmap.ic_launcher);
        ImageLoader.display(imgZ0, listScrollView2.get(0).getImage());
        ImageLoader.display(imgZ1, listScrollView2.get(1).getImage());
        ImageLoader.display(imgZ2, listScrollView2.get(2).getImage());
        ImageLoader.display(imgZ3, listScrollView2.get(3).getImage());
        ImageLoader.display(imgZ4, listScrollView2.get(4).getImage());
        ImageLoader.display(imgZ5, listScrollView2.get(5).getImage());
        imgZ0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第1个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgZ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第2个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgZ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第3个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgZ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第4个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgZ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第5个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgZ5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第6个图片",Toast.LENGTH_LONG).show();
            }
        });
        imgZ6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"这是第7个图片",Toast.LENGTH_LONG).show();
            }
        });
        listView.addHeaderView(header1);
    }

    private void addfooter() {
        View header2 = LayoutInflater.from(getActivity()).inflate(R.layout.item_footer_find, null);
        View v = header2.findViewById(R.id.footer);
        listView.addFooterView(header2);
    }
    //写个计时器
//    public void onClick(View view){
//        switch (view.getId()){
//            case R.id.rm_1:
//                Toast.makeText(getActivity(),"1",Toast.LENGTH_LONG).show();
//                break
//            case R.id.lin_point:
//                for (int i = 0; i < list_vp.size(); i++) {
//                    Toast.makeText(getActivity(),list_vp.get(i)+"",Toast.LENGTH_LONG).show();
//                }
//                break;
//
//        }
//    }

}
