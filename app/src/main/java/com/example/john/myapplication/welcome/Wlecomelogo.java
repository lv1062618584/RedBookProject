package com.example.john.myapplication.welcome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.john.myapplication.MainActivity;
import com.example.john.myapplication.R;

public class Wlecomelogo extends AppCompatActivity implements View.OnClickListener{
    private ImageView imglogo;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wlecomelogo);
        imglogo= (ImageView) findViewById(R.id.iogo);
        imglogo.setOnClickListener(this);
        //实例化sharedpreferences对象.写在onCreate里
        sharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
    }

    @Override
    public void onClick(View view) {
        //判断登录信息是否存在,存在跳转到主界面.不存在跳转到注册登录界面:关键:怎么判断?条件是???本地有没有"Test??
        String name = sharedPreferences.getString("name","");
        if (!name.equals("") && name!=null){
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Intent intent=new Intent(this,Welcome.class);
            startActivity(intent);
            finish();

        }


    }
}
