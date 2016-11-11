package com.example.john.myapplication.welcome.zhuce;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.john.myapplication.MainActivity;
import com.example.john.myapplication.R;

public class ZC3 extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private SharedPreferences sharedPreferences;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc3);
        button= (Button) findViewById(R.id.bt_zhqr);
        button.setOnClickListener(this);
        sharedPreferences=getSharedPreferences("test",Activity.MODE_PRIVATE);
        editText1= (EditText) findViewById(R.id.et_nicheng);
        //editText1.setOnClickListener(this);
        editText2= (EditText) findViewById(R.id.et_xingbie);
        editText3= (EditText) findViewById(R.id.et_mima);
        editText4= (EditText) findViewById(R.id.et_zaiciquerenmima);
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String str = editable.toString();
                String str3 = editText3.getText().toString().trim();
                if (str3.equals(str)){
                    Toast.makeText(ZC3.this, "123", Toast.LENGTH_SHORT).show();
                    button.setBackgroundColor(Color.RED);
                    button.setClickable(true);

                }
            }
        });
        initView();
    }

    private void initView() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_zhqr:
                Intent intent=new Intent(this, MainActivity.class);
                //实例化SharedPreferences.editor对象
                SharedPreferences.Editor editor=sharedPreferences.edit();
                //用putString的方法保存数据,使得我的主页的显示能够通过
                editor.putString("name",editText1.getText()+"");
                editor.putString("Sex",editText2.getText()+"");
                editor.putString("MiMa1",editText2.getText()+"");
                editor.putString("MiMa2",editText2.getText()+"");
                //如果两次密码都一样那么就存入数据库并且使得登录按钮变红可点击
                //提交当前数据
                editor.commit();
                //执行以上代码，SharedPreferences将会把这些数据保存在test.xml文件中，
                //可以在File Explorer的data/data/相应的包名/test.xml 下导出该文件，并查看。
                startActivity(intent);
                finish();
                break;
        }
    }
}
