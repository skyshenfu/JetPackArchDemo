package com.zty.archdemo.ui.main.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.zty.archdemo.repository.CenterRepository;
import com.zty.archdemo.util.InjectorRepositoryUtil;
import com.zty.common.base.BaseCustomObserver;
import com.zty.common.base.BaseViewModel;
import com.zty.common.bean.PublicAccountBean;
import com.zty.common.bean.ResponseRawBean;
import com.zty.common.http.CustomHttpUtil;

import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

public class HomeViewModel extends BaseViewModel {
    private CenterRepository centerRepository;

    public HomeViewModel() {
        centerRepository = InjectorRepositoryUtil.getInstance().getCenterRepository();
    }

    public MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> getAccount() {
        MutableLiveData<ResponseRawBean<List<PublicAccountBean>>> liveData = centerRepository.getPublicAccount();
        return liveData;
    }

    public void getRxPublicAccountInfo() {
        CustomHttpUtil.crateService(centerRepository.getRxPublicAccount(), new BaseCustomObserver<List<PublicAccountBean>>() {
            @Override
            protected void startRequest(Disposable d) {
                Log.e("TAG", "startRequest: " + Thread.currentThread());
                addDisposable(d);
            }

            @Override
            protected void successResponse(List<PublicAccountBean> publicAccountBeans) {
                Log.e("TAG", "successResponse: " + Thread.currentThread());
            }

                    @Override
                    protected void errorResponse(Throwable e) {
                        super.errorResponse(e);
                    }
                }

        );

    }
}
