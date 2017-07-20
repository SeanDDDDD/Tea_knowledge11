package com.example.sean_duan.tea_knowledge.adapter;

import android.content.Context;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sean_duan.tea_knowledge.R;
import com.example.sean_duan.tea_knowledge.bean.Tea;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.zip.Inflater;

/**
 * Created by sean-duan on 2017/7/18.
 */

public class TeaAdapter extends BaseAdapter {
    private List<Tea> teaList ;
    private Context context ; //当前上下文
    private LayoutInflater layoutInflater ;
    public TeaAdapter(List<Tea> teaList , Context context) {
        this.teaList = teaList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    public TeaAdapter( Context context) {
       // this.teaList = teaList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return teaList.size();
    }

    @Override
    public Object getItem(int position) {
        return teaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_tea,parent,false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_tea_title);
            viewHolder.tvdescription = (TextView) convertView.findViewById(R.id.tv_tea_description);
            viewHolder.tvSource = (TextView) convertView.findViewById(R.id.tv_tea_source);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_icon);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Tea tea  = teaList.get(position);
        viewHolder.tvTitle.setText(tea.getTitle());
        viewHolder.tvTitle.setText(tea.getDescription());
        viewHolder.tvTitle.setText(tea.getSource()+"  "+tea.getNickname()+"  "+tea.getCreate_time());
        String imgUrl = tea.getWap_thump() ;
        //添加图片

            Log.w("ddddffffffff",imgUrl);
            Glide.with(context)
                    .load(imgUrl)
                    .into(viewHolder.imageView);



        return convertView;
    }
    public void addList(List<Tea> mlist){
        teaList = mlist ;
    }
    class ViewHolder{
        private TextView tvTitle ;
        private TextView tvdescription ;
        private TextView tvSource ;
        private ImageView imageView ;
    }
}
