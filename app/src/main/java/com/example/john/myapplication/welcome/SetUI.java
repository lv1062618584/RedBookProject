package com.example.john.myapplication.welcome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.john.myapplication.R;
import com.example.john.myapplication.fragment.MyFragment;

public class SetUI extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private long exitTime = 0;
    private SharedPreferences sharedPreferences;
    private ImageView imgfanhui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_ui);
        button= (Button) findViewById(R.id.bt_dengchu);
        button.setOnClickListener(this);
        sharedPreferences=getSharedPreferences("test", Activity.MODE_PRIVATE);
        imgfanhui= (ImageView) findViewById(R.id.img_fanhuiwode);
        imgfanhui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_dengchu:
                if ((System.currentTimeMillis() - exitTime) > 2000){
                    Toast.makeText(getApplicationContext(), "再次点击退出账号", Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                }else {
                    Intent intent=new Intent(this,Welcome.class);
                    //实例化sharedpreferences对象
                    SharedPreferences sharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
                    //实例化SharedPreferences.editor对象
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    //用putString的方法保存数据
                    //因为要清空数据,在下一次登录的时候从注册登录界面开始,所以要设为空.
                    editor.putString("name","");
                    editor.putString("Sex", "");
                    //提交当前数据
                    editor.commit();
                    //执行以上代码，SharedPreferences将会把这些数据保存在test.xml文件中，
                    //可以在File Explorer的data/data/相应的包名/test.xml 下导出该文件，并查看。
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.img_fanhuiwode:
//                Intent intent=new Intent(this, MyFragment.class);
//                startActivity(intent);
                finish();
                break;
        }

    }
}
