package com.example.john.myapplication;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.john.myapplication.base.BaseActivity;
import com.example.john.myapplication.fragment.FindFragment;
import com.example.john.myapplication.fragment.HomeFragment;
import com.example.john.myapplication.fragment.MessageFragment;
import com.example.john.myapplication.fragment.MyFragment;
import com.example.john.myapplication.fragment.ShoppingFragment;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    private long exitTime = 0;
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction,fragmentTransactionShow;
    private Fragment showFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        startShow();
    }

    private void startShow() {
        fragmentTransactionShow=fragmentManager.beginTransaction();
        if(showFragment!=null){
            fragmentTransactionShow.show(showFragment);
        }else{
            showFragment=new HomeFragment();
            fragmentTransactionShow.add(R.id.container_main,showFragment,HomeFragment.TAG);
        }
        fragmentTransactionShow.commit();
    }


    private void initView() {
        radioGroup = (RadioGroup)findViewById(R.id.rg_main);
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager=getSupportFragmentManager();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_home:
                showCurrentFragment(HomeFragment.TAG,HomeFragment.class);
                break;
            case R.id.rb_find:
                showCurrentFragment(FindFragment.TAG,FindFragment.class);
                break;
            case R.id.rb_shopping:
                showCurrentFragment(ShoppingFragment.TAG,ShoppingFragment.class);
                break;
            case R.id.rb_message:
                showCurrentFragment(MessageFragment.TAG,MessageFragment.class);
                break;
            case R.id.rb_my:
                showCurrentFragment(MyFragment.TAG,MyFragment.class);
                break;
        }
    }

    private void showCurrentFragment(String tag, Class<? extends Fragment> classname){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.hide(showFragment);
        showFragment=fragmentManager.findFragmentByTag(tag);
        if(showFragment!=null){
            fragmentTransaction.show(showFragment);
        }else{
            try {
                try {
                    showFragment=classname.getConstructor().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            fragmentTransaction.add(R.id.container_main,showFragment,tag);
        }
        fragmentTransaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            //两次时间差小于1秒,就退出,否则就无视
           // Activity.
        }
        return super.onKeyDown(keyCode, event);
    }
        public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
//            BaseApplication.getInstance().finishall();
            System.exit(0);
        }
    }

    @Override
    public void onBackPressed() {
        exit();
    }

}
