package com.example.john.myapplication.welcome.denglu;

import android.app.Activity;
import android.app.ProgressDialog;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.myapplication.MainActivity;
import com.example.john.myapplication.R;
import com.example.john.myapplication.base.BaseActivity;
import com.example.john.myapplication.welcome.yinsi.Yinsi;
import com.example.john.myapplication.welcome.zhuce.Zhuce;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class Denglu extends BaseActivity implements View.OnClickListener, PlatformActionListener {
    private ImageView imgfanhui;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private ImageView imgQQ;
    private SharedPreferences sharedPreferences;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        imgfanhui = (ImageView) findViewById(R.id.fanhui_denglu222);
        imgfanhui.setOnClickListener(this);
        textView1 = (TextView) findViewById(R.id.ksze);
        textView1.setOnClickListener(this);
        textView2 = (TextView) findViewById(R.id.yisizhengce1);
        textView2.setOnClickListener(this);
        textView3 = (TextView) findViewById(R.id.symm);
        textView3.setOnClickListener(this);
        imgQQ = (ImageView) findViewById(R.id.QQ_denglu);
        imgQQ.setOnClickListener(this);
        //实例化sharedpreferences对象.写在onCreate里
        SharedPreferences sharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
        ShareSDK.initSDK(this);
        button= (Button) findViewById(R.id.bt_xiayibu);
        editText= (EditText) findViewById(R.id.qingshururshoujihaosimida);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editText.getText().length()==11){
                    button.setClickable(true);
                    button.setBackgroundColor(Color.RED);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //这里写了ID，上面也写了ID,算不算一种重复？为啥这么麻烦？不直接监听？
            case R.id.fanhui_denglu222:
                finish();
                break;
            case R.id.ksze:
                Intent intent = new Intent(this, Zhuce.class);
                startActivity(intent);
                break;
            case R.id.yisizhengce1:
                Intent intent1 = new Intent(this, Yinsi.class);
                startActivity(intent1);
                break;
            case R.id.symm:

                Intent intent2 = new Intent(this, MimaDL.class);
                startActivity(intent2);
                break;
            case R.id.QQ_denglu:
                Platform platform = ShareSDK.getPlatform(this, QQ.NAME);
                platform.removeAccount(true);
                //??
                platform.setPlatformActionListener(this);
                //想写一个ProgressDialog进度对话框；进度条对话框；进度条；对话框中的进度条.但是放在那里???
                ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.show();
                // 先拉取本地客户端，不成功后跳转到web界面拉取
                platform.SSOSetting(false);
                platform.showUser(null);
                break;
            case R.id.bt_xiayibu:
                Intent intent3=new Intent(this,Yanzhengmadenglu.class);
                startActivity(intent3);
        }
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//        if (action == Platform.ACTION_USER_INFOR) {
        //???

        PlatformDb platformDb = platform.getDb();


        Intent intent = new Intent(this, MainActivity.class);
        //实例化sharedpreferences对象
        SharedPreferences sharedPreferences=getSharedPreferences("test", Activity.MODE_PRIVATE);
        //实例化SharedPreferences.editor对象
        SharedPreferences.Editor editor=sharedPreferences.edit();
        //用putString的方法保存数据
        editor.putString("name",platformDb.getUserName());
        editor.putString("Sex",platformDb.getUserGender());
        //提交当前数据
        editor.commit();
        //执行以上代码，SharedPreferences将会把这些数据保存在test.xml文件中，
        //可以在File Explorer的data/data/相应的包名/test.xml 下导出该文件，并查看。
        startActivity(intent);
        finish();

    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

        PlatformDb platformDb = platform.getDb();


        Intent intent = new Intent(this, MainActivity.class);
        //实例化sharedpreferences对象
        SharedPreferences sharedPreferences=getSharedPreferences("test", Activity.MODE_PRIVATE);
        //实例化SharedPreferences.editor对象
        SharedPreferences.Editor editor=sharedPreferences.edit();
        //用putString的方法保存数据
        editor.putString("name",platformDb.getUserName());
        editor.putString("Sex",platformDb.getUserGender());
        //提交当前数据
        editor.commit();
        //执行以上代码，SharedPreferences将会把这些数据保存在test.xml文件中，
        //可以在File Explorer的data/data/相应的包名/test.xml 下导出该文件，并查看。
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
