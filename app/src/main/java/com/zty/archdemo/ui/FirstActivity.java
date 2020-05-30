package com.zty.archdemo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tencent.mmkv.MMKV;
import com.zty.archdemo.R;
import com.zty.common.base.BaseActivity;
import com.zty.common.bean.SwitchActivityBean;
import com.zty.common.bus.LiveDataBus;

public class FirstActivity extends BaseActivity {
    ListView listView;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String name=FirstActivity.this.getClass().getName();
                LiveDataBus.get().with(name).postValue(new SwitchActivityBean(SecondActivity.class,true));
            }
        },5000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String name=FirstActivity.this.getClass().getName();
                LiveDataBus.get().with(name).postValue(new SwitchActivityBean(SecondActivity.class,false));
            }
        },10000);
    }
}
