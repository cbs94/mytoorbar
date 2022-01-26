package com.example.myglide;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glideUse();
    }

    private void glideUse(){
        ImageView iv = new ImageView(this);
        Glide.with(this).load("").into(iv); //这时常规的写法，但是分析的时候进去乱七八糟的
        //请求发送到哪里
        //请求怎么被处理
        //请求如何维护
        RequestManager with = Glide.with(this);
        RequestBuilder<Drawable> load = with.load("");
        load.into(iv);
    }
}