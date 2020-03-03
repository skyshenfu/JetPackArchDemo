package com.zty.common.http.service;


import androidx.lifecycle.MutableLiveData;

import com.zty.common.bean.PublicAccountBean;
import com.zty.common.bean.ResponseRawBean;
import com.zty.common.http.NetworkConfig;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface WanService {
    @Headers(NetworkConfig.DOMAIN_HOLDER_WHOLE)
    @GET("wxarticle/chapters/json")
    Observable<ResponseRawBean<List<PublicAccountBean>>> getRxPublicAccount();

    @Headers(NetworkConfig.DOMAIN_HOLDER_WHOLE)
    @GET("wxarticle/chapters/json")
    MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> getLiveDataPublicAccount();


}

