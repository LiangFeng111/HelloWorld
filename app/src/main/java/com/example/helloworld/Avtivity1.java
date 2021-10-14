package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Avtivity1 extends BaseAcivity implements View.OnClickListener {
    private Button btn1;
    private Button exit1;
    private Button chuangShu;
    private EditText data;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activicy1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        exit1 = (Button)findViewById(R.id.exit);
        exit1.setOnClickListener(this);
        chuangShu = (Button)findViewById(R.id.chuangShu);
        chuangShu.setOnClickListener(this);
        data  = (EditText)findViewById(R.id.data);
        data.setOnClickListener(this);
        //隐藏系统自带的标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
    }


    //设置菜单项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    //菜单点击事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(Avtivity1.this,"您点击了Add按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(Avtivity1.this,"您点击了remove按钮",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return true;
    }





    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Intent intent = new Intent();
                intent.setAction("com.example.helloworld.woxiang");
                startActivity(intent);
                break;
            case R.id.exit:
                finish();
                break;
            case R.id.chuangShu:
                String str = data.getText().toString();
                Intent intent1 = new Intent(Avtivity1.this,Activicy2.class);
                intent1.putExtra("data", str);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}