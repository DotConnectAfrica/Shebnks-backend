package com.dotconnectafrica.shebnks_rest_api.service;


import com.dotconnectafrica.shebnks_rest_api.models.TransactionsModel;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;

public interface TransactionsService {



/*
    ApiResponse saveTransaction(TransactionsModel transactionsModel);
*/


    ApiResponse updateTransaction(TransactionsModel model);

    ApiResponse updateTransactionFailed(String user, String ref, String description);

        //ApiResponse savePayment (String jsonAsString);

}