package com.zty.common_ktx.http.service

import com.zty.common.bean.PublicAccountBean
import com.zty.common.bean.ResponseRawBean
import com.zty.common.http.NetworkConfig
import retrofit2.http.GET
import retrofit2.http.Headers

interface KWanService {

    @Headers(NetworkConfig.DOMAIN_HOLDER_WHOLE)
    @GET("wxarticle/chapters/json")
    suspend fun getAccount():ResponseRawBean<List<PublicAccountBean>>
}