package com.dotconnectafrica.shebnks_rest_api.service.impl;

import com.dotconnectafrica.shebnks_rest_api.Utility.Utility;
import com.dotconnectafrica.shebnks_rest_api.models.MpesaLogsModel;
import com.dotconnectafrica.shebnks_rest_api.repository.MpesaLogsRepository;
import com.dotconnectafrica.shebnks_rest_api.service.MpesaLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MpesaLogsServiceImpl implements MpesaLogsService {


    @Autowired
    private MpesaLogsRepository mpesaLogsRepository;

   /* @Autowired
    private SmsLogsService smsLogsService;
*/
    @Autowired
    private Utility appUtils;

    @Override
    public MpesaLogsModel addLog(MpesaLogsModel logsService) {

       // AppUtils appUtils = new AppUtils(smsLogsService);

        try {

            return mpesaLogsRepository.save(logsService);

        } catch (Exception e) {
            return null;
        }
    }
}
