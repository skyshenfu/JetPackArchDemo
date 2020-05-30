package com.zty.archdemo.ui.main.another;


import android.util.Log;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.zty.archdemo.R;
import com.zty.archdemo.databinding.ActivityAnotherBinding;
import com.zty.common.base.BaseVMActivity;
import com.zty.common.bus.LiveDataBus;

import java.util.Random;

public class AnotherActivity extends BaseVMActivity<AnotherViewModel> {
    @Override
    protected ViewDataBinding generateDataBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_another);
    }

    @Override
    protected void setDataForViewModels() {
        ((ActivityAnotherBinding)mBinding).setAnotherViewModel(mViewModel);
        ((ActivityAnotherBinding)mBinding).setClickProxy(new ClickProxy());


    }

    public class ClickProxy{
        public  void click(){
            int temp=new Random().nextInt(300);
            Log.e("TAG", "click: "+temp);
            LiveDataBus.get().with("MCTianYi").postValue(temp);
        }
    }
}
