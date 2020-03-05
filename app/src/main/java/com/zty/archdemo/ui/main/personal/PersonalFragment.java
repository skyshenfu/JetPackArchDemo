package com.zty.archdemo.ui.main.personal;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.zty.archdemo.databinding.FragmentPersonalBinding;
import com.zty.archdemo.ui.main.MainHostActivity;
import com.zty.common.base.BaseVMFragment;

public class PersonalFragment extends BaseVMFragment<PersonalViewModel> {
    private  PersonalFragmentProxy personalFragmentProxy;
    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentPersonalBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {
        ((FragmentPersonalBinding)mBinding).setHomeViewModel((mViewModel));
        personalFragmentProxy=new PersonalFragmentProxy();
        ((FragmentPersonalBinding)mBinding).setClickProxy(personalFragmentProxy);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public class PersonalFragmentProxy{
        public void deeplinkJump(){
            ((MainHostActivity)getActivity()).getMyNavController().navigate(Uri.parse("http://app/innerFragment"));
        }

        public void popUp(){
            ((MainHostActivity)getActivity()).getMyNavController().popBackStack();
        }
    }
}
