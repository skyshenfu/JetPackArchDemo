/**
 * FileName: BaseActivity
 * Author: zty
 * Date: 2019-10-25 11:04
 * Description: 所有Activity的父类
 */
package com.zty.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.zty.common.global.SharedViewModel;

/**
 * @ClassName: BaseActivity
 * @Description: 基础Activity
 * @Author: zty
 * @Date: 2019-10-25 11:04
 */
public class BaseActivity extends AppCompatActivity {
    protected SharedViewModel mSharedViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedViewModel = getAppViewModelProvider().get(SharedViewModel.class);
    }
    protected ViewModelProvider getAppViewModelProvider() {
        return ((BaseApplication) getApplicationContext()).getAppViewModelProvider(this);
    }
}