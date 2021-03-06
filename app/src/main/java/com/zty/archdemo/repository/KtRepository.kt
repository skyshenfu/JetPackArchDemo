package com.zty.archdemo.repository

import com.zty.common.bean.PublicAccountBean
import com.zty.common.bean.ResponseRawBean
import com.zty.common_ktx.http.service.KWanAPI
import com.zty.common_ktx.http.service.KWanService
import com.zty.common_ktx.http.service.safeApiCall

class KtRepository {
    var kwanService:KWanService = KWanAPI.instance.crateService(KWanService::class.java)

    suspend fun getAccount(): ResponseRawBean<List<PublicAccountBean>> {
        return safeApiCall(call={kwanService.getAccount()})
     }
}