package com.example.john.myapplication.welcome.zhuce;

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

import com.example.john.myapplication.MainActivity;
import com.example.john.myapplication.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class ZHucemima extends AppCompatActivity implements View.OnClickListener,PlatformActionListener {
    private Button button;
    private ImageView imageView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhucemima);
        button= (Button) findViewById(R.id.jinruxiaohongshu);
        button.setOnClickListener(this);
        imageView= (ImageView) findViewById(R.id.QQ_zhuce22);
        imageView.setOnClickListener(this);
        editText= (EditText) findViewById(R.id.qingshuruduanxin);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editText.getText().length()>5){
                    button.setClickable(true);
                    button.setBackgroundColor(Color.RED);

                }
            }
        });
        //实例化sharedpreferences对象.写在onCreate里
        SharedPreferences sharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
        ShareSDK.initSDK(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jinruxiaohongshu:
                //因为是验证码登录所以需要进行信息填写.
                Intent intent=new Intent(this, ZC3.class);
                startActivity(intent);
                break;
            case R.id.QQ_zhuce22:
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
        }


    }
    //这里是用qq登录所以和前边一样就可以
    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

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

    }
}
