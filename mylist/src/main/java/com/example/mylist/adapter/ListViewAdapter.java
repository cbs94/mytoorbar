package com.example.mylist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylist.R;
import com.example.mylist.bean.ListBean;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<ListBean> mList;
    private Context mContext;

    public ListViewAdapter(Context context,List<ListBean> listBeans){
        mContext = context;
        mList = listBeans;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = View.inflate(mContext, R.layout.listview_item,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.li_img);
            viewHolder.textView = view.findViewById(R.id.li_tv);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(mList.get(i).getTitle());
        return view;
    }

    public static class ViewHolder{
        private ImageView imageView;
        private TextView textView;
    }
}
