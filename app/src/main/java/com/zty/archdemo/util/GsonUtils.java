package com.zty.archdemo.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by oywf on 2016/1/14.
 * gson解析工具类
 */
public class GsonUtils {


    public static <T> T jsonToBean(String jsonResult, Class<T> clz) {
        Gson gson = new Gson();
        T t = null;
        try {
            t = gson.fromJson(jsonResult, clz);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("oywf", "解析报错-->" + e.getMessage());
        }
        return t;
    }

    public static <T> List<T> jsonToList(String jsonResult, Class<T> clz) {
        List<T> list = new ArrayList<>();
        JsonParser parser = new JsonParser();
        Gson gson = new Gson();
        JsonArray jsonarray = parser.parse(jsonResult).getAsJsonArray();
        for (JsonElement element : jsonarray) {
            list.add(gson.fromJson(element, clz));
        }
        return list;
    }



    public static <T> T jsonToBean(String jsonResult, Type type) {
        Gson gson = new Gson();
        T t = null;
        try {
            t = gson.fromJson(jsonResult, type);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("oywf", "解析报错-->" + e.getMessage());
        }
        return t;
    }


    /**
     * 对象转换成json字符串
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }


}
