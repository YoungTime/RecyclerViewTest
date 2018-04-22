package com.example.duzeming.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String>titleList = new ArrayList<String>();
    private ArrayList<String>contextList = new ArrayList<String>();
    private RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_main);

        //下面manger为设置RecyclerView的布局方式，可以任选一个

        LinearLayoutManager manager = new LinearLayoutManager(this);
        //设置横向滑动（需要设置item_recycler.xml的宽），默认纵向滑动
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        //设置瀑布流，第一个参数表示列数，第二个表示布局方向
        StaggeredGridLayoutManager lauoutmanager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);


        recyclerView.setLayoutManager(manager);
        adapter = new MyRecyclerAdapter(this,titleList,contextList);
        recyclerView.setAdapter(adapter);

    }

    private void init(){
        titleList.add("标题一");
        titleList.add("标题二");
        titleList.add("标题三");
        titleList.add("标题一");
        titleList.add("标题二");
        titleList.add("标题三");
        titleList.add("标题一");
        titleList.add("标题二");
        titleList.add("标题三");
        contextList.add("文本内容一");
        contextList.add("文本内容二");
        contextList.add("文本内容三");
        contextList.add("文本内容一");
        contextList.add("文本内容二");
        contextList.add("文本内容三");
        contextList.add("文本内容一");
        contextList.add("文本内容二");
        contextList.add("文本内容三");
    }
}
