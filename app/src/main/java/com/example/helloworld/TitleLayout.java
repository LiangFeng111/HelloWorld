package com.example.helloworld;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context,  AttributeSet attrs) {
        super(context, attrs);
        //把标题的布局传入，然后在设置事件
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button titleBack = (Button)findViewById(R.id.title_back);
        Button titleEdit = (Button)findViewById(R.id.title_edit);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加标题back点击事件
                ((Activity)getContext()).finish();
            }
        });
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"您点击了Edit按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
