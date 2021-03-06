package com.zty.archdemo.ui.navdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.zty.archdemo.R;
import com.zty.common.base.BaseActivity;

public class NavMainActivity extends BaseActivity {

    NavController navController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.demo_host_fragment);
        navController= NavHostFragment.findNavController(fragment);
    }
}
