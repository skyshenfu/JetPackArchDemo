/**
 * FileName: MainLiveModel
 * Author: zty
 * Date: 2019-10-26 13:45
 * Description:
 */
package com.zty.archdemo.model.livemodel;

import com.zty.common.base.BaseModel;
import com.zty.archdemo.model.bean.UserBean;

/**
 * @ClassName: MainLiveModel
 * @Description: 组合包装MainActivity的数据
 * @Author: zty
 * @Date: 2019-10-26 13:45
 */
public class MainLiveModel implements BaseModel {
    private  boolean showProgress;
    private String  showError;
    private UserBean showSuccess;
    private boolean enableLoginButton;
    private boolean needLogin;

    public boolean isShowProgress() {
        return showProgress;
    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    public String getShowError() {
        return showError;
    }

    public void setShowError(String showError) {
        this.showError = showError;
    }

    public UserBean getShowSuccess() {
        return showSuccess;
    }

    public void setShowSuccess(UserBean showSuccess) {
        this.showSuccess = showSuccess;
    }

    public boolean isEnableLoginButton() {
        return enableLoginButton;
    }

    public void setEnableLoginButton(boolean enableLoginButton) {
        this.enableLoginButton = enableLoginButton;
    }

    public boolean isNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(boolean needLogin) {
        this.needLogin = needLogin;
    }
}