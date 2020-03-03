package com.zty.archdemo.ui.main.host;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.zty.archdemo.R;
import com.zty.common.base.BaseFragment;


public class HostFragment  extends BaseFragment {
    BottomNavigationView bottomNavigationView;
    ViewPager2 mViewPager;
    HostFragmentAdapter hostFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_host,container,false);
        bottomNavigationView=view.findViewById(R.id.bottom_navigation);
        mViewPager=view.findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);

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
        hostFragmentAdapter = new HostFragmentAdapter(getChildFragmentManager(),getLifecycle());
        mViewPager.setAdapter(hostFragmentAdapter);

        //取消拉边效果
        try {
            mViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        } catch (Exception e) {

        }
        return view;
    }
}
