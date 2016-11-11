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

/**
 * Created by 徐陈承 on 2016/10/18.
 */

public class SHoppingRecycleAdapter extends RecyclerView.Adapter {

    private static final int TYPE_ONE=0;

    private static final int TYPE_TWO=1;

   private Context context;
   public SHoppingRecycleAdapter(Context context){
       this.context=context;
   }


    @Override
    public int getItemViewType(int position) {
        if(position==0||position==1){
            return TYPE_ONE;
        }
            return TYPE_TWO;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        switch (viewType){
            case TYPE_ONE:
                View view = LayoutInflater.from(context).inflate(R.layout.fg_allshopping_item1, parent, false);
                holder=new MyViewHolder2(view);
                break;
            case TYPE_TWO:
                View inflate = LayoutInflater.from(context).inflate(R.layout.fg_allshopping_item2, parent, false);
                holder=new MyViewHolder(inflate);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        if(holder instanceof MyViewHolder2){
            ((MyViewHolder2) holder).image.setImageResource(R.mipmap.ic_launcher);
        }else
        if(holder instanceof MyViewHolder){
             ((MyViewHolder) holder).imgmain.setImageResource(R.mipmap.ic_launcher);

             ((MyViewHolder) holder).img1.setImageResource(R.mipmap.ic_launcher);
             ((MyViewHolder) holder).text1.setText("测试数据");
             ((MyViewHolder) holder).text11.setText("128");

             ((MyViewHolder) holder).img2.setImageResource(R.mipmap.ic_launcher);
             ((MyViewHolder) holder).text2.setText("测试数据");
             ((MyViewHolder) holder).text22.setText("128");

             ((MyViewHolder) holder).img3.setImageResource(R.mipmap.ic_launcher);
             ((MyViewHolder) holder).text3.setText("测试数据");
             ((MyViewHolder) holder).text33.setText("128");

             ((MyViewHolder) holder).img4.setImageResource(R.mipmap.ic_launcher);
             ((MyViewHolder) holder).text4.setText("测试数据");
             ((MyViewHolder) holder).text44.setText("128");

             ((MyViewHolder) holder).img5.setImageResource(R.mipmap.ic_launcher);
             ((MyViewHolder) holder).text5.setText("测试数据");
             ((MyViewHolder) holder).text55.setText("128");

             ((MyViewHolder) holder).img6.setImageResource(R.mipmap.ic_launcher);
             ((MyViewHolder) holder).text6.setText("测试数据");
             ((MyViewHolder) holder).text66.setText("128");

             ((MyViewHolder) holder).img7.setImageResource(R.mipmap.ic_launcher);
             ((MyViewHolder) holder).text7.setText("测试数据");
             ((MyViewHolder) holder).text77.setText("128");
         }
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{
        private ImageView image;
        public MyViewHolder2(View itemView) {
            super(itemView);
            image= (ImageView) itemView.findViewById(R.id.fg_allshopping_item1_img);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,""+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgmain,img1,img2,img3,img4,img5,img6,img7;
        TextView text1,text2,text3,text4,text5,text6,text7;
        TextView text11,text22,text33,text44,text55,text66,text77;
        LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7,linearLayout8;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgmain= (ImageView) itemView.findViewById(R.id.fg_allshopping_item2_imgmain);
            imgmain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,""+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                }
            });

            img1= (ImageView) itemView.findViewById(R.id.fg_allshopping_item2_img1);
            text1= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text1);
            text11= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text11);
            linearLayout1= (LinearLayout) itemView.findViewById(R.id.linearlayout1);
            linearLayout1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,getLayoutPosition()+":商品1",Toast.LENGTH_SHORT).show();
                }
            });

            img2= (ImageView) itemView.findViewById(R.id.fg_allshopping_item2_img2);
            text2= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text2);
            text22= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text22);
            linearLayout2= (LinearLayout) itemView.findViewById(R.id.linearLayout2);
            linearLayout2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,getLayoutPosition()+":商品2",Toast.LENGTH_SHORT).show();
                }
            });

            img3= (ImageView) itemView.findViewById(R.id.fg_allshopping_item2_img3);
            text3= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text3);
            text33= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text33);
            linearLayout3= (LinearLayout) itemView.findViewById(R.id.linearLayout3);
            linearLayout3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,getLayoutPosition()+":商品3",Toast.LENGTH_SHORT).show();
                }
            });

            img4= (ImageView) itemView.findViewById(R.id.fg_allshopping_item2_img4);
            text4= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text4);
            text44= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text44);
            linearLayout4= (LinearLayout) itemView.findViewById(R.id.linearLayout4);
            linearLayout4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,getLayoutPosition()+":商品4",Toast.LENGTH_SHORT).show();
                }
            });

            img5= (ImageView) itemView.findViewById(R.id.fg_allshopping_item2_img5);
            text5= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text5);
            text55= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text55);
            linearLayout5= (LinearLayout) itemView.findViewById(R.id.linearLayout5);
            linearLayout5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,getLayoutPosition()+":商品5",Toast.LENGTH_SHORT).show();
                }
            });

            img6= (ImageView) itemView.findViewById(R.id.fg_allshopping_item2_img6);
            text6= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text6);
            text66= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text66);
            linearLayout6= (LinearLayout) itemView.findViewById(R.id.linearLayout6);
            linearLayout6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,getLayoutPosition()+":商品6",Toast.LENGTH_SHORT).show();
                }
            });

            img7= (ImageView) itemView.findViewById(R.id.fg_allshopping_item2_img7);
            text7= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text7);
            text77= (TextView) itemView.findViewById(R.id.fg_allshopping_item2_text77);
            linearLayout7= (LinearLayout) itemView.findViewById(R.id.linearLayout7);
            linearLayout7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,getLayoutPosition()+":商品7",Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout8= (LinearLayout) itemView.findViewById(R.id.linearLayout8);
            linearLayout8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,getLayoutPosition()+":全部商品",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
