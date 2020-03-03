package com.zty.archdemo.repository;

import androidx.lifecycle.MutableLiveData;

import com.zty.common.bean.PublicAccountBean;
import com.zty.common.bean.ResponseRawBean;
import com.zty.common.http.service.WanAPI;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class CenterRepository {
    private WanAPI netWorkInstance;
    //针对不同的服务进行缓存操作

    public CenterRepository(WanAPI instance) {
        this.netWorkInstance=instance;
    }

    public MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> getPublicAccount(){
        return netWorkInstance.getLiveDataPublicAccount();
    }

    public Observable<ResponseRawBean<List<PublicAccountBean>>> getRxPublicAccount(){
        return netWorkInstance.getRxPublicAccount();
    }
}
