
package com.zty.common_ktx.http.service

import com.zty.common.http.NetworkConfig
import com.zty.common.http.converter.gson.GsonConverterFactory
import com.zty.common.http.converter.livedata.LiveDataCallFactory
import com.zty.common.http.converter.scalar.ScalarsConverterFactory
import com.zty.common.http.interceptor.ModifyBaseUrlInterceptor
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class KWanAPI  private constructor(){

    private lateinit var kWanService:KWanService
    private  var builder:OkHttpClient.Builder
    private  var mRetrofit:Retrofit;
    companion object{
        val instance:KWanAPI by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            KWanAPI()
        }
    }
    init {
        builder = OkHttpClient.Builder()
        // 设置超时
        builder.retryOnConnectionFailure(false)
            .connectTimeout(NetworkConfig.NET_CONNECT_TIME_OUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(NetworkConfig.NET_READ_TIME_OUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(NetworkConfig.NET_WRITE_TIME_OUT.toLong(), TimeUnit.SECONDS)
        //设置替换baseUrl拦截器，更换baseUrl是通过这个拦截器实现的
        builder.addInterceptor(ModifyBaseUrlInterceptor())
        val client = builder.build()
        mRetrofit = Retrofit.Builder()
            // 设置请求的域名，这个是初始的baseUrl
            .baseUrl("https://192.168.111.1")
            // 设置解析转换工厂，用自己定义的
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallFactory())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }

    fun <T> crateService(targetAPI: Class<T>): T {
        return mRetrofit.create(targetAPI)
    }


}