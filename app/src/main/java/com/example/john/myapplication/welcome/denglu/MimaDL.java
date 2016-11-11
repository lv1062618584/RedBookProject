package com.example.john.myapplication.welcome.denglu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.myapplication.MainActivity;
import com.example.john.myapplication.R;
import com.example.john.myapplication.base.BaseActivity;

public class MimaDL extends BaseActivity implements View.OnClickListener {
    private ImageView imageView;
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mima_dl);
        imageView= (ImageView) findViewById(R.id.mimafanhui);
        imageView.setOnClickListener(this);
        button= (Button) findViewById(R.id.bt_denglu_mm);
        button.setOnClickListener(this);
        textView= (TextView) findViewById(R.id.wjmm);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mimafanhui:
                finish();
                break;
            case R.id.bt_denglu_mm:
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.wjmm:
                Intent intent2=new Intent(this, ForgetPWD.class);
                startActivity(intent2);
                break;
        }
    }
}
