package com.example.sean_duan.tea_knowledge.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.test.suitebuilder.TestMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sean_duan.tea_knowledge.R;
import com.example.sean_duan.tea_knowledge.adapter.TeaAdapter;
import com.example.sean_duan.tea_knowledge.bean.Tea;
import com.example.sean_duan.tea_knowledge.common.ApiConstant;
import com.example.sean_duan.tea_knowledge.jsonUtils.JsonUtils;
import com.example.sean_duan.tea_knowledge.net.OkhttpUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sean-duan on 2017/7/17.
 */

public class ContentFragment extends Fragment {
    private ListView mListView ;
    private List<Tea> teaList ;
    private TeaAdapter teaAdapter ;
    private OkhttpUtils myOkhttp ;
    private OkHttpClient mokhttpclient ;
    private Request request ;
    private String type ;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            teaList = JsonUtils.parseTeaJson((String)msg.obj);
            //初始化适配器
           // teaAdapter = new TeaAdapter(teaList,ContentFragment.this.getActivity());
            teaAdapter.addList(teaList);
            teaAdapter.notifyDataSetChanged();
            //绑定适配器
            mListView.setAdapter(teaAdapter);
        }


    };
    public static ContentFragment newInstance(String type){
        ContentFragment fragment = new ContentFragment() ;
        Bundle bundle = new Bundle() ;
        bundle.putString("type",type);
        fragment.setArguments(bundle);
        return fragment ;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        mListView = (ListView) view.findViewById(R.id.lv_tea_show);
        teaAdapter = new TeaAdapter(getActivity());
        type = getArguments().getString("type");
        getMessage();
        return view ;
    }

    private void getMessage() {
        mokhttpclient = new OkHttpClient();

        FormBody body = new FormBody.Builder().add("page","0").add("rows","15").add("type",type).build();
        request = new Request.Builder().url(ApiConstant.HEAD_URL_LINE).post(body).build();
        Call call = mokhttpclient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
                message.obj = response.body().string();
                handler.sendMessage(message);
            }
        });
    }
}
