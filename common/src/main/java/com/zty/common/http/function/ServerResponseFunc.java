package com.zty.common.http.function;

import com.zty.common.bean.NetBusinessErrorBean;
import com.zty.common.bean.ResponseRawBean;
import com.zty.common.http.api.NetBusinessExceptionAPI;
import com.zty.common.http.exception.NetBusinessException;

import io.reactivex.rxjava3.functions.Function;

public class ServerResponseFunc<T> implements Function<ResponseRawBean<T>,T> {
    @Override
    public T apply(ResponseRawBean<T> tResponseRawBean) throws Throwable {
        if (tResponseRawBean!=null){
            if (tResponseRawBean.getErrorCode()==0){
                if (tResponseRawBean.getData()==null){
                    throw  new NetBusinessException(new NetBusinessErrorBean(NetBusinessExceptionAPI.NO_DATA_ERROR,tResponseRawBean.getErrorMsg()));

                }else {
                    return  tResponseRawBean.getData();
                }

            }else {
                throw  new NetBusinessException(new NetBusinessErrorBean(tResponseRawBean.getErrorCode(),tResponseRawBean.getErrorMsg()));

            }
        }else {
            throw  new NetBusinessException(new NetBusinessErrorBean(NetBusinessExceptionAPI.NO_RAW_DATA_ERROR,tResponseRawBean.getErrorMsg()));

        }

    }
}
