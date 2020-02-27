//package com.zty.archdemo.repository;
//
//import com.zty.common.bean.PublicAccountBean;
//import com.zty.common.bean.ResponseRawBean;
//import com.zty.common.http.service.WanAPI;
//
//import java.util.List;
//
//import io.reactivex.rxjava3.core.Observable;
//
//public class MainRepository {
//
//    private  WanAPI netWorkInstance;
//
//    public MainRepository(WanAPI instance) {
//        this.netWorkInstance=instance;
//    }
//
//    public Observable<ResponseRawBean<List<PublicAccountBean>>> getPublicAccount(){
//        return netWorkInstance.getPublicAccount();
//    }
//
//}
