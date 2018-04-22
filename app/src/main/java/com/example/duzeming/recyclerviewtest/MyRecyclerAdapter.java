package com.example.duzeming.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

//要实现它的三个方法 onCreateViewHolder、onBindViewHolder、getItemCount
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    //title的值
    private ArrayList<String> titleList = new ArrayList<String>();
    //context的值
    private ArrayList<String> contextList = new ArrayList<String>();
    private Context context;

    //创建构造器
    public MyRecyclerAdapter(Context context,ArrayList<String> titleList,ArrayList<String> contextList){
        this.titleList = titleList;
        this.contextList = contextList;
        this.context = context;
    }

    //创建ViewHolder，导入视图
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    //绑定视图
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitle.setText(titleList.get(position));
        holder.tvContext.setText(contextList.get(position));
        //设置Button的点击事件
        holder.btnItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //获取item的数量
    @Override
    public int getItemCount() {
        return titleList.size();
    }


    //移除操作
    public void removeItem(int position){
        titleList.remove(position);
        contextList.remove(position);
        notifyDataSetChanged();
    }
    //添加操作也就很简单了,传入新的标题和内容，调用notifyDataSetChanged()方法

    //使用ViewHolder内部类，来完成view的绑定，进行RecyclerView的优化，不必每一个item都去findViewById
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvContext;
        Button btnItem;

        public MyViewHolder(final View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
            tvContext = (TextView) itemView.findViewById(R.id.tv_item_context);
            btnItem = (Button) itemView.findViewById(R.id.btn_item);
            //这里可以设置每一个item的点击事件，也可以使用接口回调实现点击事件，大家可以查一下
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}

