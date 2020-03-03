package com.zty.archdemo.ui.main.res

import android.widget.Toast
import com.zty.archdemo.repository.KtRepository
import com.zty.common.base.BaseViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.zty.common_ktx.http.service.SafeAPIUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResViewModel() : BaseViewModel(){
    private var repository: KtRepository = KtRepository()
    fun getData(){
     val job=viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                var result= repository.getAccount()
                withContext(Dispatchers.Main){
                    SafeAPIUtil.safeResultConvert(result,{
                        LogUtils.e(Thread.currentThread().name)

                    },{
                        LogUtils.e(Thread.currentThread().name)
                        LogUtils.e(it)

                    })
                }
            }

        }
    }

}
