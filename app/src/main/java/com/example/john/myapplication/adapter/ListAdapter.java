package com.example.john.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.myapplication.R;

/**
 * Created by John on 2016/10/19.
 */
public class ListAdapter extends BaseAdapter {

    private Context context;

    public ListAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_listview_message_inform,parent,false);
            holder=new MyViewHolder();
            holder.icon= (ImageView) convertView.findViewById(R.id.icon_listview);
            holder.pic= (ImageView) convertView.findViewById(R.id.pic);
            holder.txt= (TextView) convertView.findViewById(R.id.txt);
            convertView.setTag(holder);
        }else{
            holder= (MyViewHolder) convertView.getTag();
        }

        holder.icon.setImageResource(R.mipmap.ic_launcher);
        holder.pic.setImageResource(R.mipmap.ic_launcher);
        holder.txt.setText("2016-10-06 20:00");

        return convertView;
    }

    class MyViewHolder{
        private ImageView icon,pic;
        private TextView txt;
    }

}
