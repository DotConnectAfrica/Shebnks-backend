package com.dotconnectafrica.shebnks_rest_api.service.impl;

import com.dotconnectafrica.shebnks_rest_api.Utility.Utility;
import com.dotconnectafrica.shebnks_rest_api.contants.AppConstants;
import com.dotconnectafrica.shebnks_rest_api.exception.ResourceNotFoundException;
import com.dotconnectafrica.shebnks_rest_api.models.MpesaResponseLogsModel;
import com.dotconnectafrica.shebnks_rest_api.models.TransactionsModel;
import com.dotconnectafrica.shebnks_rest_api.models.UserModel;
import com.dotconnectafrica.shebnks_rest_api.models.types.*;
import com.dotconnectafrica.shebnks_rest_api.mpesa.Mpesa;
import com.dotconnectafrica.shebnks_rest_api.mpesa.base.RequestClient;
import com.dotconnectafrica.shebnks_rest_api.mpesa.enums.CommandID;
import com.dotconnectafrica.shebnks_rest_api.mpesa.requests.InstantPaymentQueryRequest;
import com.dotconnectafrica.shebnks_rest_api.mpesa.requests.InstantPaymentRequest;
import com.dotconnectafrica.shebnks_rest_api.mpesa.responses.InstantPaymentQueryResponse;
import com.dotconnectafrica.shebnks_rest_api.mpesa.responses.InstantPaymentRequestResponse;
import com.dotconnectafrica.shebnks_rest_api.mpesa.rest.params.AccessToken;
import com.dotconnectafrica.shebnks_rest_api.mpesa.rest.params.AuthorizationCache;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import com.dotconnectafrica.shebnks_rest_api.repository.TransactionsRepository;
import com.dotconnectafrica.shebnks_rest_api.repository.UserRepository;
import com.dotconnectafrica.shebnks_rest_api.service.MpesaResponseLogsService;
import com.dotconnectafrica.shebnks_rest_api.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.dotconnectafrica.shebnks_rest_api.Utility.GenerationUtils.generatePassword;
import static com.dotconnectafrica.shebnks_rest_api.Utility.GenerationUtils.generateTimestamp;
import static com.dotconnectafrica.shebnks_rest_api.Utility.Preconditions.checkEmptyString;
import static com.dotconnectafrica.shebnks_rest_api.Utility.Preconditions.checkNotNull;
import static com.dotconnectafrica.shebnks_rest_api.Utility.Utility.LogResult;
import static com.dotconnectafrica.shebnks_rest_api.Utility.Utility.checkInstantPayPreconditions;

@RequiredArgsConstructor
@Service
public class TransactionsServiceImpl implements TransactionsService {


    @Autowired
    private TransactionsRepository transactionsRepository;


    @Autowired
    private UserRepository userRepository;

/*    @Autowired
    private BillPaymentPhoneService billPaymentPhoneService;*/

    @Autowired
    @Lazy
    private MpesaResponseLogsService mpesaResponseLogsService;

    @Autowired
    @Lazy
    private Utility appUtils;




/*
    private void stkPush(String accessToken, Mpesa mpesa, TransactionsModel transactionsModel, String ref) {

        //Sell Airtime, Tokens, Bills, Send Money
        String payment_phone = Utility.sanitizePhone(transactionsModel.getPaymentAccountNumber().trim());



        if (MPESA_WAHI_PAY_7789023 != null && MPESA_PAYBILL_PASSWORD_WAHI_PAY != null) {
            checkInstantPayPreconditions(LipaNaMpesaShortCode.of(MPESA_WAHI_PAY_7789023), LipaNaMpesaPasskey.of(MPESA_PAYBILL_PASSWORD_WAHI_PAY));
        } else {
            updateTransactionFailed(transactionsModel.getUser(), ref, "Invalid Mpesa username & password");
        }

        checkNotNull(MPESA_CALLBACK_URL_WAHI_PAY, "LipaNaMpesa callback URL missing");
        checkEmptyString(MPESA_CALLBACK_URL_WAHI_PAY, "LipaNaMpesa callback URL missing");
        checkNotNull(transactionsModel.getAccountNumber(), "Account reference is missing");
        checkNotNull(transactionsModel.getTransactionDesc(), "Description is missing.");

        String timestamp = generateTimestamp();
        String shortCode = LipaNaMpesaShortCode.of(MPESA_WAHI_PAY_7789023).getValue();
        String password = generatePassword(LipaNaMpesaShortCode.of(MPESA_WAHI_PAY_7789023), LipaNaMpesaPasskey.of(MPESA_PAYBILL_PASSWORD_WAHI_PAY), timestamp);


        InstantPaymentRequest instantPaymentRequest = InstantPaymentRequest.builder()
                .accountReference(AccountReference.of(transactionsModel.getAccountNumber()).getValue())
                .businessShortCode(shortCode)
                .callbackUrl(MPESA_CALLBACK_URL_WAHI_PAY)
                .amount(String.valueOf(TransactionAmount.of(new BigDecimal(transactionsModel.getAmount())).getValue()))
                .customerPhoneNumber(payment_phone)
                .initiatorShortCode(MPESA_PARTYB_WAHI_PAY)
                .phoneNumber(payment_phone)
                .password(password)
                .timestamp(timestamp)
                .transactionType(CommandID.CUSTOMER_BUY_GOODS_ONLINE.getCommandId())
                .transactionDescription(Description.of(transactionsModel.getTransactionDesc()).getValue())
                .build();

        mpesa.stkPush(accessToken).initiateOnlinePayment(instantPaymentRequest).enqueue(new Callback<InstantPaymentRequestResponse>() {
            @Override
            public void onResponse(Call<InstantPaymentRequestResponse> call, Response<InstantPaymentRequestResponse> response) {
                if (response.isSuccessful()) {
                    appUtils.LogResult(transactionsModel.getUser(), response.body().toString());

                    if (response.body().getResponseCode() == 0) {
                        if (userRepository.existsByPhone(transactionsModel.getUser())) {
                            UserModel user = userRepository.findByPhone(transactionsModel.getUser()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.TODO, AppConstants.ID, transactionsModel.getUser()));
                            user.setPhone(transactionsModel.getUser());
                            user.setFcm_token(transactionsModel.getRegId());

                            try {

                                userRepository.save(user);

                            } catch (Exception e) {
                                appUtils.LogResult(user.getPhone(), e.getLocalizedMessage());
                            }
                            BillPaymentModel billPaymentModel = new BillPaymentModel();
                            billPaymentModel.setUser(transactionsModel.getUser());
                            billPaymentModel.setPaymentPhone(payment_phone);
                            billPaymentModel.setAccountNumber(transactionsModel.getAccountNumber());
                            billPaymentModel.setAccountName(transactionsModel.getAccountName());
                            billPaymentModel.setAccountType(transactionsModel.getAccountType());
                            billPaymentModel.setAmount(Utility.formatedAmount(transactionsModel.getAmount()));
                            billPaymentModel.setAirtimeUssd(transactionsModel.getAirtimeUssd());

                            ApiResponse apiResponse = billPaymentPhoneService.saveBillPaymentPhone(billPaymentModel);
                            if (apiResponse.getError()) {
                                updateTransactionFailed(transactionsModel.getUser(), ref, apiResponse.getMessage());
                                appUtils.TextAdmin("Unresolved Payment save from user TransactionServiceImp ");
                            }

                            MpesaResponseLogsModel mpesaResponseLogsModel = new MpesaResponseLogsModel();
                            mpesaResponseLogsModel.setPhone(transactionsModel.getUser());
                            mpesaResponseLogsModel.setMerchantRequestID(response.body().getMerchantRequestID());
                            mpesaResponseLogsModel.setCheckoutRequestID(response.body().getCheckoutRequestID());
                            mpesaResponseLogsModel.setPass(response.body().getResponseCode() + "" + response.body().getCustomerMessage() + " " + response.body().getResponseDescription());

                            ApiResponse apiResponse1 = mpesaResponseLogsService.saveMpesaResponseLog(mpesaResponseLogsModel);
                            if (apiResponse1.getError()) {
                                updateTransactionFailed(transactionsModel.getUser(), ref, apiResponse1.getMessage());
                                appUtils.TextAdmin("Unresolved Payment save from user TransactionServiceImp ");
                            }


                            transactionsModel.setReference(response.body().getMerchantRequestID());
                            ApiResponse apiResponse2 = updateTransaction(transactionsModel);
                            if(apiResponse2.getError()){
                                appUtils.TextAdmin("Unresolved Payment save from user TransactionServiceImp "+apiResponse2.getMessage());

                            }

                            // return new ApiResponse(Boolean.FALSE, " " +instantPaymentQueryResponse.getResponseDescription() +  instantPaymentQueryResponse.getResultDescription());
                        } else {
                            updateTransactionFailed(transactionsModel.getUser(), ref, response.body().toString());
                            appUtils.TextAdmin("Unresolved Payment save from user TransactionServiceImp ");
                            // return Utility.Error();

                        }
                    } else {
                        updateTransactionFailed(transactionsModel.getUser(), ref, response.body().toString());
                        appUtils.TextAdmin("Unresolved Payment save from user TransactionServiceImp ");
                    }

                    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                    //ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

                    executorService.schedule(() -> {
                        instantPaymentQuery(mpesa, response.body().getCheckoutRequestID(), transactionsModel, accessToken, shortCode, timestamp, password);
                    }, 65, TimeUnit.SECONDS);

                    executorService.shutdown();

                    // return Utility.Success();

                } else {
                    Logger logger = LogManager.getLogger(getClass());
                    logger.error("MpesaError " + response.message());


                    try {
                        updateTransactionFailed(transactionsModel.getUser(), ref, response.errorBody().string());
                        appUtils.LogResult(transactionsModel.getUser(), response.errorBody().string());
                        appUtils.LogResult(transactionsModel.getUser(), response.code() + " " + Utility.getErrorCodeString(response.code()));

                    } catch (IOException e) {
                        appUtils.LogResult(transactionsModel.getUser(), e.getLocalizedMessage());

                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<InstantPaymentRequestResponse> call, Throwable throwable) {

                Logger logger = LogManager.getLogger(getClass());
                logger.error("MpesaError " + throwable.getLocalizedMessage());
                appUtils.LogResult(transactionsModel.getUser(), throwable.getLocalizedMessage());

                updateTransactionFailed(transactionsModel.getUser(), ref, throwable.getLocalizedMessage());

                appUtils.TextAdmin("Unresolved Payment save from user TransactionServiceImp ");

            }
        });
    }
*/

    @Override
    public ApiResponse updateTransactionFailed(String user, String ref, String description) {
       // Utility appUtils = new Utility( smsLogsService, billAccountsRepository, userRepository);

        TransactionsModel model = TransactionsModel.builder()
                .status("Failed")
               // .paymentStatus("Failed")
                .description(description)
                .ref(ref)
                .build();
        ApiResponse apiResponse = updateTransaction(model);
        return Utility.Success();

        //TODO
        /*if (!apiResponse.getError()) {
            appUtils.SendPushNotification("Oops! an error", "Your transaction was not successful. Kindly try again", user);

            return Utility.Success();
        } else {
            return Utility.Error();
        }*/

    }

    @Override
    public ApiResponse updateTransaction(TransactionsModel transactionsModel) {
        TransactionsModel model = transactionsRepository.getTransactionByRef(transactionsModel.getRef());

        if (transactionsModel.getStatus() != null) {
            model.setStatus(transactionsModel.getStatus());
        }

        if (transactionsModel.getDescription() != null) {
            model.setDescription(transactionsModel.getDescription());
        }
        if (transactionsModel.getAmount() != null) {
            model.setAmount(transactionsModel.getAmount());
        }


        if (transactionsModel.getStatus() != null) {
            model.setStatus(transactionsModel.getStatus());
        }

        if (transactionsModel.getPaymentRef() != null) {
            model.setPaymentRef(transactionsModel.getPaymentRef());
        }
        if (transactionsModel.getReference() != null) {
            model.setReference(transactionsModel.getReference());
        }
        if (transactionsModel.getAccountName() != null) {
            model.setAccountName(transactionsModel.getAccountName());
        }
        if (transactionsModel.getAccountNumber() != null) {
            model.setAccountNumber(transactionsModel.getAccountNumber());
        }

        if (transactionsModel.getPaymentMethod() != null) {
            model.setPaymentMethod(transactionsModel.getPaymentMethod());
        }




        try {
            transactionsRepository.save(model);
            return Utility.Success();

        } catch (Exception e) {
            LogResult(model.getUser(), e.getLocalizedMessage());
            return Utility.Error();

        }
    }


/*
    private void instantPaymentQuery(Mpesa mpesa, String checkout, TransactionsModel transactionsModel, String accessToken, String shortCode, String timestamp, String password) {

        InstantPaymentQueryRequest instantPaymentQueryRequest = InstantPaymentQueryRequest.builder()
                .businessShortCode(shortCode)
                .password(password)
                .timestamp(timestamp)
                .paymentId(PaymentId.of(checkout).getValue())
                .build();
        mpesa.queryInstantPayment(accessToken).queryInstantPayment(instantPaymentQueryRequest).enqueue(new Callback<InstantPaymentQueryResponse>() {
            @Override
            public void onResponse(Call<InstantPaymentQueryResponse> call, Response<InstantPaymentQueryResponse> response) {

                if (response.isSuccessful()) {
                    appUtils.LogResult(transactionsModel.getUser(), response.body().getResultDesc());
                    TransactionsModel models = new TransactionsModel();

                    if (response.body().getResultDesc().contains("The service request is processed successfully.")) {
                        models.setStatus("Success");
                        models.setPaymentStatus("Paid");


                    } else {
                        models.setStatus("Failed");
                        models.setPaymentStatus("Failed");

                    }


                    models.setDescription(response.body().getResultDesc());
                    models.setRef(transactionsModel.getRef());
                    updateTransaction(models);

                    if (response.body().getResultDesc().contains("The balance is insufficient for the transaction")) {

                        appUtils.SendPushNotification("Buy Airtime & Tokens Fast And Easy", "Buy Airtime for any Network At a 6% Discount", transactionsModel.getUser());

                    }
                    Logger logger = LogManager.getLogger(getClass());
                    logger.info(response.body());

                } else {
                    try {
                        updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), response.errorBody().string());
                        appUtils.LogResult(transactionsModel.getUser(), response.errorBody().string());
                        appUtils.LogResult(transactionsModel.getUser(), response.code() + " " + Utility.getErrorCodeString(response.code()));

                    } catch (IOException e) {
                        e.printStackTrace();
                        appUtils.LogResult(transactionsModel.getUser(), e.getLocalizedMessage());

                    }

                }

            }

            @Override
            public void onFailure(Call<InstantPaymentQueryResponse> call, Throwable throwable) {

                appUtils.LogResult(transactionsModel.getUser(), throwable.getMessage());
                updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), throwable.getLocalizedMessage());


            }
        });


    }
*/


}
