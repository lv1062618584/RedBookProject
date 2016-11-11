package com.example.john.myapplication.welcome.yinsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.john.myapplication.R;
import com.example.john.myapplication.base.BaseActivity;

public class Yinsi extends BaseActivity implements View.OnClickListener {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yinsi);
        img= (ImageView) findViewById(R.id.fanhui_denglu);
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
