package com.example.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activicy2 extends AppCompatActivity implements View.OnClickListener {
    private Button btn2;
    private Button fanHui;
    private TextView shuJu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activicy2);
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        fanHui = (Button)findViewById(R.id.fanHui);
        fanHui.setOnClickListener(this);
        Intent intent =getIntent();
        String str = intent.getStringExtra("data");
        shuJu = (TextView)findViewById(R.id.shuju);
        shuJu.setText("得到上一个界面的数据："+str);
//        Toast.makeText(Activicy2.this,"得到上一个界面的内容为："+str,Toast.LENGTH_SHORT).show();
    }

    //接收关闭界面的数据方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断是否为界面标识为1的
            if (requestCode==1){
                if (resultCode==RESULT_OK){
                    String hui = data.getStringExtra("caoZuo");
                    Toast.makeText(Activicy2.this,""+hui,Toast.LENGTH_SHORT).show();
                }
            }else {
                //其他界面的数据
            }
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn2:
                Intent intent = new Intent(Activicy2.this,Activity3.class);
                //设置可获取传回值得activity的界面
                startActivityForResult(intent,1);
                break;
            case R.id.fanHui:
                finish();
                break;
            default:
                break;
        }
    }
}