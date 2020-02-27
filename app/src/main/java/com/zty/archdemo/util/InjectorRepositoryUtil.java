package com.zty.archdemo.util;

import com.zty.archdemo.repository.CenterRepository;
import com.zty.common.http.service.WanAPI;

public class InjectorRepositoryUtil {
    private static class  InjectorRepositoryUtilHolder{
        private static  InjectorRepositoryUtil  injectorRepositoryUtil=new InjectorRepositoryUtil();
    }

    public static InjectorRepositoryUtil getInstance(){
        return InjectorRepositoryUtilHolder.injectorRepositoryUtil;
    }

    private CenterRepository centerRepository;

    private InjectorRepositoryUtil(){

    }
    public CenterRepository getCenterRepository(){
        if (centerRepository==null){
            centerRepository = new CenterRepository(WanAPI.getInstance());
        }
        return centerRepository;
    }
}
