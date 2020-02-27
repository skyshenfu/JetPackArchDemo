package com.zty.common.http.interceptor;

import com.zty.common.http.NetworkConfig;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 转换BaseURL的拦截器
 */
public class ModifyBaseUrlInterceptor implements Interceptor {
    public Response intercept(Chain chain) throws IOException {
        //获取request
        Request request = chain.request();
        //从request中获取原有的HttpUrl实例oldHttpUrl
        HttpUrl oldHttpUrl = request.url();
        //获取request的创建者builder
        Request.Builder builder = request.newBuilder();
        //从request中获取headers，通过给定的键url_name
        List<String> headerValues = request.headers(NetworkConfig.DOMAIN_HOLDER_KEY);
        //
        if (headerValues != null && headerValues.size() > 0) {
            builder.removeHeader(NetworkConfig.DOMAIN_HOLDER_KEY);
            //匹配获得新的BaseUrl，通过domin值，判断这个是哪一个方法需要使用什么baseUrl
            String headerValue = headerValues.get(0);
            HttpUrl newBaseUrl;
            builder.addHeader("Connection","close");
            newBaseUrl = HttpUrl.parse(NetworkConfig.BASE_URL);

            //重建新的HttpUrl，修改需要修改的url部分
            HttpUrl newFullUrl = oldHttpUrl.newBuilder()
                                            .scheme(newBaseUrl.scheme())
                                            .host(newBaseUrl.host())
                                            .port(newBaseUrl.port())
                                            .build();
            return chain.proceed(builder.url(newFullUrl).build());
        }

        return chain.proceed(request);
    }
}
