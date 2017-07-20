package com.example.sean_duan.tea_knowledge.jsonUtils;

import com.example.sean_duan.tea_knowledge.bean.Tea;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sean-duan on 2017/7/18.
 */

public class JsonUtils {
    //设置关键字
    public static final String TEA_ID = "id" ;
    public static final String TEA_TITLE = "title" ;
    public static final String TEA_DESCRIPTION = "description" ;
    public static final String TEA_SOURCE = "source" ;
    public static final String TEA_WAP_THUMB = "wap_thumb" ;
    public static final String TEA_CREATE_TIME = "create_time" ;
    public static final String TEA_NICKNAMB = "nickname" ;
    public  static List<Tea> parseTeaJson(String jsonString){
        List<Tea> teaList = new ArrayList<>() ;
        try {
            JSONObject jsonObject = new JSONObject(jsonString) ;
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String id = jsonObject1.getString(TEA_ID);
                String title = jsonObject1.getString(TEA_TITLE);
                String source = jsonObject1.getString(TEA_SOURCE);
                String description = jsonObject1.getString(TEA_DESCRIPTION);

                String wap_thumb = jsonObject1.getString(TEA_WAP_THUMB);
                String create_time = jsonObject1.getString(TEA_CREATE_TIME);
                String nickname = jsonObject1.getString(TEA_NICKNAMB);

                Tea tea = new Tea(id,title,source,description,wap_thumb,create_time,nickname);
                teaList.add(tea) ;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return teaList ;
    }
}
