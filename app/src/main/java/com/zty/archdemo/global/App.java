/**
 * FileName: App
 * Author: zty
 * Date: 2020/3/13 2:11 PM
 * Description:
 */
package com.zty.archdemo.global;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.blankj.utilcode.util.Utils;

/**
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: zty
 * @Date: 2020/3/13 2:11 PM
 */
public class App  extends Application  {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}