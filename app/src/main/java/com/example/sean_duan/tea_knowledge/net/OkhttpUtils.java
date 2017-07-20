package com.example.sean_duan.tea_knowledge.net;



import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sean-duan on 2017/7/18.
 */

public class OkhttpUtils {
    private OkHttpClient okHttpClient ;
    private String url ;
    public String msg ;
    private FormBody formBody ;
    private Headers headers ;
    public OkhttpUtils(String url) {//get
        this.url = url ;
        okHttpClient = new OkHttpClient();

    }
    public OkhttpUtils(FormBody body, Headers headers,String url){//post
        this.formBody = body ;
        this.headers = headers ;
        this.url = url ;
        this.msg = new String();
    }

    public void HttpGet(){
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
    public String get_HttpGet(){

        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                msg = " you are false" ;
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Log.e("w w w ",response.body().string());
                //msg = response.body().string() ;
                OkhttpUtils.this.changemessage(response.body().string());

            }
        });
        return "OK" ;
    }
    public void changemessage(String msg){
        this.msg = msg ;
    }
    public String getMessage(){
        return this.msg ;
    }
    public String get_HttpPost(){
        Request request = new Request.Builder().url(url).headers(headers).post(formBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                msg = " False!" ;
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                msg = response.body().string();
            }
        });
        return msg ;
    }
}
