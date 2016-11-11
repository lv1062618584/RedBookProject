package com.example.john.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.myapplication.R;
import com.example.john.myapplication.bean.FindRemen;
import com.example.john.myapplication.bean.FindRemen_1;
import com.example.john.myapplication.bean.FindRemen_uesr;
import com.example.john.myapplication.utils.ImageLoader;

import java.util.List;

/**
 * Created by lvchenguang on 2016/10/17.
 */
public class MyFindAdapter extends BaseAdapter {
    private List<FindRemen>list1;
    private List<FindRemen_uesr>list_user;
    private List<FindRemen_1>list_1;
    private Context context;
    public MyFindAdapter(Context context, List<FindRemen>list1){
        this.context=context;
        this.list1=list1;
    }
    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public FindRemen getItem(int position) {
        return list1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if (convertView==null){
            holder=new MyViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_center_fragment,parent,false);

            holder.txtBiji= (TextView) convertView.findViewById(R.id.txt_findgrament_biji);
            holder.txtFensi= (TextView) convertView.findViewById(R.id.txt_findgrament_fensi);
            holder.txtTitle= (TextView) convertView.findViewById(R.id.txt_findgrament_title);
            holder.txtNNAme= (TextView) convertView.findViewById(R.id.txt_findfragment_name);
            holder.img1= (ImageView) convertView.findViewById(R.id.img_findfragment_1);
            holder.img2= (ImageView) convertView.findViewById(R.id.img_findfragment_2);
            holder.img3= (ImageView) convertView.findViewById(R.id.img_findfragment_3);
            holder.img4= (ImageView) convertView.findViewById(R.id.img_findfragment_4);
            holder.imgTou= (ImageView) convertView.findViewById(R.id.img_findfragment_touxiang);

            convertView.setTag(holder);
        }else{
            holder= (MyViewHolder) convertView.getTag();
        }
        holder.txtTitle.setText(list1.get(position).getName());
        holder.txtBiji.setText(list1.get(position).getTotal());
        holder.txtFensi.setText(list1.get(position).getFans());
        //？？？这里为啥要写0？难道要写10个吗？
        holder.txtNNAme.setText(getItem(position).getList_user().getNickname());
        ImageLoader.display(holder.imgTou,getItem(position).getList_user().getImages());
        ImageLoader.display(holder.img1,getItem(position).getList_img().get(0));
        ImageLoader.display(holder.img2,getItem(position).getList_img().get(1));
        ImageLoader.display(holder.img3,getItem(position).getList_img().get(2));
        ImageLoader.display(holder.img4,getItem(position).getList_img().get(3));

        //设置点击事件监听是在if里还是在解析处?
        holder.imgTou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击进入"+getItem(position).getList_user().getNickname()+"的个人页面",Toast.LENGTH_LONG).show();
            }
        });
        holder.txtBiji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击的是"+getItem(position).getList_user().getNickname()+"写的具体内容",Toast.LENGTH_LONG).show();
            }
        });
        holder.txtFensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击的是"+getItem(position).getList_user().getNickname()+"写的具体内容",Toast.LENGTH_LONG).show();
            }
        });
        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击的是"+getItem(position).getList_user().getNickname()+"写的具体内容",Toast.LENGTH_LONG).show();
            }
        });
        holder.txtNNAme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击的是"+getItem(position).getList_user().getNickname()+"写的具体内容",Toast.LENGTH_LONG).show();
            }
        });
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击的是"+getItem(position).getList_user().getNickname()+"写的具体内容",Toast.LENGTH_LONG).show();
            }
        });
        holder.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击的是"+getItem(position).getList_user().getNickname()+"写的具体内容",Toast.LENGTH_LONG).show();
            }
        });
        holder.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击的是"+getItem(position).getList_user().getNickname()+"写的具体内容",Toast.LENGTH_LONG).show();
            }
        });
        holder.img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击的是"+getItem(position).getList_user().getNickname()+"写的具体内容",Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
    class MyViewHolder{
        private LinearLayout linearLayout0;
        private TextView txtTitle,txtBiji,txtFensi,txtNNAme;
        private ImageView img1,img2,img3,img4,imgTou;
    }
}
