package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity implements View.OnClickListener {
    private Button btn3;
    private Button fanHui1;
    private EditText text;
    private Button call;
    private Button jinDu;
    private ProgressBar jinduTiao;
    private EditText tiao_zhuang_linajIe;
    private Button tiao_zhuang;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        fanHui1 = (Button)findViewById(R.id.fanHui1);
        fanHui1.setOnClickListener(this);
        text = (EditText)findViewById(R.id.activity_EditText);
        call = (Button)findViewById(R.id.call);
        call.setOnClickListener(this);
        jinDu = (Button)findViewById(R.id.jinDu);
        jinDu.setOnClickListener(this);
        jinduTiao = (ProgressBar)findViewById(R.id.jinDuTiao);
        tiao_zhuang = (Button)findViewById(R.id.tiao_zuang);
        tiao_zhuang.setOnClickListener(this);
        tiao_zhuang_linajIe = (EditText) findViewById(R.id.tiao_zuang_linaJIe);

    }

    //返回按钮的操作
    @Override
    public void onBackPressed() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn3:
                Uri uri = Uri.parse("http://www.baidu.com");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                break;
            case R.id.fanHui1:
                String text_edit = text.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("caoZuo","第三个界面返回的数据："+text_edit);
                //返回数据给前一个界面，数据为ok，也可以为取消
                setResult(RESULT_OK,intent1);
                finish();
                break;
            case R.id.call:
                Intent intent2  = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:10086"));
                startActivity(intent2);
                break;
            case R.id.jinDu:
                //判断是否为隐藏状态
                if (jinduTiao.getVisibility()==View.GONE){
                    jinduTiao.setVisibility(View.VISIBLE);
                }else {
                    jinduTiao.setVisibility(View.GONE);
                }
                break;
            case R.id.tiao_zuang:
                AlertDialog.Builder dialog = new AlertDialog.Builder(Activity3.this);
                dialog.setTitle("温馨提示？");
                dialog.setMessage("是否要跳转？");
                //设置不可按返回键
                dialog.setCancelable(false);
                //设置对话框确认按钮点击事件
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = tiao_zhuang_linajIe.getText().toString();
                        Uri uri = Uri.parse("http://"+url);
                        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                    }
                });
                //设置对话框取消按钮点击事件
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity3.this,"您取消了跳转",Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }
}