package com.example.mylist.views;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.mylist.R;
import com.example.mylist.adapter.ListViewPageAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends ListActivity implements AbsListView.OnScrollListener {
    private ListView mListView;
    private View view;
    private ListViewPageAdapter mAdapter;
    private int visibleLastIndex = 0; //最后的可视项索引
    private int visibleItemCount; //当前窗口可见项总数
    private Button loadButton;
    private Handler handler = new Handler();
    private List<String> list = new ArrayList<String>();
    private View loadMoreView;
    private Button loadMoreButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        loadMoreView = getLayoutInflater().inflate(R.layout.load_more, null);
        loadMoreButton = (Button) loadMoreView.findViewById(R.id.bt_load_more);
        initData();
        mListView = getListView();
        initAdapter();
        mListView.setAdapter(mAdapter);
        mListView.addFooterView(loadMoreView);
        mListView.setOnScrollListener(this);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadMore(view);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }
    }

    private void initAdapter() {
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(String.valueOf(i + 1));
        }
        mAdapter = new ListViewPageAdapter(ListViewActivity.this, items);
    }

    private void loadData() {
        int count = mAdapter.getCount();
        for (int i = count; i < count + 10; i++) {
            mAdapter.addItem(String.valueOf(i + 1));
        }
    }

    public void loadMore(View view){
        loadMoreButton.setText("loading...");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
                mAdapter.notifyDataSetChanged();
                mListView.setSelection(visibleLastIndex - visibleItemCount+1);
                loadMoreButton.setText("load more");

            }
        },2000);
    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        int itemsLastIndex = mAdapter.getCount()-1;
        int lastIndex = itemsLastIndex+1;
        if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && visibleLastIndex == lastIndex){
            Log.i("LoadingMore","loading...");
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        this.visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
    }
}
