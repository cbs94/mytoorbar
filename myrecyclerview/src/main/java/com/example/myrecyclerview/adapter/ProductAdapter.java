package com.example.myrecyclerview.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecyclerview.R;

public class ProductAdapter {
    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView image_product;
        private TextView tv_name;
        private TextView tv_price;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image_product = (ImageView) itemView.findViewById(R.id.img_pro);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}
