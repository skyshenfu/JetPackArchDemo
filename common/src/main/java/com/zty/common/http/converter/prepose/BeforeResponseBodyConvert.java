package com.zty.common.http.converter.prepose;

import androidx.annotation.Nullable;

import com.zty.common.bean.NetBusinessErrorBean;
import com.zty.common.http.exception.NetBusinessException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class BeforeResponseBodyConvert implements Converter<ResponseBody, String>  {

    @Nullable
    @Override
    public String convert(ResponseBody value) throws IOException {
        String rawData=value.string();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(rawData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jsonObject == null){

            throw new NetBusinessException(new NetBusinessErrorBean());
        }else {
            String errorMsg = jsonObject.optString("errorMsg", "");
            String data = jsonObject.optString("data", "");
            int  errorCode =jsonObject.optInt("errorCode",0);
            if (errorCode==0){
                return  data;
            }else {
                throw new NetBusinessException(new NetBusinessErrorBean(errorCode,errorMsg));
            }
        }

    }
}
