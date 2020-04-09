package com.zty.archdemo.ui.navdemo.list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.zty.archdemo.R;
import com.zty.archdemo.databinding.FragmentListBinding;
import com.zty.archdemo.ui.navdemo.list.adapter.DemoItemAdapter;
import com.zty.common.base.BaseVMFragment;
import com.zty.common.bus.LiveDataBus;

import java.util.Arrays;
import java.util.Random;

public class ListFragment extends BaseVMFragment<ListViewModel> {

    DemoItemAdapter demoItemAdapter;
    ListFragmentClickProxy clickProxy =new ListFragmentClickProxy();
    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentListBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {
        ((FragmentListBinding)mBinding).setProxy(clickProxy);
        ((FragmentListBinding)mBinding).setNumber(String.valueOf(new Random().nextInt(999)));
    }

    @Override
    protected void afterViewCreated(View view, Bundle savedInstanceState) {
        super.afterViewCreated(view, savedInstanceState);
        if (demoItemAdapter==null){
            demoItemAdapter=new DemoItemAdapter();
        }
        ((FragmentListBinding)mBinding).recyclerView.setAdapter(demoItemAdapter);
        ((FragmentListBinding)mBinding).recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        demoItemAdapter.setDataList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30));

        demoItemAdapter.notifyDataSetChanged();
        LiveDataBus.get().with("ZTY").observerSticky(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.e("TAG", "onChanged: ");
            }
        },true);
    }
    public class ListFragmentClickProxy {
       public void clickToNext(){
           if (getView()!=null){
               Navigation.findNavController(getView()).navigate(R.id.action_fragment_list_to_fragment_next);

           }
        }
    }
}
