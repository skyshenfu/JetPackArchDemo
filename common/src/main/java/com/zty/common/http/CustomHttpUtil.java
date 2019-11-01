package com.zty.common.http;

import com.zty.common.base.BaseCustomObserver;
import com.zty.common.bean.PublicAccountBean;
import com.zty.common.bean.ResponseRawBean;
import com.zty.common.http.function.ServerResponseFunc;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CustomHttpUtil {
    public static <T> void crateService(Observable<ResponseRawBean<T>> subscriber, BaseCustomObserver<T> observer) {

        subscriber.observeOn(AndroidSchedulers.mainThread())
                  .subscribeOn(Schedulers.io())
                  .map(new ServerResponseFunc<T>()).
                  subscribe(observer);
    }

}
