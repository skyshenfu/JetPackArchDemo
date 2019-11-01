package com.zty.common.http.service;

import com.zty.common.bean.PublicAccountBean;
import com.zty.common.bean.ResponseRawBean;
import com.zty.common.http.HttpFactory;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class WanAPI {
    private WanService wanService;
    private static  class  WanAPIHolder{
        private  static  WanAPI wanAPI=new WanAPI();
    }
    public static WanAPI getInstance(){
      return   WanAPIHolder.wanAPI;
    }

    private WanAPI(){
        wanService= HttpFactory.getInstance().crateService(WanService.class);
    }

    public Observable<ResponseRawBean<List<PublicAccountBean>>> getPublicAccount(){
        return wanService.getPublicAccount();
    }


}
