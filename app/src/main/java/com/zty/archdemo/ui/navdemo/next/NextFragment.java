package com.zty.archdemo.ui.navdemo.next;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;

import com.zty.archdemo.R;
import com.zty.archdemo.databinding.FragmentListBinding;
import com.zty.archdemo.databinding.FragmentNextBinding;
import com.zty.common.base.BaseFragment;
import com.zty.common.base.BaseVMFragment;
import com.zty.common.base.BaseViewModel;
import com.zty.common.bus.LiveDataBus;

import java.util.Random;

public class NextFragment extends BaseVMFragment<BaseViewModel> {

    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentNextBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {
        ((FragmentNextBinding)mBinding).setClickProxy(new NextFragmentClickProxy());
    }

    public class NextFragmentClickProxy{
        public void sendData(){
            Integer a=new Integer(new Random().nextInt());
            LiveDataBus.get().with("ZTY").postStickyData(a);
        }
    }
}
