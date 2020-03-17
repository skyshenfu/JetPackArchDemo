/**
 * FileName: SharedViewModel
 * Author: zty
 * Date: 2020/3/13 2:29 PM
 * Description: 全局共享作用域
 */
package com.zty.common.global;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @ClassName: SharedViewModel
 * @Description: java类作用描述
 * @Author: zty
 * @Date: 2020/3/13 2:29 PM
 */
public class SharedViewModel extends ViewModel {

    MutableLiveData<Boolean> showLoadingDialog=new MutableLiveData<>(false);
}