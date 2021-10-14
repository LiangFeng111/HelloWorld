package com.example.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {
    //要显示在列表的数据原
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    private RecyclerView myRcycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyview);
        initFruit();//数据初始化的工作
        myRcycler =(RecyclerView) findViewById(R.id.MyRecycler);
        //创建一个布局管理方式，交给Recycler
        LinearLayoutManager MyManager= new LinearLayoutManager(this);
        //设置水平方向摆放
        MyManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //网格布局方式,每行5个
//        GridLayoutManager MyManager = new GridLayoutManager(this,5);
        myRcycler.setLayoutManager(MyManager);
        //适配器对象
        MyAdapter adapter = new MyAdapter();
        myRcycler.setAdapter(adapter);
    }
//    创建Recyclerview显示数据时的适配器类
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        //创建空白行以及缓存控件对象
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //获取当前的布局文件加载器,创建空白的一行
            View rowView  = LayoutInflater.from(MainActivity1.this).inflate(R.layout.fruit_item,null);
            //创建缓存控件对象
            ViewHolder vh = new ViewHolder(rowView);
            return vh;
        }
        //数据修改，绑定数据
        public void onBindViewHolder(MainActivity1.MyAdapter.ViewHolder holder, int position) {
            Fruit fruit  =fruitList.get(position);//用下标获取
            //对控件中的数据进行绑定
            holder.textView.setText(fruit.getName());
            holder.imageView.setImageResource(fruit.getImageld());
        }
        //一共创建多少个资源，多少个数据
        public int getItemCount() {
            return fruitList.size();
        }

        //定义内部类用于缓存每行控件的优化对象
        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView textView;

            public ViewHolder(View itemView) {
                //View表示这一行的
                super(itemView);
                imageView =(ImageView) itemView.findViewById(R.id.imageview);
                textView = (TextView) itemView.findViewById(R.id.textname);
            }
        }
    }

    private void initFruit(){
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("第1个",R.drawable.ic_launcher_background);
            fruitList.add(apple);
            Fruit aaa = new Fruit("第2个",R.drawable.mistore_logo);
            fruitList.add(aaa);
            Fruit apple1 = new Fruit("第3个",R.drawable.ic_launcher_background);
            fruitList.add(apple1);
            Fruit aaa1 = new Fruit("第4个",R.drawable.mistore_logo);
            fruitList.add(aaa1);
            Fruit apple2 = new Fruit("第5个",R.drawable.ic_launcher_background);
            fruitList.add(apple2);
            Fruit aaa2 = new Fruit("第6个",R.drawable.mistore_logo);
            fruitList.add(aaa2);
        }
    }
}
