package com.zty.archdemo.util;

import com.zty.archdemo.repository.CenterRepository;
import com.zty.archdemo.repository.KtRepository;
import com.zty.common.http.service.WanAPI;
import com.zty.common_ktx.http.service.KWanAPI;

public class InjectorRepositoryUtil {
    private static class  InjectorRepositoryUtilHolder{
        private static  InjectorRepositoryUtil  injectorRepositoryUtil=new InjectorRepositoryUtil();
    }

    public static InjectorRepositoryUtil getInstance(){
        return InjectorRepositoryUtilHolder.injectorRepositoryUtil;
    }

    private CenterRepository centerRepository;
    private KtRepository ktRepository;

    private InjectorRepositoryUtil(){

    }
    public CenterRepository getCenterRepository(){
        if (centerRepository==null){
            centerRepository = new CenterRepository(WanAPI.getInstance());
        }
        return centerRepository;
    }

    public CenterRepository getKtRepository(){
        if (ktRepository==null){
            ktRepository = new KtRepository();
        }
        return centerRepository;
    }
}
