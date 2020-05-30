package com.zty.archdemo.ui;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.zty.archdemo.R;
import com.zty.common.base.BaseActivity;
import com.zty.common.bus.LiveDataBus;

public class SecondActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
}
