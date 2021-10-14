package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseAcivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取所运行的活动类
        Log.d("BaseAcivity",getClass().getSimpleName());
    }
}
