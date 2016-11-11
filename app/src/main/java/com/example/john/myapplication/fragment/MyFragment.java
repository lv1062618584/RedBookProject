package com.example.john.myapplication.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.john.myapplication.R;
import com.example.john.myapplication.base.BaseFragment;
import com.example.john.myapplication.ui.MyGeren;
import com.example.john.myapplication.welcome.SetUI;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment {
    private LinearLayout linearLayout;
    private SharedPreferences sharedPreferences;
    public static final String TAG=MyFragment.class.getName();
    private TextView textView;
    private ImageView imgSet;
    private TextView textView1;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate=inflater.inflate(R.layout.fragment_my, container, false);
        textView= (TextView) inflate.findViewById(R.id.yhnc);
        textView1= (TextView) inflate.findViewById(R.id.yonghunichengaaaa);
        //实例化sharedpreferences对象.写在onCreate里
        sharedPreferences=getContext().getSharedPreferences("test", Activity.MODE_PRIVATE);
        imgSet= (ImageView) inflate.findViewById(R.id.toobar_right_img);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        linearLayout= (LinearLayout) inflate.findViewById(R.id.gerenziliao);

        // 使用getString方法获得value，注意第2个参数是value的默认值
        String name=sharedPreferences.getString("name","");
        //将name赋给textview
        textView.setText(name);
        textView1.setText(name);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MyGeren.class);
                startActivity(intent);
            }
        });
        imgSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SetUI.class);
                startActivity(intent);
            }
        });
    }
    //解决了登出账户进入注册登录界面按返回返回我的主页的尴尬.......onResume:显示界面
    @Override
    public void onResume() {
        super.onResume();
        String name = sharedPreferences.getString("name","");
        if (!name.equals("") && name!=null){
            //不为空就结束这个界面回到我的界面
        }else{
            getActivity().finish();
            //为空就结束所有的activity结束进程
            //
        }
    }
}
