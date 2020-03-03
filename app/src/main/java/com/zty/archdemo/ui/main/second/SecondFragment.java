package com.zty.archdemo.ui.main.second;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.zty.archdemo.databinding.FragmentSecondBinding;
import com.zty.common.base.BaseVMFragment;

public class SecondFragment extends BaseVMFragment<SecondViewModel> {
    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentSecondBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {

    }
}
