package com.zty.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseVMFragment<VM extends BaseViewModel> extends BaseFragment {
    protected VM mViewModel;
    protected ViewDataBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding=generateDataBinding(inflater,container);
        afterOnCreateView(inflater,container,savedInstanceState);
        return mBinding.getRoot();
    }



    protected abstract ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModels();
        setDataForViewModels();
        mBinding.setLifecycleOwner(this);
        afterViewCreated(view,savedInstanceState);
    }

    protected  void afterOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

    }

    protected  void afterViewCreated(View view, Bundle savedInstanceState){

    }


    protected void initViewModels() {
        mViewModel= (VM) new ViewModelProvider(this).get(getResponseClass());
        if (mViewModel!=null){
            getLifecycle().addObserver(mViewModel);
        }
        
    }
    protected abstract void setDataForViewModels();


    @Override
    public void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(mViewModel);

    }

    private Class getResponseClass() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class responseClass =  (Class)params[0];
        return responseClass;
    }

}
