package com.zty.archdemo.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.blankj.utilcode.util.AppUtils;
import com.zty.common.base.BaseActivity;
import com.zty.common.util.NavGraphBuilder;
import com.zty.oneforall.R;

public class MainHostActivity  extends BaseActivity {
    private NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_host);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        navController = NavHostFragment.findNavController(fragment);
        NavGraphBuilder.build(this, navController, fragment.getId());
    }

    public NavController getNavController() {
        return navController;
    }
}
