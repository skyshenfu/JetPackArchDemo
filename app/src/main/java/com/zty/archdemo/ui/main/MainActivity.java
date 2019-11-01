/**
 * FileName: MainActivity
 * Author: zty
 * Date: 2019-10-25 11:00
 * Description:
 */
package com.zty.archdemo.ui.main;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.zty.archdemo.model.livemodel.MainLiveModel;
import com.zty.common.base.BaseVMActivity;
import com.zty.oneforall.R;
import com.zty.oneforall.databinding.ActivityMainBinding;


/**
 * @ClassName: MainActivity
 * @Description: java类作用描述
 * @Author: zty
 * @Date: 2019-10-25 11:00
 */
public class MainActivity extends BaseVMActivity<MainViewModel> {
    private ActivityMainBinding mBinding;
    private Button button;

    @Override
    protected void initDataBinding() {
        mBinding=DataBindingUtil.setContentView(this, R.layout.activity_main);
        button=findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.getPublicAccountInfo();
            }
        });
        mBinding.setViewModel(mViewModel);
        mViewModel.getUiLiveData().observe(this, new Observer<MainLiveModel>() {
            @Override
            public void onChanged(MainLiveModel mainLiveModel) {
                if (mainLiveModel.isEnableLoginButton()){
                    button.setEnabled(true);
                }else {
                    button.setEnabled(false);
                }
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainLiveModel  mainLiveModel =new MainLiveModel();
                mainLiveModel.setEnableLoginButton(true);

                mViewModel.getUiLiveData().setValue(mainLiveModel);
                Log.e("TAG", "run: ");
            }
        },500);
    }


}