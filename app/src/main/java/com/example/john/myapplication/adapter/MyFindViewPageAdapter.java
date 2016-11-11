package com.example.john.myapplication.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by lvchenguang on 2016/10/17.
 */
public class MyFindViewPageAdapter extends PagerAdapter {
    private List<ImageView> listImages;
    public MyFindViewPageAdapter(List<ImageView> listImages){
        this.listImages=listImages;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(listImages.get(position% listImages.size()));

        return listImages.get(position% listImages.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);

        container.removeView(listImages.get(position % listImages.size()));
    }
}
