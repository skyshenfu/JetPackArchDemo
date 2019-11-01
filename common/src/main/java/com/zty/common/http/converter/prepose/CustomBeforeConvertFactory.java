package com.zty.common.http.converter.prepose;

import androidx.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 需要复写返回接受器时复写此方法
 */
public class CustomBeforeConvertFactory extends Converter.Factory {
    private final String rawData;

    public static CustomBeforeConvertFactory create() {
        return create("");
    }
    public static CustomBeforeConvertFactory create(String rawData) {
        return new CustomBeforeConvertFactory(rawData);
    }

    private CustomBeforeConvertFactory(String rawData) {
        if (rawData == null) throw new NullPointerException("response == null");
        this.rawData = rawData;
    }
    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new BeforeResponseBodyConvert();
    }

    @Nullable
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }
}
