package com.example.john.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.myapplication.R;
import com.example.john.myapplication.bean.HomeData;
import com.example.john.myapplication.utils.ImageLoader;

import java.util.List;

/**
 * Created by John on 2016/10/17.
 */
public class GridAdapterHome extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<HomeData> list;
    private List<Integer> imageHeight;
    private ImageView imageView;
    public GridAdapterHome(Context context, List<HomeData> list){
        this.context=context;
        this.list=list;
        ImageLoader.init(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.item_recyclerview_home, parent, false);
        MyHolder myHolder=new MyHolder(inflate);
//        imageView= (ImageView) inflate.findViewById(R.id.img_item_recyclerview_home);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"点了",Toast.LENGTH_SHORT).show();
//            }
//        });
        return myHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder) holder).txt.setText(list.get(position).getName());
            ImageLoader.display(((MyHolder) holder).img,list.get(position).getImages_list().get(0).getUrl());
            ViewGroup.LayoutParams layoutParams=((MyHolder) holder).img.getLayoutParams();
            layoutParams.width=300;
//            layoutParams.height=imageHeight.get(position);
            ((MyHolder) holder).img.setLayoutParams(layoutParams);

            ((MyHolder) holder).content.setText(list.get(position).getDesc());
            ImageLoader.display(((MyHolder) holder).img1,list.get(position).getUser().getImages());
            ((MyHolder) holder).txt1.setText(list.get(position).getUser().getNickname());


        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{


        ImageView img,img1,img2;
        TextView txt,txt1,txt2,content;
        LinearLayout linearLayout;

        public MyHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.img_item_recyclerview_home);
            txt= (TextView) itemView.findViewById(R.id.txt_item_recyclerview_home);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.linearlayout_item_home);
            img1= (ImageView) itemView.findViewById(R.id.img_item_recyclerview_home_bottom1);
            img2= (ImageView) itemView.findViewById(R.id.img_item_recyclerview_home_bottom2);
            txt1= (TextView) itemView.findViewById(R.id.txt_item_recyclerview_home_bottom1);
            txt2= (TextView) itemView.findViewById(R.id.txt_item_recyclerview_home_bottom2);
            content= (TextView) itemView.findViewById(R.id.fg_home_content);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,""+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,""+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"个人信息"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
            txt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"个人信息"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"点赞"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
            txt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"点赞"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
