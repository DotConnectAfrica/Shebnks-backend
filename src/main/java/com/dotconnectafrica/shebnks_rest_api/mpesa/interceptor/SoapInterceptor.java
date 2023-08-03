package com.dotconnectafrica.shebnks_rest_api.mpesa.interceptor;

import lombok.NoArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@NoArgsConstructor
public class SoapInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Content-Type", "text/xml")
                .build();
        return chain.proceed(request);
    }
}
