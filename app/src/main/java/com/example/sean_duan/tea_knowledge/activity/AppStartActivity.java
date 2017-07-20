package com.example.sean_duan.tea_knowledge.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sean_duan.tea_knowledge.R;

public class AppStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_start);
        //判断是否第一次登陆
        startActivity();
    }

    private void startActivity() {
        //获取数据
        SharedPreferences sp = getSharedPreferences("app_start",MODE_PRIVATE);
        boolean isFirstLoading = sp.getBoolean("isFirstLoading",true);
        if(isFirstLoading){
            //启动引导页
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("isFirstLoading",false);
            editor.commit();
            startActivity(new Intent(AppStartActivity.this,Leader_Activity.class));
        }else{
            //启动主页
            startActivity(new Intent(AppStartActivity.this,MainActivity.class));
        }
    }
}
