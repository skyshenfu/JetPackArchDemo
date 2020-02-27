package com.zty.archdemo.ui.main.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zty.archdemo.repository.CenterRepository;
import com.zty.archdemo.util.InjectorRepositoryUtil;
import com.zty.common.base.BaseViewModel;
import com.zty.common.bean.PublicAccountBean;
import com.zty.common.bean.ResponseRawBean;

import java.util.List;

public class HomeViewModel extends BaseViewModel {
   private CenterRepository centerRepository;

    public HomeViewModel() {
        centerRepository= InjectorRepositoryUtil.getInstance().getCenterRepository();
    }
    public MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> getAccount(){
        MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> liveData=centerRepository.getPublicAccount();
        return liveData;
    }

}
