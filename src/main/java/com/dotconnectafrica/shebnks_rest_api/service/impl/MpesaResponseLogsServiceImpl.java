package com.dotconnectafrica.shebnks_rest_api.service.impl;

import com.dotconnectafrica.shebnks_rest_api.Utility.Utility;
import com.dotconnectafrica.shebnks_rest_api.models.MpesaResponseLogsModel;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import com.dotconnectafrica.shebnks_rest_api.repository.MpesaResponseLogsRepository;
import com.dotconnectafrica.shebnks_rest_api.service.MpesaResponseLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MpesaResponseLogsServiceImpl implements MpesaResponseLogsService {


    @Autowired
    private MpesaResponseLogsRepository mpesaResponseLogsRepository;

    @Override
    public ApiResponse saveMpesaResponseLog(MpesaResponseLogsModel mpesaResponseLogsModel) {


        try {
            mpesaResponseLogsRepository.save(mpesaResponseLogsModel);
            return Utility.Success();

        } catch (Exception e) {
            Utility.LogResult(mpesaResponseLogsModel.getPhone(), e.getLocalizedMessage());
            return Utility.Error();
        }
    }
}
