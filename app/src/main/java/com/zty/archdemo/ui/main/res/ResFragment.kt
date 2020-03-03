package com.zty.archdemo.ui.main.res

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

import com.zty.archdemo.databinding.FragmentResBinding
import com.zty.common.base.BaseVMFragment

class ResFragment : BaseVMFragment<ResViewModel>() {
    private var resFragmentClickProxy: ResFragmentClickProxy? = null
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
//           (activity as MainHostActivityctivity).navController.navigate(R.id.action_fragment_host_to_fragment_second)
            mViewModel.getData()

        }
    }
}
