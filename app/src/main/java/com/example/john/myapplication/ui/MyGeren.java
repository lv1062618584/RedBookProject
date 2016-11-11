package com.example.john.myapplication.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.myapplication.R;

public class MyGeren extends AppCompatActivity {
    private ImageView img1;
    private TextView textView;
    private TextView textView2;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_geren);
        img1= (ImageView) findViewById(R.id.img_grzl_1);
        textView= (TextView) findViewById(R.id.grsz);
        textView2= (TextView) findViewById(R.id.xb);
        sharedPreferences=getSharedPreferences("test",Activity.MODE_PRIVATE);
        initView(img1);
    }

    private void initView(final View v) {
        // 使用getString方法获得value，注意第2个参数是value的默认值
        String name=sharedPreferences.getString("name","");
        String sex=sharedPreferences.getString("Sex","");
        //将name赋给textview
        textView.setText(name);
        textView2.setText(sex);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyGeren.this.finish();
            }
        });
    }
}
