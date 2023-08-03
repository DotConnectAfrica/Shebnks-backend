package com.dotconnectafrica.shebnks_rest_api.service;


import com.dotconnectafrica.shebnks_rest_api.models.PaymentsModel;
import com.dotconnectafrica.shebnks_rest_api.models.TransactionsModel;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;

import java.math.BigInteger;

public interface PaymentsService {



    ApiResponse B2CPaymentResponse (String jsonAsString);
    ApiResponse B2CPaymentResponseTimeout (String jsonAsString);

    ApiResponse saveTransactionB2C(TransactionsModel transactionsModel, String remarks, BigInteger loanId);

    ApiResponse saveTransactionStkPush(TransactionsModel transactionsModel, BigInteger loanId);

    ApiResponse mpesaStkPushCallback (String jsonAsString);

    ApiResponse validatePayment(String shortCode, String transactionID, String paymentPhone);

    ApiResponse MpesaStkPushTransactionQueryResult(String jsonAsString);

    ApiResponse reverseMpesaPayment(String user, String transID, float amount, String shortCode);

    ApiResponse ReversalResponse(String jsonAsString);

}