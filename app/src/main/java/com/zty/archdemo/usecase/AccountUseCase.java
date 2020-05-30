package com.zty.archdemo.usecase;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.zty.archdemo.repository.CenterRepository;
import com.zty.archdemo.util.InjectorRepositoryUtil;
import com.zty.common.base.BaseCustomObserver;
import com.zty.common.base.BaseUseCase;
import com.zty.common.bean.PublicAccountBean;
import com.zty.common.bean.ResponseRawBean;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountUseCase extends BaseUseCase {
    private MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> mLiveData;
    private Call call;


    public AccountUseCase(){
        mLiveData=new MutableLiveData<>();

    }

    public MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> getmLiveData() {
        return mLiveData;
    }

    public void requestData(){
        call=InjectorRepositoryUtil.getInstance().getCenterRepository().getCallPublicAccount();

        InjectorRepositoryUtil.getInstance().getCenterRepository().getCallPublicAccount().enqueue(new Callback<ResponseRawBean<List<PublicAccountBean>>>() {
            @Override
            public void onResponse(Call<ResponseRawBean<List<PublicAccountBean>>> call, Response<ResponseRawBean<List<PublicAccountBean>>> response) {
                mLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseRawBean<List<PublicAccountBean>>> call, Throwable t) {
                mLiveData.postValue(new ResponseRawBean<>(t));
            }
        });
    }

    public void  cancelRequest(){
        if (call!=null){
            if (!call.isCanceled()){
                Log.e("TAG", "请求取消");
                call.cancel();
            }
        }
    }



}
