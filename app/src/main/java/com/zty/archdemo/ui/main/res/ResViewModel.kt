package com.zty.archdemo.ui.main.res

import com.zty.archdemo.repository.KtRepository
import com.zty.common.base.BaseViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.zty.common_ktx.http.service.safeApiBackConvert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResViewModel() : BaseViewModel(){
    private var repository: KtRepository = KtRepository()
    fun getData(){
     viewModelScope.launch(Dispatchers.Main) {
            //切换至IO线程
             var result=getDataFromNet()
            //回到主线程
            safeApiBackConvert(result,{
                ToastUtils.showShort(it.size)
                LogUtils.e(Thread.currentThread())
            },error = {
                LogUtils.e(it)

            },final={
                LogUtils.e("doFinally")

            }

            )
                //safeApiBackConvert(result)

        }
    }

    private suspend fun getDataFromNet()= withContext(Dispatchers.IO){
        LogUtils.e(Thread.currentThread().name)
        repository.getAccount()
    }

}
