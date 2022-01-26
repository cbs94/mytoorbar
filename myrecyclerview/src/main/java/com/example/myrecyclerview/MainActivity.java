package com.example.myrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //线性类似于listview
        //mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));//类似于gridview
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));// 线性宫格，类似于瀑布流
        initData();
        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(MainActivity.this,mList));



    }

    private void initData() {
        for (int i = 0;i<30;i++){
            mList.add("这是第"+i+"个数据");
        }
    }
}