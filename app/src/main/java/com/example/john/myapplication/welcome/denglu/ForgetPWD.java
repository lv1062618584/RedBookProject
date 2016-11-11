package com.example.john.myapplication.welcome.denglu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.john.myapplication.MainActivity;
import com.example.john.myapplication.R;
import com.example.john.myapplication.base.BaseActivity;

public class ForgetPWD extends BaseActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        imageView= (ImageView) findViewById(R.id.wangjifanhui);
        imageView.setOnClickListener(this);
        button= (Button) findViewById(R.id.bt_wj_2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.wangjifanhui:
                finish();
                break;
            case R.id.bt_wj_2:
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
