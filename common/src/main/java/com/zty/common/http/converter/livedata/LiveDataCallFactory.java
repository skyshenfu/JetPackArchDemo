package com.zty.common.http.converter.livedata;



import androidx.lifecycle.MutableLiveData;

import com.zty.common.bean.ResponseRawBean;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class LiveDataCallFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != MutableLiveData.class) {
            return null;
        } else {
            Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
            Class<?> rawObservableType = getRawType(observableType);
            if (rawObservableType != ResponseRawBean.class) {
                throw new IllegalArgumentException("type must be a resource");
            }
            if (!(observableType instanceof ParameterizedType)) {
                throw new IllegalArgumentException("resource must be parameterized");
            }
            Type bodyType = getParameterUpperBound(0, (ParameterizedType) observableType);
            return new LiveDataCallAdapter<>(observableType);
        }
    }

}
