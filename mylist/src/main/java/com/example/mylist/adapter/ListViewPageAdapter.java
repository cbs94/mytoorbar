package com.example.mylist.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mylist.R;

import java.util.List;

public class ListViewPageAdapter extends BaseAdapter {
    private Context context;
    private List<String> myList;

    public ListViewPageAdapter(Context context,List<String> list){
        this.context = context;
        this.myList = list;
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = View.inflate(context, R.layout.listview_activity_item,null);
            viewHolder = new ViewHolder();
            viewHolder.textView = view.findViewById(R.id.list_item_text);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(myList.get(i));
        return view;
    }

    public void addItem(String item){
        myList.add(item);
    }

    public static class ViewHolder{
        private TextView textView;
    }
}
