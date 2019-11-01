/**
  * Copyright 2019 bejson.com 
  */
package com.zty.common.bean;

/**
 * Auto-generated: 2019-10-30 11:22:27
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ResponseRawBean<T>{

    private T data;
    private int errorCode;
    private String errorMsg;

    public void setErrorCode(int errorCode) {
         this.errorCode = errorCode;
     }
     public int getErrorCode() {
         return errorCode;
     }

    public void setErrorMsg(String errorMsg) {
         this.errorMsg = errorMsg;
     }
     public String getErrorMsg() {
         return errorMsg;
     }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}