package com.zty.common_ktx.http.service

import android.text.TextUtils
import com.blankj.utilcode.util.ToastUtils
import com.zty.common.bean.NetBusinessErrorBean
import com.zty.common.bean.ResponseRawBean
import com.zty.common.http.exception.NetBusinessException
import java.lang.Exception
import java.net.UnknownHostException


suspend fun <T : Any> safeApiCall(call: suspend () -> ResponseRawBean<T>): ResponseRawBean<T> {
    try {
        var result = call()
        if (result.errorCode != 0) {
            throw NetBusinessException(
                NetBusinessErrorBean(
                    result.errorCode,
                    result.errorMsg
                )
            )
        } else {
            return result
        }

    } catch (e: Exception) {
        return if (e is NetBusinessException) {
            //TODO 不同业务类型对应不同提示语
            ResponseRawBean(e)

        } else {
            //TODO 其他错误类型的处理
            ResponseRawBean(e)
        }
    }
}

fun <T : Any> safeApiBackConvert(
    result: ResponseRawBean<T>,
    success: (data: T) -> Unit = defaultSuccess(),
    error: (msg: String) -> Unit = defaultError(),
    final: () -> Unit = defaultFinal()


) {
    if (result.errorCode != 0 || !TextUtils.isEmpty(result.errorMsg)) {
        preError(result.throwable)
        error(result.errorMsg)
    } else {
        success(result.data)
    }
    final()

}

//默认成功的函数式
private fun <T : Any> defaultSuccess(): (T) -> Unit {
    return {
    }
}

//默认失败的函数式
private fun defaultError(): (String) -> Unit {
    return {
    }
}
//无论成功或者失败多会调用此函数式
private fun defaultFinal(): () -> Unit {
    return {

    }
}
private fun preError(throwable: Throwable){
    when (throwable) {
        is NetBusinessException -> {
            //TODO 处理后台返回码的错误情况

        }
        is UnknownHostException -> {
            ToastUtils.showShort("网络连接失败，请检查网络")

        }
    }

}

