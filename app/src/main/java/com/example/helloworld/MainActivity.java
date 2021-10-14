package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ListView Ivinfo;
    List<Fruit> list  = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_main);
        Ivinfo = (ListView)findViewById(R.id.list_view);
        initFruit();
        //创建适配器对象
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,R.layout.fruit_item,list);
        Ivinfo.setAdapter(myAdapter);
        Ivinfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = list.get(position);
                Toast.makeText(MainActivity.this,"您当前点击了："+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    class MyAdapter extends ArrayAdapter{
        public MyAdapter(Context context, int resource,  List<Fruit> objects) {
            super(context, resource, objects);
        }
        @NonNull
        @Override
        public View getView(int position, View convertView,ViewGroup parent) {
            ViewHoder hoder = null;
            //创建空白的一行
            //getLayoutInflater获取适配器，inflate加载适配器.2种方法
//            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.fruit_item,null);
//            convertView= getLayoutInflater().inflate(R.layout.fruit_item,null);
            //判断convertView中是否为空
            if(convertView==null){
                convertView= getLayoutInflater().inflate(R.layout.fruit_item,null);
                ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview);
                TextView textView = (TextView)convertView.findViewById(R.id.textname);
                hoder = new ViewHoder();
                hoder.img = imageView;
                hoder.name = textView;
                convertView.setTag(hoder);//当前新建的这一行隐藏了一个tag的值
            }else {
                hoder = (ViewHoder) convertView.getTag();
            }

            //修改该行的数据
            //取出该行要显示的数据
            //get每一行的数据
            Fruit fruit = list.get(position);
            hoder.img.setImageResource(fruit.getImageld());
            hoder.name.setText(fruit.getName());
            return convertView;
        }
        class ViewHoder{
            ImageView img;
            TextView name;
        }
    }
    private void initFruit(){
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("第1个",R.drawable.ic_launcher_background);
            list.add(apple);
            Fruit aaa = new Fruit("第2个",R.drawable.mistore_logo);
            list.add(aaa);
            Fruit apple1 = new Fruit("第3个",R.drawable.ic_launcher_background);
            list.add(apple1);
            Fruit aaa1 = new Fruit("第4个",R.drawable.mistore_logo);
            list.add(aaa1);
            Fruit apple2 = new Fruit("第5个",R.drawable.ic_launcher_background);
            list.add(apple2);
            Fruit aaa2 = new Fruit("第6个",R.drawable.mistore_logo);
            list.add(aaa2);
        }
    }
}