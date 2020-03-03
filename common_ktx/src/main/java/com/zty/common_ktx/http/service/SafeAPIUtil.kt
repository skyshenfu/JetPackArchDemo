package com.zty.common_ktx.http.service

import android.text.TextUtils
import com.zty.common.bean.NetBusinessErrorBean
import com.zty.common.bean.ResponseRawBean
import com.zty.common.http.exception.NetBusinessException
import java.lang.Exception

class SafeAPIUtil{
    companion object{

        suspend fun  <T:Any> safeApiCall(call:suspend () ->ResponseRawBean<T>):ResponseRawBean<T>{
            try {
                var result= call()
                if (result.errorCode!=0){
                    throw NetBusinessException(NetBusinessErrorBean(result.errorCode,result.errorMsg))
                }else{
                    return  result
                }

            }catch (e:Exception){
                return if (e is NetBusinessException){
                    ResponseRawBean(e)

                }else{
                    ResponseRawBean(e)
                }
            }
        }

        fun  <T:Any> safeResultConvert (result:ResponseRawBean<T>, success:(data:T)->Unit,error:(msg:String)->Unit){
            if(result.errorCode!=0||!TextUtils.isEmpty(result.errorMsg)){
                error(result.errorMsg)
            }else{
                success(result.data)
            }
        }

    }


}
