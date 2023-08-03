package com.dotconnectafrica.shebnks_rest_api.service;


import com.dotconnectafrica.shebnks_rest_api.models.MpesaResponseLogsModel;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;

public interface MpesaResponseLogsService {


    ApiResponse saveMpesaResponseLog(MpesaResponseLogsModel mpesaResponseLogsModel);


}