package com.zty.archdemo.ui.main.second;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.zty.archdemo.databinding.FragmentSecondBinding;
import com.zty.common.base.BaseVMFragment;
import com.zty.common.bus.LiveDataBus;

import java.util.Random;

public class SecondFragment extends BaseVMFragment<SecondViewModel> {
    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentSecondBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {

        ((FragmentSecondBinding)mBinding).setSecondViewModel(mViewModel);
        ((FragmentSecondBinding)mBinding).setClickProxy(new ClickProxy());

    }
    public class ClickProxy{
        public void click(){
            int temp=new Random().nextInt(300);
            Log.e("TAG", "click: "+temp);
            LiveDataBus.get().with("MCTianYi").postValue(new Integer(temp));

        }
    }
}
