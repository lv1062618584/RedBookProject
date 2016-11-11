package com.example.john.myapplication.welcome;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.john.myapplication.R;
import com.example.john.myapplication.adapter.WelcomViewPager;
import com.example.john.myapplication.base.BaseActivity;
import com.example.john.myapplication.welcome.denglu.Denglu;
import com.example.john.myapplication.welcome.zhuce.Zhuce;

import java.util.ArrayList;
import java.util.List;

public class Welcome extends BaseActivity implements View.OnClickListener {
    private WelcomViewPager welcomViewPager;
    private ViewPager viewPager;
    private Button buttonDenglu;
    private Button buttonZhuce;
    private int[] img = {R.mipmap.v1, R.mipmap.v2, R.mipmap.v3};
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        viewPager = (ViewPager) findViewById(R.id.vp_welcome);

        buttonDenglu = (Button) findViewById(R.id.bt_welcome_1);
        buttonDenglu.setOnClickListener(this);
        buttonZhuce = (Button) findViewById(R.id.bt_welcome_2);
        buttonZhuce.setOnClickListener(this);
        sharedPreferences=getSharedPreferences("test", Activity.MODE_PRIVATE);
        initView();
    }

    //最好不要再xml文件里写监听
    private void initView() {
        List<ImageView> imgList = new ArrayList<>();
        for (int i = 0; i < img.length; i++) {
            ImageView imgNew = new ImageView(this);
            imgNew.setImageResource(img[i]);
            imgList.add(imgNew);
        }
        WelcomViewPager pager = new WelcomViewPager(imgList);
        viewPager.setAdapter(pager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_welcome_1:
                Intent intent = new Intent(this, Zhuce.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bt_welcome_2:
                Intent intent2 = new Intent(this, Denglu.class);
                startActivity(intent2);
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        String name = sharedPreferences.getString("name","");
        if (!name.equals("") && name!=null){
            //不为空就结束这个界面回到我的界面
            finish();
        }else{
            //为空就结束所有的activity结束进程
          //
        }
        return super.onKeyDown(keyCode, event);
    }
}
