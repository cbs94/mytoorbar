package com.example.myrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private Context context;
    private List<String> mList;
    private LayoutInflater mLayoutInflater;

    public NormalRecyclerViewAdapter(Context context,List<String> list){
        this.context = context;
        this.mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NormalTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.recycle_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NormalTextViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null?0:mList.size();
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;

        public NormalTextViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.recycler_view_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("NormalTextViewHolder","onClick--->position = "+getPosition());
                }
            });
        }
    }
}
