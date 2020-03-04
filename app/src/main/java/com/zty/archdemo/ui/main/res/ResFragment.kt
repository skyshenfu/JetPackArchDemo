package com.zty.archdemo.ui.main.res

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

import com.zty.archdemo.databinding.FragmentResBinding
import com.zty.common.base.BaseVMFragment
import com.zty.common.http.download.DownloadListener
import com.zty.common.http.download.DownloadUtil
import okhttp3.ResponseBody
import retrofit2.Call

class ResFragment : BaseVMFragment<ResViewModel>() {
    private var resFragmentClickProxy: ResFragmentClickProxy? = null
    lateinit var call:Call<ResponseBody>
    override fun generateDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewDataBinding {
        return FragmentResBinding.inflate(inflater, container, false)
    }

    override fun setDataForViewModels() {
        (mBinding as FragmentResBinding).resViewModel = mViewModel
        resFragmentClickProxy = ResFragmentClickProxy()
        (mBinding as FragmentResBinding).clickProxy = resFragmentClickProxy


    }

    inner class ResFragmentClickProxy {
        fun jumpToSecond() {
            //跳转
//           (activity as MainHostActivityctivity).navController.navigate(R.id.action_fragment_host_to_fragment_second)
            //协程
            //mViewModel.getData()
            //下载
            call=DownloadUtil.getInstance().download("https://f210aff7500dd7a139d65fd980b30978.dd.cdntips.com/imtt.dd.qq.com/16891/apk/2E31D4F5EBCF94F90D6CE1EFADBF7370.apk",
                 context?.let {
                     val directoryFile=it.getExternalFilesDir("")
                     if (!directoryFile!!.exists())
                         directoryFile.mkdirs()
                     directoryFile.absolutePath+"/"+System.currentTimeMillis()+".apk"
                 },object :DownloadListener{
                    override fun onStart() {
                        Log.e("TAG", Thread.currentThread().name+"onStart:" )
                    }

                    override fun onProgress(progress: Int) {
                        Log.e("TAG", Thread.currentThread().name+"onProgress: $progress" )
                    }

                    override fun onFinish(path: String?) {
                        Log.e("TAG", Thread.currentThread().name+"finish"+path )

                    }

                    override fun onFail(errorInfo: String?) {
                        Log.e("TAG", Thread.currentThread().name+"errorInfo" )

                    }
                }
                )
            DownloadUtil.getInstance().download("http://quality-cdn.shouji.sogou.com/wapdl/android/apk/SogouInput_android_v10.4_sweb.apk",
                context?.let {
                    val directoryFile=it.getExternalFilesDir("")
                    if (!directoryFile!!.exists())
                        directoryFile.mkdirs()
                    directoryFile.absolutePath+"/A"+System.currentTimeMillis()+".apk"
                },object :DownloadListener{
                    override fun onStart() {
                        Log.e("TAG1", Thread.currentThread().name+"onStart:" )
                    }

                    override fun onProgress(progress: Int) {
                        Log.e("TAG1", Thread.currentThread().name+"onProgress: $progress" )
                    }

                    override fun onFinish(path: String?) {
                        Log.e("TAG1", Thread.currentThread().name+"finish"+path )

                    }

                    override fun onFail(errorInfo: String?) {
                        Log.e("TAG1", Thread.currentThread().name+"errorInfo" )

                    }
                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        call.cancel()

    }
}
