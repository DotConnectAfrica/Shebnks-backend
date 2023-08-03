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

import com.dotconnectafrica.shebnks_rest_api.mpesa.requests.*;
import com.dotconnectafrica.shebnks_rest_api.mpesa.responses.*;
import com.dotconnectafrica.shebnks_rest_api.mpesa.rest.params.AccessToken;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * .For Lipa na Mpesa using stk push
 *
 * @author corneliouzbett
 * @since 1.0.0
 */

public interface RequestInterface {

    /**
     * Gets access token or rather token bearer
     *
     * @return {@link Call} Access token
     */
    @GET("/oauth/v1/generate?grant_type=client_credentials")
    Call<AccessToken> getAccessToken();

    /**
     * Use this API to check the status of a Lipa Na M-Pesa Stk Payment
     *
     * @param instantPaymentQueryRequest Stk payment status
     * @return Mpesa response
     */
    @POST("/mpesa/stkpushquery/v1/query")
    Call<InstantPaymentQueryResponse> queryInstantPayment(@Body InstantPaymentQueryRequest instantPaymentQueryRequest);

    /**
     * Use this API to check the status of a Lipa Na M-Pesa  Transaction
     *
     * @param transactionQueryRequest Online payment status
     * @return Mpesa response
     */
    @POST("/mpesa/transactionstatus/v1/query")
    Call<BusinessTransactionQueryResponse> queryBusinessTransaction(@Body TransactionQueryRequest transactionQueryRequest);

    /**
     * @return Mpesa response
     */

    @POST("/mpesa/stkpush/v1/processrequest")
    Call<InstantPaymentRequestResponse> initiateOnlinePayment(@Body InstantPaymentRequest instantPaymentRequest);

    @POST("/mpesa/reversal/v1/request")
    Call<BusinessTransactionReversalResponse> initiateReversal(@Body TransactionReversalRequest reversalRequest);

    @POST("/mpesa/b2c/v1/paymentrequest")
    Call<BusinessPaymentRequestResponse> initiateB2C(@Body PaymentRequest reversalRequest);

    @POST("/pdslvending/Requests?wsdl")
    Call<ResponseBody> vend(@Body RequestBody requestBody);


}
