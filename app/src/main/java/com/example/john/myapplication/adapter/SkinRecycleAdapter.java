package com.example.john.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.myapplication.R;

/**
 * Created by lvchenguang on 2016/10/20.
 */
public class SkinRecycleAdapter extends RecyclerView.Adapter{
    private static final int TYPE_ONE=0;
    private static final int TYPE_TWO=1;
    private static final int TYPE_THREE=2;
    private static final int TYPE_FOUR=3;
    private Context context;
    public SkinRecycleAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_ONE;
        }
        if (position==1||position==2||position==3||position==4){
            return TYPE_TWO;
        }
        if (position==40){
            return TYPE_FOUR;
        }
        return TYPE_THREE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        switch (viewType){
            case TYPE_ONE:
                //????什么时候是view什么时候是inflate？？
                View view= LayoutInflater.from(context).inflate(
                        R.layout.fragment_skin_item1,parent,false);
                holder=new MyViewHolder1(view);
                break;
            case TYPE_TWO:
            View view2= LayoutInflater.from(context).inflate(
                    R.layout.fragment_skin_item2,parent,false);
            holder=new MyViewHolder2(view2);
            break;
            case TYPE_THREE:
                View view3= LayoutInflater.from(context).inflate(
                        R.layout.fragment_skin_item3,parent,false);
                holder=new MyViewHolder3(view3);
                break;
            case TYPE_FOUR:
                View view4= LayoutInflater.from(context).inflate(
                        R.layout.fragment_skin_item4,parent,false);
                holder=new MyViewHolder4(view4);
                break;
        }
        return holder;
    }
    //???onBindViewHolder:
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder1){
            ((MyViewHolder1)holder).img1.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img2.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img3.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img4.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img5.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img6.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img7.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img8.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img9.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1)holder).img10.setImageResource(R.mipmap.ic_launcher);
            ((MyViewHolder1) holder).img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片1",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片2",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片3",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片4",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片5",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片6",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片7",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片8",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片9",Toast.LENGTH_LONG).show();
                }
            });
            ((MyViewHolder1) holder).img10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这个是图片10",Toast.LENGTH_LONG).show();
                }
            });
        }else
            if (holder instanceof  MyViewHolder2){
                ((MyViewHolder2)holder).img0.setImageResource(R.mipmap.ic_launcher);
                ((MyViewHolder2)holder).img1.setImageResource(R.mipmap.ic_launcher);
                ((MyViewHolder2)holder).img2.setImageResource(R.mipmap.ic_launcher);
                ((MyViewHolder2)holder).img3.setImageResource(R.mipmap.ic_launcher);
                ((MyViewHolder2)holder).img4.setImageResource(R.mipmap.ic_launcher);
                ((MyViewHolder2)holder).img5.setImageResource(R.mipmap.ic_launcher);
                ((MyViewHolder2)holder).img6.setImageResource(R.mipmap.ic_launcher);
                ((MyViewHolder2)holder).img7.setImageResource(R.mipmap.ic_launcher);
                ((MyViewHolder2)holder).text1.setText("测试数据");
                ((MyViewHolder2)holder).text11.setText("666");
                ((MyViewHolder2)holder).text2.setText("测试数据");
                ((MyViewHolder2)holder).text22.setText("666");
                ((MyViewHolder2)holder).text3.setText("测试数据");
                ((MyViewHolder2)holder).text33.setText("666");
                ((MyViewHolder2)holder).text4.setText("测试数据");
                ((MyViewHolder2)holder).text44.setText("666");
                ((MyViewHolder2)holder).text5.setText("测试数据");
                ((MyViewHolder2)holder).text55.setText("666");
                ((MyViewHolder2)holder).text6.setText("测试数据");
                ((MyViewHolder2)holder).text66.setText("666");
                ((MyViewHolder2)holder).text7.setText("测试数据");
                ((MyViewHolder2)holder).text77.setText("666");
                ((MyViewHolder2) holder).img0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"这个是第二组图片1",Toast.LENGTH_LONG).show();
                    }
                });
                ((MyViewHolder2) holder).img1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"这个是第二组图片1",Toast.LENGTH_LONG).show();
                    }
                });
                ((MyViewHolder2) holder).img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"这个是第二组图片2",Toast.LENGTH_LONG).show();
                    }
                });
                ((MyViewHolder2) holder).img3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"这个是第二组图片3",Toast.LENGTH_LONG).show();
                    }
                });
                ((MyViewHolder2) holder).img4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"这个是第二组图片4",Toast.LENGTH_LONG).show();
                    }
                });
                ((MyViewHolder2) holder).img5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"这个是第二组图片5",Toast.LENGTH_LONG).show();
                    }
                });
                ((MyViewHolder2) holder).img6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"这个是第二组图片6",Toast.LENGTH_LONG).show();
                    }
                });
                ((MyViewHolder2) holder).img7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,"这个是第二组图片7",Toast.LENGTH_LONG).show();
                    }
                });
            }else
                if (holder instanceof MyViewHolder3){
                    ((MyViewHolder3)holder).img1.setImageResource(R.mipmap.ic_launcher);
                    ((MyViewHolder3)holder).img2.setImageResource(R.mipmap.ic_launcher);
                    ((MyViewHolder3)holder).txt1.setText("测试数据");
                    ((MyViewHolder3)holder).txt2.setText("测试数据");
                    ((MyViewHolder3)holder).txt3.setText("测试数据");
                    ((MyViewHolder3)holder).txt4.setText("测试数据");
                    ((MyViewHolder3)holder).txt5.setText("测试数据");
                    ((MyViewHolder3)holder).txt6.setText("测试数据");
                    ((MyViewHolder3) holder).img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context,"这个是第三组图片1",Toast.LENGTH_LONG).show();
                        }
                    });
                    ((MyViewHolder3) holder).img2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context,"这个是第三组图片2",Toast.LENGTH_LONG).show();
                        }
                    });
                }
    }

    @Override
    public int getItemCount() {
        return 40;
    }
    class MyViewHolder1 extends RecyclerView.ViewHolder{
        ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;
        public MyViewHolder1(View itemView) {
            super(itemView);
            img1= (ImageView) itemView.findViewById(R.id.skin_item1_img1);
            img2= (ImageView) itemView.findViewById(R.id.skin_item1_img2);
            img3= (ImageView) itemView.findViewById(R.id.skin_item1_img3);
            img4= (ImageView) itemView.findViewById(R.id.skin_item1_img4);
            img5= (ImageView) itemView.findViewById(R.id.skin_item1_img5);
            img6= (ImageView) itemView.findViewById(R.id.skin_item1_img6);
            img7= (ImageView) itemView.findViewById(R.id.skin_item1_img7);
            img8= (ImageView) itemView.findViewById(R.id.skin_item1_img8);
            img9= (ImageView) itemView.findViewById(R.id.skin_item1_img9);
            img10= (ImageView) itemView.findViewById(R.id.skin_item1_img10);
        }
    }
    class MyViewHolder2 extends RecyclerView.ViewHolder{
        ImageView img0,img1,img2,img3,img4,img5,img6,img7;
        TextView text1,text2,text3,text4,text5,text6,text7;
        TextView text11,text22,text33,text44,text55,text66,text77;
        public MyViewHolder2(View itemView) {
            super(itemView);
            img0= (ImageView) itemView.findViewById(R.id.fg_skin_item2_0);
            img1= (ImageView) itemView.findViewById(R.id.fg_skin_item2_img1);
            img2= (ImageView) itemView.findViewById(R.id.fg_skin_item2_img2);
            img3= (ImageView) itemView.findViewById(R.id.fg_skin_item2_img3);
            img4= (ImageView) itemView.findViewById(R.id.fg_skin_item2_img4);
            img5= (ImageView) itemView.findViewById(R.id.fg_skin_item2_img5);
            img6= (ImageView) itemView.findViewById(R.id.fg_skin_item2_img6);
            img7= (ImageView) itemView.findViewById(R.id.fg_skin_item2_img7);
            text1= (TextView) itemView.findViewById(R.id.fg_skin_item2_text1);
            text2= (TextView) itemView.findViewById(R.id.fg_skin_item2_text2);
            text3= (TextView) itemView.findViewById(R.id.fg_skin_item2_text3);
            text4= (TextView) itemView.findViewById(R.id.fg_skin_item2_text4);
            text5= (TextView) itemView.findViewById(R.id.fg_skin_item2_text5);
            text6= (TextView) itemView.findViewById(R.id.fg_skin_item2_text6);
            text7= (TextView) itemView.findViewById(R.id.fg_skin_item2_text7);
            text11= (TextView) itemView.findViewById(R.id.fg_skin_item2_text11);
            text22= (TextView) itemView.findViewById(R.id.fg_skin_item2_txt22);
            text33= (TextView) itemView.findViewById(R.id.fg_skin_item2_text33);
            text44= (TextView) itemView.findViewById(R.id.fg_skin_item2_text44);
            text55= (TextView) itemView.findViewById(R.id.fg_skin_item2_text55);
            text66= (TextView) itemView.findViewById(R.id.fg_skin_item2_text66);
            text77= (TextView) itemView.findViewById(R.id.fg_skin_item2_text77);



        }
    }
    class MyViewHolder3 extends RecyclerView.ViewHolder{
        ImageView img1,img2;
        TextView txt1,txt2,txt3,txt4,txt5,txt6;
        public MyViewHolder3(View itemView) {
            super(itemView);
            img1= (ImageView) itemView.findViewById(R.id.item3_skin_img1);
            img2= (ImageView) itemView.findViewById(R.id.item3_skin_img2);
            txt1= (TextView) itemView.findViewById(R.id.item3_skin_txt1);
            txt2= (TextView) itemView.findViewById(R.id.item3_skin_txt2);
            txt3= (TextView) itemView.findViewById(R.id.item3_skin_txt3);
            txt4= (TextView) itemView.findViewById(R.id.item3_skin_txt4);
            txt5= (TextView) itemView.findViewById(R.id.item3_skin_txt5);
            txt6= (TextView) itemView.findViewById(R.id.item3_skin_txt6);
        }
    }
    class MyViewHolder4 extends RecyclerView.ViewHolder{

        public MyViewHolder4(View itemView) {
            super(itemView);
        }
    }
}
