/**
 * FileName: BaseViewModel
 * Author: zty
 * Date: 2019-10-25 11:03
 * Description: 所有ViewModel的父类
 */
package com.zty.common.base;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @ClassName: BaseViewModel
 * @Description: java类作用描述
 * @Author: zty
 * @Date: 2019-10-25 11:03
 */
public class BaseViewModel extends ViewModel implements LifecycleObserver {
    //管理集合的订阅器
    CompositeDisposable mCompositeDisposable;

    protected <T> void execute(Observable<T> observable, Observer<T> observer) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    protected void addDisposable(Disposable disposable) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (this.mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            this.mCompositeDisposable.clear();
        }
    }
}