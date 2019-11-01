package com.zty.common.http.function;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public class ErrorResponseFunc<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) throws Throwable {
        return Observable.error(throwable);
    }
}
