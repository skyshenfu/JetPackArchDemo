package com.zty.archdemo.ui.main.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zty.common.base.BaseVMFragment;
import com.zty.oneforall.databinding.FragmentHomeBinding;


public class HomeFragment extends BaseVMFragment<HomeViewModel> {


    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {
        ((FragmentHomeBinding)mBinding).setHomeViewModel((mViewModel));
    }
}
