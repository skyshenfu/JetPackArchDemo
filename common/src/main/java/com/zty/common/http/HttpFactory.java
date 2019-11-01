package com.zty.common.http;

import com.zty.common.http.converter.prepose.CustomBeforeConvertFactory;
import com.zty.common.http.converter.gson.GsonConverterFactory;
import com.zty.common.http.converter.scalar.ScalarsConverterFactory;
import com.zty.common.http.interceptor.ModifyBaseUrlInterceptor;

import java.util.concurrent.TimeUnit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class HttpFactory {
    private Retrofit mRetrofit;
    private OkHttpClient.Builder builder;



    private static class  HttpFactoryHolder{
        private static HttpFactory instance= new HttpFactory();
    }
    private HttpFactory(){
        builder=new OkHttpClient.Builder();
        // 设置超时
        builder.retryOnConnectionFailure(false)
                .connectTimeout(NetworkConfig.NET_CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(NetworkConfig.NET_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(NetworkConfig.NET_WRITE_TIME_OUT, TimeUnit.SECONDS);
        //设置替换baseUrl拦截器，更换baseUrl是通过这个拦截器实现的
        builder.addInterceptor(new ModifyBaseUrlInterceptor());
        OkHttpClient client = builder.build();
        mRetrofit = new Retrofit.Builder()
                // 设置请求的域名，这个是初始的baseUrl
                .baseUrl("https://192.168.111.1")
                // 设置解析转换工厂，用自己定义的
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .build();
        ;
    }
    public <T>  T  crateService(Class<T> targetAPI){
        return mRetrofit.create(targetAPI);
    }

    public  static HttpFactory getInstance(){
        return HttpFactoryHolder.instance;
    }
}
