package com.example.sean_duan.tea_knowledge.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.sean_duan.tea_knowledge.R;
import com.example.sean_duan.tea_knowledge.adapter.LeaderAdapter;

import java.util.ArrayList;
import java.util.List;

public class Leader_Activity extends AppCompatActivity {

    private LinearLayout liDots;
    private ViewPager mViewPager ;
    private List<View> viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_);
        //初始化页面
        initData();
        //初始化视图
        initView();
        //初始化适配器
        initAdapter();
        //初始化体验Button
        initToastButton();
        //初始化点号
        initDots();
        //添加监听事件
        initListener();
    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setCurrentDot(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setCurrentDot(int position) {
        for (int i = 0; i<liDots.getChildCount(); i++) {
            if(i==position){
                ((ImageView)liDots.getChildAt(i)).setBackgroundResource(R.drawable.page_now);
            }else{
                ((ImageView)liDots.getChildAt(i)).setBackgroundResource(R.drawable.page);
            }
            
        }
    }


    private void initDots() {
        for(int i = 0 ; i<viewList.size() ; i++) {

            liDots.addView(getImageView());//在点布局中添加布局
        }
     
        //在集合中返回指定位置的集合
        ((ImageView)liDots.getChildAt(0)).setBackgroundResource(R.drawable.page_now);
        //相当于更改了线性布局中的线性布局的背景的图案，这里初始化第一个界面为被选中的
    }

    private ImageView getImageView() {//圆点
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);//新建一个LinearLayout布局设置为宽度长度自适应
        params.rightMargin = 10 ;
        imageView.setBackgroundResource(R.drawable.page);//添加布局背景
        return imageView ;
    }

    private void initToastButton() {
        Button button = (Button) viewList.get(2).findViewById(R.id.btn_toast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Leader_Activity.this,MainActivity.class));
                finish();//关闭引导页
            }
        });
    }

    private void initAdapter() {
        LeaderAdapter adapter = new LeaderAdapter(viewList);
        mViewPager.setAdapter(adapter);
    }

    private void initData() {
        viewList  = new ArrayList<>();
        viewList.add(getView(R.layout.leader_1));
        viewList.add(getView(R.layout.leader_2));
        viewList.add(getView(R.layout.leader_3));
    }

    private View getView(int resId) {//重构
        View view = LayoutInflater.from(this).inflate(resId,null);
        return view;
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.leader_pager);
        liDots = (LinearLayout) findViewById(R.id.ll_dots);

    }

   
}
