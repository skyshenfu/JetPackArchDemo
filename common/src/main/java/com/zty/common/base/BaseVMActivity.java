/**
 * FileName: BaseVMActivity
 * Author: zty
 * Date: 2019-10-25 13:46
 * Description: 使用MVVM的Activity
 */
package com.zty.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * @ClassName: BaseVMActivity
 * @Description: MVVM的Activity
 * @Author: zty
 * @Date: 2019-10-25 13:46
 */
public abstract class BaseVMActivity<VM extends BaseViewModel> extends  BaseActivity {
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
        initDataBinding();

    }


    private void initViewModel() {
        mViewModel= (VM) new ViewModelProvider(this).get(getResponseClass());
        if (mViewModel!=null){
         getLifecycle().addObserver(mViewModel);
        }
    }
    protected abstract void initDataBinding();


    @Override
    protected void onDestroy() {
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