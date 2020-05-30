package com.zty.common.base;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class BaseUseCase {
    //管理集合的订阅器
    CompositeDisposable mCompositeDisposable;

    protected void addDisposable(Disposable disposable) {
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.mCompositeDisposable.add(disposable);
    }

}
