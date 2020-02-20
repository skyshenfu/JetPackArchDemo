package com.zty.archdemo.ui.main.host;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zty.archdemo.ui.main.home.HomeFragment;
import com.zty.archdemo.ui.main.personal.PersonalFragment;
import com.zty.archdemo.ui.main.res.ResFragment;
import com.zty.common.base.BaseFragment;
import com.zty.common.util.BottomNavigationViewHelper;
import com.zty.oneforall.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HostFragment  extends BaseFragment {
    BottomNavigationView bottomNavigationView;
    ViewPager mViewPager;
    List<Fragment> tabList;
    HostFragmentAdapter hostFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_host,container,false);
        bottomNavigationView=view.findViewById(R.id.bottom_navigation);
        mViewPager=view.findViewById(R.id.viewpager);
        tabList= Arrays.asList(new HomeFragment(),new ResFragment(),new PersonalFragment());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuId=item.getItemId();
                switch (menuId){
                    case  R.id.item_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case  R.id.item_res:
                        mViewPager.setCurrentItem(1);
                        break;
                    case  R.id.item_my:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
        hostFragmentAdapter = new HostFragmentAdapter(tabList, getChildFragmentManager());
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        }
        mViewPager.setAdapter(hostFragmentAdapter);
        return view;
    }
}
