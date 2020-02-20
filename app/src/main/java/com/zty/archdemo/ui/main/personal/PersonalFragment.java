package com.zty.archdemo.ui.main.personal;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.zty.common.base.BaseVMFragment;
import com.zty.oneforall.databinding.FragmentPersonalBinding;

public class PersonalFragment extends BaseVMFragment<PersonalViewModel> {
    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentPersonalBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {

    }
}
