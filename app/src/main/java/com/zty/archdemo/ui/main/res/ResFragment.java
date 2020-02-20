package com.zty.archdemo.ui.main.res;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.zty.common.base.BaseVMFragment;
import com.zty.oneforall.databinding.FragmentHomeBinding;
import com.zty.oneforall.databinding.FragmentResBinding;

public class ResFragment  extends BaseVMFragment<ResViewModel> {
    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentResBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {

    }
}
