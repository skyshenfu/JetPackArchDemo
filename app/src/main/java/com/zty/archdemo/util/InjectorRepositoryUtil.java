package com.zty.archdemo.util;

import com.zty.archdemo.repository.MainRepository;
import com.zty.common.http.service.WanAPI;
import com.zty.common.http.service.WanService;

public class InjectorRepositoryUtil {
    private static class  InjectorRepositoryUtilHolder{
        private static  InjectorRepositoryUtil  injectorRepositoryUtil=new InjectorRepositoryUtil();
    }

    public static InjectorRepositoryUtil getInstance(){
        return InjectorRepositoryUtilHolder.injectorRepositoryUtil;
    }

    private InjectorRepositoryUtil(){

    }
    public   MainRepository getWan_Main_Repository(){
        return  new MainRepository(WanAPI.getInstance());
    }
}
