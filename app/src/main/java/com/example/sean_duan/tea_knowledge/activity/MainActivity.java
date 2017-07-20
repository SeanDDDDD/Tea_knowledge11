package com.example.sean_duan.tea_knowledge.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sean_duan.tea_knowledge.R;
import com.example.sean_duan.tea_knowledge.adapter.TeaPagerAdapter;
import com.example.sean_duan.tea_knowledge.fragment.ContentFragment;
import com.example.sean_duan.tea_knowledge.fragment.HeadLineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  TabLayout tabTea ;
    private List<String> titles ;
    private String[] title ;
    private ViewPager mViewPager;
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initData();
        //初始化视图
        initView();
        //初始化适配器
        initAdapter() ;
        //绑定TabLayout和ViewPager
        bind();
        
    }

    private void bind() {
        tabTea.setupWithViewPager(mViewPager);
    }

    private void initAdapter() {
        TeaPagerAdapter adapter = new TeaPagerAdapter(getSupportFragmentManager(),fragments,titles);
        Log.e("lalla",""+fragments.size());
        mViewPager.setAdapter(adapter);
        addTab();
    }

    private void initData(){
        //Log.e("lalalala",titles.size()+" ");
        titles = new ArrayList<String>();

        title = this.getResources().getStringArray(R.array.leader_menu);
        for (int i = 0; i < title.length; i++) {
            titles.add(title[i]);
        }
        //添加页面数据
        fragments = new ArrayList<>();
        fragments.add(new HeadLineFragment());
        fragments.add(ContentFragment.newInstance("56"));
        fragments.add(ContentFragment.newInstance("52"));
        fragments.add(ContentFragment.newInstance("53"));
        fragments.add(ContentFragment.newInstance("54"));
    }

    private void initView() {
        tabTea = (TabLayout) findViewById(R.id.tab_tea);
        //添加Tab到TabLayout布局中
        addTab();
        mViewPager = (ViewPager) findViewById(R.id.vp_tea_main);

    }

    private void addTab() {
        for (int i = 0; i < title.length; i++) {
            Log.e("dffff","lalallalala");
            tabTea.addTab(tabTea.newTab().setText(title[i]));
        }
    }
}
