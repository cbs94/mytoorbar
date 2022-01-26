package com.example.mylist.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mylist.R;
import com.example.mylist.adapter.ListViewAdapter;
import com.example.mylist.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ListViewAdapter mAdapter;
    private List<ListBean> mList = new ArrayList<ListBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        ListBean listBean1 = new ListBean("张三");
        ListBean listBean2 = new ListBean("李四");
        ListBean listBean3 = new ListBean("王武");
        mListView = findViewById(R.id.lv);
        mList.add(listBean1);
        mList.add(listBean2);
        mList.add(listBean3);

        for (int i = 0;i<30;i++){
            mList.add(listBean1);
            mList.add(listBean2);
            mList.add(listBean3);
        }

        mAdapter = new ListViewAdapter(MainActivity.this,mList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                switch (scrollState){
                    case SCROLL_STATE_FLING:
                        Log.d("ListViewActivity","惯性滚动");
                    case SCROLL_STATE_IDLE:
                        Log.d("ListViewActivity","空闲");
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.d("ListViewActivity","正在滚动");
            }
        });
    }
}