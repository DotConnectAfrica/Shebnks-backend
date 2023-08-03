/*
 * MIT License
 * Copyright (c) 2020 corneliouz bett
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction,including without limitation
 * the rights to use, copy,modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.dotconnectafrica.shebnks_rest_api.mpesa.base;

import com.dotconnectafrica.shebnks_rest_api.mpesa.Mpesa;
import com.dotconnectafrica.shebnks_rest_api.mpesa.common.Log;
import com.dotconnectafrica.shebnks_rest_api.mpesa.common.MpesaConstants;
import com.dotconnectafrica.shebnks_rest_api.mpesa.interceptor.AuthenticationInterceptor;
import com.dotconnectafrica.shebnks_rest_api.mpesa.interceptor.TokenInterceptor;
import com.dotconnectafrica.shebnks_rest_api.mpesa.rest.params.AccessToken;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;


public class RequestClient implements Mpesa {

    private Boolean isLive = false;

    private Log log = new Log(RequestClient.class);

    private Retrofit restClient;

    /**
     * Public constructor, for authentication with access token
     * <p>
     * Use this constructor when you want to access Mpesa Daraja API
     * using access token
     *
     * <pre>
     *     final Mpesa myMpesa = new JengaRequestClient(
     *     "{--your access token here ---}"
     *     );
     * </pre>
     *
     * @param authToken authentication token
     */
    public RequestClient(AccessToken authToken) {
        this.restClient = this.getRestClient(authToken.getAccessToken());
    }

    /**
     * Public constructor, for HTTP Basic authentication
     * <p>
     * Use this constructor you want to access Mpesa Daraja API using
     * consumerKey and consumerSecret For instance,
     *
     * <pre>
     *     final Mpesa myMpesa = new JengaRequestClient(
     *     "89jMLEpzHAuW5bF28zBz7qoF332th2DB", "XKHJii8egyVXg7De"
     *     );
     * </pre>
     *
     * @param consumerKey    consumerKey
     * @param consumerSecret consumerSecret
     */
    public RequestClient(String consumerKey, String consumerSecret) {
        new RequestClient(consumerKey, consumerSecret, false);
    }

    /**
     * @param consumerKey    client consumer key
     * @param consumerSecret client consumer secret
     * @param isLive         true means the app has been released to production
     */
    public RequestClient(String consumerKey, String consumerSecret, Boolean isLive) {
        this.isLive = isLive;
        this.restClient = new Retrofit.Builder()
                .baseUrl(getBaseUrl(isLive))
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.configureClient().newBuilder().addInterceptor(
                        new TokenInterceptor(consumerKey, consumerSecret)).build())
                .build();
    }

    public RequestClient() {
        this.restClient = new Retrofit.Builder()
                .baseUrl("http://subaggregator.pdslkenya.com:8084/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private String getBaseUrl(Boolean isLive) {
        return isLive ? MpesaConstants.PRODUCTION_DOMAIN : MpesaConstants.SANDBOX_DOMAIN;
    }

    /**
     * Configures Http Client
     *
     * @return OkHttpClient
     */
    private OkHttpClient configureClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(MpesaConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(MpesaConstants.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(MpesaConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * Gets RestClient (pre-configured retrofit Instance)
     *
     * @param accessToken authorization token
     * @return Retrofit rest client pre-configured
     */
    private Retrofit getRestClient(@NonNull String accessToken) {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl(isLive))
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.configureClient().newBuilder().addInterceptor(
                        new AuthenticationInterceptor(accessToken)).build())
                .build();
    }



    @Override
    public RequestInterface authenticate() {
        return this.restClient.create(RequestInterface.class);
    }


    @Override
    public RequestInterface stkPush(@NonNull String accessToken) {
        return this.getRestClient(accessToken).create(RequestInterface.class);
    }

    @Override
    public RequestInterface queryInstantPayment(@NonNull String accessToken) {
        return this.getRestClient(accessToken).create(RequestInterface.class);
    }

    @Override
    public RequestInterface reversal(@NonNull String accessToken) {
        return this.getRestClient(accessToken).create(RequestInterface.class);

    }




}
