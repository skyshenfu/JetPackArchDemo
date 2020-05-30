package com.zty.common.bean;

import com.zty.common.base.BaseActivity;

import java.io.Serializable;

public class SwitchActivityBean implements Serializable {
    private  Class<? extends BaseActivity> activityClazz;
    private boolean  activityStatus=false;

    public SwitchActivityBean() {
    }

    public SwitchActivityBean( Class<? extends BaseActivity> activityClazz,boolean activityStatus) {
        this.activityStatus = activityStatus;
        this.activityClazz = activityClazz;
    }

    public boolean isActivityStatus() {
        return activityStatus;
    }

    public SwitchActivityBean(boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public void setActivityStatus(boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Class<? extends BaseActivity> getActivityClazz() {
        return activityClazz;
    }

    public void setActivityClazz(Class<? extends BaseActivity> activityClazz) {
        this.activityClazz = activityClazz;
    }
}
