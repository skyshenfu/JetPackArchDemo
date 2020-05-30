/**
 * FileName: App
 * Author: zty
 * Date: 2020/3/13 2:11 PM
 * Description:
 */
package com.zty.archdemo.global;


import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.zty.common.base.BaseApplication;

/**
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: zty
 * @Date: 2020/3/13 2:11 PM
 */
public class App  extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        String rootDir = MMKV.initialize(this);
        Utils.init(this);
    }
}