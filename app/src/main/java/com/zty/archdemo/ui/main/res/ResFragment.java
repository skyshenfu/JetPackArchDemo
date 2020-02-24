package com.zty.archdemo.ui.main.res;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.zty.archdemo.ui.main.MainHostActivity;
import com.zty.common.base.BaseVMFragment;
import com.zty.oneforall.R;
import com.zty.oneforall.databinding.FragmentHomeBinding;
import com.zty.oneforall.databinding.FragmentResBinding;

public class ResFragment  extends BaseVMFragment<ResViewModel> {
    private ResFragmentClickProxy resFragmentClickProxy;
    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentResBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {
        ((FragmentResBinding)mBinding).setResViewModel((mViewModel));
        resFragmentClickProxy=new ResFragmentClickProxy();
        ((FragmentResBinding)mBinding).setClickProxy(resFragmentClickProxy);



    }

    public class ResFragmentClickProxy{
        public void  jumpToSecond(){
            ((MainHostActivity)getActivity()).getNavController().navigate(R.id.action_fragment_host_to_fragment_second);
        }
    }
}
