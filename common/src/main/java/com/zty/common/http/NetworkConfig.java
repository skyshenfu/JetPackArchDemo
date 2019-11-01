package com.zty.common.http;

public class NetworkConfig {
    //网络超时时间:读超时
    public static final int NET_READ_TIME_OUT=10000;
    //网络超时时间:写超时
    public static final int NET_WRITE_TIME_OUT=10000;
    //网络超时时间:连接超时
    public static final int NET_CONNECT_TIME_OUT=10000;

    //header的Holder，这里给Header提供一个默认的占位符，用于替换URL


    public static final String DOMAIN_HOLDER_KEY="domain_holder";
    public static final String DOMAIN_HOLDER_VALUE="defaultValue";
    public static final String DOMAIN_HOLDER_WHOLE=DOMAIN_HOLDER_KEY+":"+DOMAIN_HOLDER_VALUE;

    public static final String BASE_URL="https://wanandroid.com";

}
