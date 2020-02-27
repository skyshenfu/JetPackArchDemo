package com.zty.common.http.converter.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zty.common.bean.ResponseRawBean;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<R> implements CallAdapter<R, MutableLiveData<ResponseRawBean<R>>> {

    private  final  Type responseType;
    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public MutableLiveData<ResponseRawBean<R>> adapt(Call<R> call) {
        return new MutableLiveData<ResponseRawBean<R>>() {
            private AtomicBoolean started =new AtomicBoolean(false);

            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false,true)){
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(Call<R> call, Response<R> response) {
                          postValue(new ResponseRawBean<>(response.body()));
                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable t) {
                          postValue(new ResponseRawBean<>(t));
                        }
                    }

                    );
                }
            }
        };
    }
}
