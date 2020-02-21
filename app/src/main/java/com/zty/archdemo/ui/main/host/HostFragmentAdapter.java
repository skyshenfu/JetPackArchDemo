package com.zty.archdemo.ui.main.host;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zty.archdemo.ui.main.home.HomeFragment;
import com.zty.archdemo.ui.main.personal.PersonalFragment;
import com.zty.archdemo.ui.main.res.ResFragment;
import com.zty.common.base.BaseFragment;

import java.util.List;
 

public final class HostFragmentAdapter extends FragmentStateAdapter {

    public HostFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0){
            return new HomeFragment();

        }else if (position==1){
            return new ResFragment();

        }else if (position==2){
            return new PersonalFragment();

        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}