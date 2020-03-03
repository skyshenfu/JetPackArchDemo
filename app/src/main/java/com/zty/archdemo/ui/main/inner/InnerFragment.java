package com.zty.archdemo.ui.main.inner;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.zty.archdemo.R;
import com.zty.archdemo.databinding.FragmentInnerBinding;
import com.zty.archdemo.ui.main.MainHostActivity;
import com.zty.common.base.BaseVMFragment;

public class InnerFragment extends BaseVMFragment<InnerViewModel>{
    private InnerFragmentProxy innerFragmentProxy;

    @Override
    protected ViewDataBinding generateDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentInnerBinding.inflate(inflater,container,false);
    }

    @Override
    protected void setDataForViewModels() {
        innerFragmentProxy=new InnerFragmentProxy();
        ((FragmentInnerBinding)mBinding).setClickProxy(innerFragmentProxy);
        ((FragmentInnerBinding) mBinding).innerTextView.setText(this.toString());

    }


    public class InnerFragmentProxy{
        public void deeplinkJump(){
            ((MainHostActivity)getActivity()).getNavController().navigate(Uri.parse("http://app/innerFragment"));
        }

        public void popUp(){
            ((MainHostActivity)getActivity()).getNavController().popBackStack();
        }
        public void popUpAll(){
            ((MainHostActivity)getActivity()).getNavController().popBackStack(R.id.host_fragment,false);
        }
    }

}
