package com.example.mygridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHttpClient = new OkHttpClient();
    }

    public void getSync(View view){
        new Thread(){
            @Override
            public void run() {
                Request request = new Request.Builder().url("https://www.org/get?a=1&b=2").build();
                //准备好请求的Call对象
                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    Log.i("wy","getSync:" +response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}