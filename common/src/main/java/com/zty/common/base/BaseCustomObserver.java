package com.zty.common.base;

import com.zty.common.http.exception.NetBusinessException;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class BaseCustomObserver<T> implements Observer<T> {
    protected void finalCallBack(){

    }
    protected abstract  void startRequest(Disposable d);
    protected abstract  void successResponse(T t);
    protected   void errorResponse(Throwable e){

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof NetBusinessException){

        }else{

        }
        errorResponse(e);
        finalCallBack();
    }

    @Override
    public void onNext(T t) {
        successResponse(t);
    }

    @Override
    public void onSubscribe(Disposable d) {
        startRequest(d);
    }

    @Override
    public void onComplete() {
        finalCallBack();

    }
}
