/**
 * FileName: MainViewModel
 * Author: zty
 * Date: 2019-10-26 12:00
 * Description: 用于测试的ViewModel
 */
package com.zty.archdemo.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.zty.archdemo.model.bean.UserBean;
import com.zty.archdemo.model.livemodel.MainLiveModel;
import com.zty.archdemo.repository.MainRepository;
import com.zty.archdemo.util.InjectorRepositoryUtil;
import com.zty.common.base.BaseCustomObserver;
import com.zty.common.base.BaseViewModel;
import com.zty.common.bean.PublicAccountBean;
import com.zty.common.http.CustomHttpUtil;
import java.util.List;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @ClassName: MainViewModel
 * @Description: java类作用描述
 * @Author: zty
 * @Date: 2019-10-26 12:00
 */
public class MainViewModel extends BaseViewModel {
    private MutableLiveData<MainLiveModel> uILiveData=new MutableLiveData<>();
    private MainRepository mainRepository;



    public MainViewModel() {
        this.mainRepository = InjectorRepositoryUtil.getInstance().getWan_Main_Repository();
    }


    public MutableLiveData<MainLiveModel> getUiLiveData() {
        return uILiveData;
    }
    private  boolean watchText(String userName,String passWord){
        return  true;
    }
    private  UserBean createNewState(){
        UserBean userBean=new UserBean();
        return userBean;
    }

    public void getPublicAccountInfo(){
        CustomHttpUtil.crateService(mainRepository.getPublicAccount(), new BaseCustomObserver<List<PublicAccountBean>>() {
            @Override
            protected void startRequest(Disposable d) {
                Log.e("TAG", "startRequest: "+Thread.currentThread());
                addDisposable(d);
            }

            @Override
            protected void successResponse(List<PublicAccountBean> publicAccountBeans) {
                Log.e("TAG", "successResponse: "+Thread.currentThread());
            }

        });

    }

}