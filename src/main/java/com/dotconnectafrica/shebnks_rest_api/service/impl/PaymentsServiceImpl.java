package com.dotconnectafrica.shebnks_rest_api.service.impl;

import com.dotconnectafrica.shebnks_rest_api.Utility.AES;
import com.dotconnectafrica.shebnks_rest_api.Utility.InitiatorPasswordEncryption;
import com.dotconnectafrica.shebnks_rest_api.Utility.Utility;
import com.dotconnectafrica.shebnks_rest_api.contants.AppConstants;
import com.dotconnectafrica.shebnks_rest_api.exception.ResourceNotFoundException;
import com.dotconnectafrica.shebnks_rest_api.models.types.*;
import com.dotconnectafrica.shebnks_rest_api.mpesa.exception.MpesaException;
import com.dotconnectafrica.shebnks_rest_api.mpesa.requests.*;
import com.dotconnectafrica.shebnks_rest_api.mpesa.responses.*;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import com.dotconnectafrica.shebnks_rest_api.repository.*;
import com.dotconnectafrica.shebnks_rest_api.service.MpesaLogsService;
import com.dotconnectafrica.shebnks_rest_api.service.MpesaResponseLogsService;
import com.dotconnectafrica.shebnks_rest_api.service.PaymentsService;
import com.dotconnectafrica.shebnks_rest_api.service.TransactionsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dotconnectafrica.shebnks_rest_api.models.*;
import com.dotconnectafrica.shebnks_rest_api.mpesa.Mpesa;
import com.dotconnectafrica.shebnks_rest_api.mpesa.base.RequestClient;
import com.dotconnectafrica.shebnks_rest_api.mpesa.enums.CommandID;
import com.dotconnectafrica.shebnks_rest_api.mpesa.enums.IdentifierType;
import com.dotconnectafrica.shebnks_rest_api.mpesa.rest.params.AccessToken;
import com.dotconnectafrica.shebnks_rest_api.mpesa.rest.params.AuthorizationCache;
import org.apache.http.util.TextUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.dotconnectafrica.shebnks_rest_api.Utility.GenerationUtils.generatePassword;
import static com.dotconnectafrica.shebnks_rest_api.Utility.GenerationUtils.generateTimestamp;
import static com.dotconnectafrica.shebnks_rest_api.Utility.Preconditions.checkEmptyString;
import static com.dotconnectafrica.shebnks_rest_api.Utility.Preconditions.checkNotNull;
import static com.dotconnectafrica.shebnks_rest_api.Utility.Utility.*;


@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private MpesaLogsService mpesaLogsService;

    @Autowired
    private PaymentsRepository paymentsRepository;


    @Autowired
    private PaymentsB2CLogsRepository paymentsB2CLogsRepository;

     @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
     private B2CPaymentRepository b2CPaymentRepository;

    @Autowired
    private ReversalLogsRepository reversalLogsRepository;


    @Autowired
    private ReversalRepository reversalRepository;


    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    @Lazy
    private MpesaResponseLogsService mpesaResponseLogsService;

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private LoanCategoriesRepository loanCategoriesRepository;

    @Autowired
    private MpesaResponseLogsRepository mpesaResponseLogsRepository;

    @Autowired
    private Utility appUtils;


    @Value("${MPESA_B2C_7004342}")
    String MPESA_B2C_7004342;

    @Value("${MPESA_USERNAME_B2C}")
    String MPESA_USERNAME_B2C;

    @Value("${MPESA_PASSWORD_B2C}")
    String MPESA_PASSWORD_B2C;

    @Override

    public ApiResponse saveTransactionB2C(TransactionsModel transactionsModel, String remarks, BigInteger loanId) {


        String accountNumber = transactionsModel.getUser().trim();

        if ( transactionsModel.getUser().trim().length() > 13) {
            return new ApiResponse(Boolean.TRUE, "Invalid phone number");
        }
            accountNumber = Utility.sanitizePhone(accountNumber);



        String ref = String.valueOf(Long.parseLong(transactionsRepository.generateReference()) + 1);
        transactionsModel.setAmount(Utility.formatedAmount(transactionsModel.getAmount()));
        transactionsModel.setAccountNumber(accountNumber);
        transactionsModel.setRef(ref);
        transactionsModel.setPaymentMethod("M-Pesa");
        transactionsModel.setLoanId(loanId);

        try {

            transactionsRepository.save(transactionsModel);
        } catch (Exception e) {
            LogResult(transactionsModel.getUser(), e.getLocalizedMessage());
            return new ApiResponse(Boolean.TRUE, "Oops an error occurred: "+ e.getLocalizedMessage());
        }



        ApiResponse apiResponse = MpesaB2CBulkPayment(transactionsModel, remarks  );

        return new ApiResponse(apiResponse.getError() ,apiResponse.getMessage());



    }


    @Value("${MPESA_USERNAME_4085267}")
    String MPESA_USERNAME_4085267;

    @Value("${MPESA_PASSWORD_4085267}")
    String MPESA_PASSWORD_4085267;
    @Override
    public ApiResponse saveTransactionStkPush(TransactionsModel transactionsModel, BigInteger loanId) {


        String accountNumber = transactionsModel.getUser().trim();

        if (transactionsModel.getUser().trim().length() > 13 || transactionsModel.getPaymentAccountNumber().trim().length() > 13) {
            return new ApiResponse(Boolean.TRUE, "Invalid phone number");
        }
        accountNumber = Utility.sanitizePhone(accountNumber);



        if (transactionsRepository.existsByUser(transactionsModel.getUser())) {
            String TimeStamp = transactionsRepository.getUserTransactionTimeStamp(transactionsModel.getUser()).substring(0, 19);//transactionsRepository.findUserTransction(transactionsModel.getUser()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.TODO, AppConstants.ID, transactionsModel.getUser()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeStampNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            //Check if user request was processes 30sec ago or throw error
            try {
                Date firstParsedDate = dateFormat.parse(TimeStamp);
                Date secondParsedDate = dateFormat.parse(timeStampNow);

                long diff = secondParsedDate.getTime() - firstParsedDate.getTime();

                if (diff < 35000) {
                    return new ApiResponse(Boolean.TRUE, "We Have received a payment of KES " + transactionsModel.getAmount() + " .Please be patient as we complete the previous payment");
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        String ref = String.valueOf(Long.parseLong(transactionsRepository.generateReference()) + 1);
        transactionsModel.setAmount(Utility.formatedAmount(transactionsModel.getAmount()));
        transactionsModel.setAccountNumber(accountNumber);
        transactionsModel.setRef(ref);
        transactionsModel.setPaymentMethod("M-Pesa");
        transactionsModel.setLoanId( loanId);
        transactionsModel.setDescription("Loan Repayment");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        transactionsModel.setCreatedAt(dtf.format(now));

        LoanApplicationModel loanApplicationModel = loanApplicationRepository.findByLoanId(loanId);

        loanApplicationModel.setLoanApplicationDate(dtf.format(now));

        try {

            transactionsRepository.save(transactionsModel);
            loanApplicationRepository.save(loanApplicationModel);
        } catch (Exception e) {
            LogResult(transactionsModel.getUser(), e.getLocalizedMessage());
            return Utility.Error();
        }


        Mpesa mpesa = new RequestClient(MPESA_USERNAME_4085267, MPESA_PASSWORD_4085267, true);

        AuthorizationCache authorizationCache = AuthorizationCache.getInstance();

        if (!authorizationCache.isEmpty()) {

            AccessToken accessToken = authorizationCache.get();
            Logger logger = LogManager.getLogger(getClass());
            logger.error("AccessToken " + accessToken.getAccessToken());
            stkPush(accessToken.getAccessToken(), mpesa,  transactionsModel, ref);

        } else {

            try {
                mpesa.authenticate().getAccessToken().enqueue(new Callback<>() {
                    @Override
                    public void onResponse(Call<AccessToken> call, Response<AccessToken> res) {
                        if (res.isSuccessful()) {
                            String accessToken = res.body().getAccessToken();

                            Logger logger = LogManager.getLogger(getClass());
                            logger.error("New AccessToken " + accessToken);
                            authorizationCache.put(AccessToken.builder().accessToken(accessToken).build());

                            stkPush(accessToken, mpesa, transactionsModel, ref);

                        } else {

                            try {
                                Logger logger = LogManager.getLogger(getClass());
                                logger.error("MpesaError " + res.code() + res.message());
                                LogResult(transactionsModel.getUser(), res.code() + " " + Utility.getErrorCodeString(res.code()));

                                transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, "" + res.errorBody().string());
                                LogResult(transactionsModel.getUser(), res.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AccessToken> call, Throwable throwable) {
                        Logger logger = LogManager.getLogger(getClass());
                        logger.error("MpesaError " + throwable.getLocalizedMessage());
                        LogResult(transactionsModel.getUser(), throwable.getLocalizedMessage());

                        transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, throwable.getLocalizedMessage());

                    }
                });


            } catch (Exception e) {
                e.printStackTrace();
                transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, e.getLocalizedMessage());
                return Utility.Error();
            }
        }


        return Utility.Success();


    }

    public ApiResponse MpesaB2CBulkPayment(TransactionsModel transactionsModel, String remarks) {
        if (userRepository.existsByMobileNumber(new AES().encrypt(transactionsModel.getUser()))) {

            try {

                Mpesa mpesa = new RequestClient(MPESA_USERNAME_B2C, MPESA_PASSWORD_B2C, true);

                AuthorizationCache authorizationCache = AuthorizationCache.getInstance();

                if (!authorizationCache.isEmpty()) {

                    AccessToken accessToken = authorizationCache.get();
                    Logger logger = LogManager.getLogger(getClass());
                    logger.error("AccessToken " + accessToken.getAccessToken());
                    initiateB2CBulkPayment(remarks, accessToken.getAccessToken(),  mpesa,  transactionsModel );
                } else {
                    mpesa.authenticate().getAccessToken().enqueue(new Callback<AccessToken>() {
                        @Override
                        public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                            if (response.isSuccessful()) {
                                String accessToken = response.body().getAccessToken();
                                initiateB2CBulkPayment(remarks, accessToken,  mpesa,  transactionsModel );
                            }else {

                                try {
                                    LogResult(transactionsModel.getUser(), response.errorBody().string());
                                    transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), response.errorBody().toString());

                                } catch (IOException e) {
                                    e.printStackTrace();
                                    LogResult(transactionsModel.getUser(), e.getLocalizedMessage());
                                    transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), e.getLocalizedMessage());

                                }

                               /* if (transactionsModel.getPaymentMethod().equals("M-Pesa")) {
                                    reverseMpesaPayment(transactionsModel.getUser(), paymentsModel.getTransId(), Float.parseFloat(paymentsModel.getTransAmount()), paymentsModel.getBusinessShortCode());
                                }*/
                            }
                        }

                        @Override
                        public void onFailure(Call<AccessToken> call, Throwable throwable) {
                            LogResult(transactionsModel.getUser(), throwable.getLocalizedMessage());
                            transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), throwable.getLocalizedMessage());
                           /* if (transactionsModel.getPaymentMethod().equals("M-Pesa")) {
                                reverseMpesaPayment(transactionsModel.getUser(), paymentsModel.getTransId(), Float.parseFloat(paymentsModel.getTransAmount()), paymentsModel.getBusinessShortCode());
                            }*/
                            throw new MpesaException("Unable to authenticate Mpesa client", throwable);
                        }
                    });

                }
                 return Success();

            } catch (Exception e) {
                e.printStackTrace();
                LogResult(transactionsModel.getUser(), e.getLocalizedMessage());
                transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), e.getLocalizedMessage());
               /* if (transactionsModel.getPaymentMethod().equals("M-Pesa")) {
                    reverseMpesaPayment(transactionsModel.getUser(), paymentsModel.getTransId(), Float.parseFloat(paymentsModel.getTransAmount()), paymentsModel.getBusinessShortCode());
                }*/
                 return Error();
            }
        } else {
            transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), "User not member");
           /* if (transactionsModel.getPaymentMethod().equals("M-Pesa")) {
                reverseMpesaPayment(transactionsModel.getUser(), paymentsModel.getTransId(), Float.parseFloat(paymentsModel.getTransAmount()), paymentsModel.getBusinessShortCode());
            }*/
             return Error();

        }
    }

    @Value("${MPESA_SHORTCODE_B2C_INITIATOR}")
    String MPESA_SHORTCODE_B2C_INITIATOR;

    @Value("${MPESA_SHORTCODE_B2C_INITIATOR_PASS}")
    String MPESA_SHORTCODE_B2C_INITIATOR_PASS;

    @Value("${MPESA_SHORTCODE_B2C}")
    String MPESA_SHORTCODE_B2C;

    @Value("${MPESA_QueueTimeOutURL_B2C}")
    String MPESA_QueueTimeOutURL_B2C;

    @Value("${MPESA_ResultURL_B2C}")
    String MPESA_ResultURL_B2C;
    private void initiateB2CBulkPayment(String remarks, String accessToken,  Mpesa mpesa, TransactionsModel transactionsModel  ){

        InitiatorPasswordEncryption app = new InitiatorPasswordEncryption();


        try {
            String ciphertext = app.getEncryptedPasswd("Benben@0");


            checkInitiatorPreconditions(
                    MPESA_SHORTCODE_B2C_INITIATOR,
                    MPESA_SHORTCODE_B2C,
                    ciphertext);
            PaymentRequest paymentRequest = PaymentRequest.builder()
                    .initiatorName("okiora")
                    .credentials(ciphertext)
                    .transactionType(CommandID.BUSINESS_PAYMENT.getCommandId())
                    .amount(String.valueOf(TransactionAmount.of(new BigDecimal(transactionsModel.getAmount())).getValue()))
                    .initiatorShortCode(MPESA_SHORTCODE_B2C)
                    .payee(transactionsModel.getAccountNumber())
                    .description(remarks)
                    .queueTimeoutUrl(MPESA_QueueTimeOutURL_B2C)
                    .resultUrl(MPESA_ResultURL_B2C)

                    .build();


            mpesa.reversal(accessToken).initiateB2C(paymentRequest).enqueue(new Callback<BusinessPaymentRequestResponse>() {
                @Override
                public void onResponse(Call<BusinessPaymentRequestResponse> call, Response<BusinessPaymentRequestResponse> response) {
                    if (response.isSuccessful()) {
                        LogResult(transactionsModel.getUser(), response.body().toString());

                        try {
                            PaymentB2CLogsModel paymentB2CLogsModel = PaymentB2CLogsModel.builder().postData(response.body().toString()).build();
                            paymentsB2CLogsRepository.save(paymentB2CLogsModel);

                        } catch (Exception e) {
                            LogResult(transactionsModel.getUser(), e.getLocalizedMessage());

                        }

                        TransactionsModel transactionsModel1 = transactionsRepository.getTransactionByRef(transactionsModel.getRef());

                        transactionsModel1.setReference(response.body().getOriginatorConversationId());
                        transactionsService.updateTransaction(transactionsModel1);

                    }else {
                        try {
                            LogResult(transactionsModel.getUser(), response.errorBody().string());
                            transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), response.errorBody().toString());

                        } catch (IOException e) {
                            e.printStackTrace();
                            transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), e.getLocalizedMessage());

                        }

                    }
                }
                @Override
                public void onFailure(Call<BusinessPaymentRequestResponse> call, Throwable throwable) {
                    LogResult(transactionsModel.getUser(), throwable.getLocalizedMessage());
                    transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), throwable.getLocalizedMessage());

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            LogResult(transactionsModel.getUser(), e.getLocalizedMessage());
            transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), e.getLocalizedMessage());

        }

    }


    @Override
    public ApiResponse reverseMpesaPayment(String user, String transID, float amount, String shortCode) {
        try {
            String remarks = "Reversal for unpaid bill";
            Mpesa mpesa = new RequestClient(getMpesaUsername(shortCode), getMpesaPassword(shortCode), true);

            AuthorizationCache authorizationCache = AuthorizationCache.getInstance();

            if (!authorizationCache.isEmpty()) {

                AccessToken accessToken = authorizationCache.get();

                initiateReversal(shortCode, transID, remarks, accessToken.getAccessToken(), amount, mpesa, user);
            } else {
                mpesa.authenticate().getAccessToken().enqueue(new Callback<AccessToken>() {
                    @Override
                    public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                        if (response.isSuccessful()) {
                            String accessToken = response.body().getAccessToken();

                            initiateReversal(shortCode, transID, remarks, accessToken, amount, mpesa, user);

                        }
                    }

                    @Override
                    public void onFailure(Call<AccessToken> call, Throwable throwable) {
                        LogResult(user, throwable.getLocalizedMessage());

                        throw new MpesaException("Unable to authenticate Mpesa client", throwable);
                    }
                });

            }
            return Success();

        } catch (Exception e) {
            e.printStackTrace();
            LogResult(user, e.getLocalizedMessage());

            return Error();
        }
    }

    @Value("${MPESA_CALLBACK_URL_REVERSAL}")
    String MPESA_CALLBACK_URL_REVERSAL;

    private void initiateReversal(String shortCode, String transID, String remarks, String accessToken, float amount, Mpesa mpesa, String user ){

        InitiatorPasswordEncryption app = new InitiatorPasswordEncryption();


        try {
            String ciphertext = app.getEncryptedPasswd(getMpesaInitiatorPassword(shortCode));


            checkInitiatorPreconditions(
                    getMpesaInitiator(shortCode),
                    shortCode,
                    ciphertext);
            TransactionReversalRequest reversalRequest = TransactionReversalRequest.builder()
                    .initiatorName(getMpesaInitiator(shortCode))
                    .receiverParty(shortCode)
                    .receiverIdentifierType(IdentifierType.REVERSAL.getIdentifierType())
                    .credentials(ciphertext)
                    .transactionType(CommandID.TRANSACTION_REVERSAL.getCommandId())
                    .transactionID(transID)
                    .amount(String.valueOf(TransactionAmount.of(new BigDecimal(amount)).getValue()))
                    .description(remarks)
                    .queueTimeoutUrl(MPESA_CALLBACK_URL_REVERSAL)
                    .resultUrl(MPESA_CALLBACK_URL_REVERSAL)
                    .build();


            mpesa.reversal(accessToken).initiateReversal(reversalRequest).enqueue(new Callback<BusinessTransactionReversalResponse>() {
                @Override
                public void onResponse(Call<BusinessTransactionReversalResponse> call, Response<BusinessTransactionReversalResponse> response) {
                    if(response.isSuccessful()) {
                        LogResult(user, response.body().toString());

                        TransactionsModel transactionsModel1 = transactionsRepository.findTopByUserAndPaymentRefOrderByIdDesc(user, transID);

                        transactionsModel1.setReference(response.body().getOriginatorConversationId());
                        transactionsService.updateTransaction(transactionsModel1);
                    }else {
                        try {
                            LogResult(user, response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    //TODO /v1/reversal-callback response
                }

                @Override
                public void onFailure(Call<BusinessTransactionReversalResponse> call, Throwable throwable) {
                    LogResult(user, throwable.getLocalizedMessage());

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            LogResult(user, e.getLocalizedMessage());

        }

    }

    @Value("${MPESA_USERNAME_7004342}")
    String MPESA_USERNAME_7004342;



    public String getMpesaUsername(String shortCode){
        String MPESA_USERNAME = null;
        if(shortCode.equals("7004342")){
            MPESA_USERNAME = MPESA_USERNAME_7004342;
        }
        if(shortCode.equals("4085267")){
            MPESA_USERNAME = MPESA_USERNAME_4085267;
        }


        return MPESA_USERNAME;
    }


    @Value("${MPESA_PASSWORD_4075217}")
    String MPESA_PASSWORD_4075217;


    public String getMpesaPassword(String shortCode){
        String MPESA_PASSWORD = null;

        if(shortCode.equals("4075217")){
            MPESA_PASSWORD = MPESA_PASSWORD_4075217;
        }
        if(shortCode.equals("4085267")){
            MPESA_PASSWORD = MPESA_PASSWORD_4085267;
        }


        return MPESA_PASSWORD;
    }

    @Value("${MPESA_7789023_INITIATOR}")
    String MPESA_7789023_INITIATOR;
    @Value("${MPESA_4075217_INITIATOR}")
    String MPESA_4075217_INITIATOR;


    public String getMpesaInitiator(String shortCode){
        String MPESA_INITIATOR = null;
        if(shortCode.equals("7789023")){
            MPESA_INITIATOR = MPESA_7789023_INITIATOR;
        }
        if(shortCode.equals("4075217")){
            MPESA_INITIATOR = MPESA_4075217_INITIATOR;
        }


        return MPESA_INITIATOR;
    }

    @Value("${MPESA_7789023_INITIATOR_PASS}")
    String MPESA_7789023_INITIATOR_PASS;




    public String getMpesaInitiatorPassword(String shortCode){
        String MPESA_INITIATOR_PASS = null;
        if(shortCode.equals("7789023")){
            MPESA_INITIATOR_PASS =MPESA_7789023_INITIATOR_PASS;
        }
        if(shortCode.equals("4085267")){
            MPESA_INITIATOR_PASS = MPESA_PAYBILL_PASSWORD_4085267;
        }


        return MPESA_INITIATOR_PASS;
    }
    @Override
    public ApiResponse B2CPaymentResponse(String jsonAsString) {
        if (jsonAsString != null && !TextUtils.isEmpty(jsonAsString)) {


            PaymentB2CLogsModel paymentB2CLogsModel = PaymentB2CLogsModel.builder()
                    .postData(jsonAsString)
                    .build();

            paymentsB2CLogsRepository.save(paymentB2CLogsModel);

            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {

                MpesaResponse readValue = mapper
                        .readValue(jsonAsString, MpesaResponse.class);


                if (transactionsRepository.existsByReference(readValue.getResult().getOriginatorConversationID())) {

                    if (readValue.getResult().getResultCode() == 0) {

                        float amount = 0;
                        String TransactionReceipt = null;
                        String transactionID = (readValue.getResult().getTransactionID()) == null ? "" : readValue.getResult().getTransactionID();
                        String ReceiverPartyPublicName = null;
                        String TransactionCompletedDateTime = null;
                        float B2CUtilityAccountAvailableFunds = 0;
                        String B2CRecipientIsRegisteredCustomer = null;
                        String B2CChargesPaidAccountAvailableFunds = null;
                        String B2CWorkingAccountAvailableFunds = null;

                        for (int i = 0; i < readValue.getResult().getResultParameters().getResultParameterList().size(); i++) {

                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("TransactionAmount")) {
                                amount = Float.parseFloat(readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue());
                            }
                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("TransactionReceipt")) {
                                TransactionReceipt = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                            }
                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("ReceiverPartyPublicName")) {
                                if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue().length() < 50) {
                                    ReceiverPartyPublicName = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                                }
                            }
                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("TransactionCompletedDateTime")) {
                                TransactionCompletedDateTime = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();

                            }
                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("B2CUtilityAccountAvailableFunds")) {
                                B2CUtilityAccountAvailableFunds = Float.parseFloat(readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue());
                            }
                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("B2CRecipientIsRegisteredCustomer")) {
                                B2CRecipientIsRegisteredCustomer = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                            }
                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("B2CChargesPaidAccountAvailableFunds")) {
                                B2CChargesPaidAccountAvailableFunds = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                            }
                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("B2CWorkingAccountAvailableFunds")) {
                                B2CWorkingAccountAvailableFunds = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                            }
                        }


                        B2CPaymentModel b2CPaymentModel = B2CPaymentModel.builder()
                                .transactionID(transactionID)
                                .amount(String.valueOf(amount))
                                .transactionCompletedDateTime(TransactionCompletedDateTime)
                                .receiverPartyPublicName(ReceiverPartyPublicName)
                                .b2CUtilityAccountAvailableFunds(String.valueOf(B2CUtilityAccountAvailableFunds))
                                .b2CWorkingAccountAvailableFunds(B2CWorkingAccountAvailableFunds)
                                .b2CRecipientIsRegisteredCustomer(B2CRecipientIsRegisteredCustomer)
                                .b2CChargesPaidAccountAvailableFunds(B2CChargesPaidAccountAvailableFunds)
                                .build();

                        b2CPaymentRepository.save(b2CPaymentModel);

                        if (ReceiverPartyPublicName != null) {
                            String[] arr = ReceiverPartyPublicName.split(" ", 2);
                            String accountNumber = Utility.sanitizePhone(arr[0]);

                            //TODO check if OriginatorConversationID can be used
                            //  BillPaymentModel billPaymentModel = billPaymentsRepository.getBillPaymentByPaymentPhone(accountNumber);

                            TransactionsModel model = transactionsRepository.findTopByReferenceOrderByIdDesc(readValue.getResult().getOriginatorConversationID());

                            //model.setReference(transactionID);
                            model.setResponse(readValue.getResult().getResultDesc());
                            model.setStatus("Success");
                            model.setDescription(ReceiverPartyPublicName);
                            model.setPaymentRef(TransactionReceipt);
                            model.setPaymentAccountNumber(accountNumber);


                            ApiResponse apiResponse = transactionsService.updateTransaction(model);

                            //Update loan application
                            LoanApplicationModel loanApplicationModel = loanApplicationRepository.findByLoanId(model.getLoanId());
                            LoanCategoriesModel loanCategoriesModel = loanCategoriesRepository.findByLoanCategoryName(loanApplicationModel.getLoanCategory());

                            loanApplicationModel.setLoanStatus(3);
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            loanApplicationModel.setDateGiven(dtf.format(now));
                            loanApplicationModel.setLoanDueDate(dtf.format(now.plusDays(Long.parseLong(loanCategoriesModel.getLoanRepaymentPeriod()))));

                            Logger logger = LogManager.getLogger(getClass());
                            logger.error("MpesaError " + dtf.format(now) + " "+now.plusDays(Long.parseLong(loanCategoriesModel.getLoanRepaymentPeriod())));

                            try {


                                loanApplicationRepository.save(loanApplicationModel);
                                if (!apiResponse.getError()) {
                                    //TODO send Sms
                                    String msg = transactionID + ". Confirmed. Ksh." + amount + " sent to " + ReceiverPartyPublicName + " \n\nsuccessfully on " + TransactionCompletedDateTime;
                                    String title = "MPESA";
                                    appUtils.SendPushNotification(title, msg, model.getUser());


                                }
                                return Success();
                             }   catch (Exception e) {
                                return new ApiResponse(Boolean.TRUE, e.getLocalizedMessage());

                            }


                        } else {
                            LogResult(readValue.getResult().getTransactionID(), readValue.getResult().getResultDesc());

                            return Error();
                        }


                    } else {

                        TransactionsModel model = transactionsRepository.findTopByReferenceOrderByIdDesc(readValue.getResult().getOriginatorConversationID());

                        //model.setReference(transactionID);
                        model.setResponse(readValue.getResult().getResultDesc());
                        model.setStatus("Failed");

                        ApiResponse apiResponse = transactionsService.updateTransaction(model);

                        return new ApiResponse(apiResponse.getError(), apiResponse.getMessage());

                    }
                }else {
                    return Error();
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Error();

            }
        } else {
            return Error();
        }
    }

    @Override
    public ApiResponse B2CPaymentResponseTimeout(String jsonAsString) {

        //TODO
        return Success();
    }


    @Value("${MPESA_4085267}")
    String MPESA_4085267;

    @Value("${MPESA_PAYBILL_PASSWORD_4085267}")
    String MPESA_PAYBILL_PASSWORD_4085267;

    @Value("${MPESA_PARTYB_4085267}")
    String MPESA_PARTYB_4085267;

    @Value("${MPESA_CALLBACK_URL_4085267}")
    String MPESA_CALLBACK_URL_4085267;

    private void stkPush(String accessToken, Mpesa mpesa, TransactionsModel transactionsModel, String ref) {

        //Sell Airtime, Tokens, Bills, Send Money
        String payment_phone = Utility.sanitizePhone(transactionsModel.getPaymentAccountNumber().trim());



        if (MPESA_4085267 != null && MPESA_PAYBILL_PASSWORD_4085267 != null) {
            checkInstantPayPreconditions(LipaNaMpesaShortCode.of(MPESA_4085267), LipaNaMpesaPasskey.of(MPESA_PAYBILL_PASSWORD_4085267));
        } else {
            transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, "Invalid Mpesa username & password");
        }

        checkNotNull(MPESA_CALLBACK_URL_4085267, "LipaNaMpesa callback URL missing");
        checkEmptyString(MPESA_CALLBACK_URL_4085267, "LipaNaMpesa callback URL missing");
        checkNotNull(transactionsModel.getAccountNumber(), "Account reference is missing");
        checkNotNull(transactionsModel.getTransactionDesc(), "Description is missing.");

        String timestamp = generateTimestamp();
        String shortCode = LipaNaMpesaShortCode.of(MPESA_4085267).getValue();
        String password = generatePassword(LipaNaMpesaShortCode.of(MPESA_4085267), LipaNaMpesaPasskey.of(MPESA_PAYBILL_PASSWORD_4085267), timestamp);


        InstantPaymentRequest instantPaymentRequest = InstantPaymentRequest.builder()
                .accountReference(AccountReference.of(transactionsModel.getAccountNumber()).getValue())
                .businessShortCode(shortCode)
                .callbackUrl(MPESA_CALLBACK_URL_4085267)
                .amount(String.valueOf(TransactionAmount.of(new BigDecimal(transactionsModel.getAmount())).getValue()))
                .customerPhoneNumber(payment_phone)
                .initiatorShortCode(MPESA_PARTYB_4085267)
                .phoneNumber(payment_phone)
                .password(password)
                .timestamp(timestamp)
                .transactionType(CommandID.CUSTOMER_PAY_BILL_ONLINE.getCommandId())
                .transactionDescription(Description.of(transactionsModel.getTransactionDesc()).getValue())
                .build();

        mpesa.stkPush(accessToken).initiateOnlinePayment(instantPaymentRequest).enqueue(new Callback<InstantPaymentRequestResponse>() {
            @Override
            public void onResponse(Call<InstantPaymentRequestResponse> call, Response<InstantPaymentRequestResponse> response) {
                if (response.isSuccessful()) {
                    LogResult(transactionsModel.getUser(), response.body().toString());

                    if (response.body().getResponseCode() == 0) {
                        if (userRepository.existsByMobileNumber(transactionsModel.getUser())) {
                            UserModel user = userRepository.findByMobileNumber(transactionsModel.getUser()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.TODO, AppConstants.ID, transactionsModel.getUser()));
                            user.setMobileNumber(transactionsModel.getUser());
                           // user.setMessagingToken(transactionsModel.getRegId());

                            try {

                                userRepository.save(user);

                            } catch (Exception e) {
                                LogResult(user.getMobileNumber(), e.getLocalizedMessage());
                            }


                           /* LoanPaymentPhoneModel loanPaymentPhoneModel = new LoanPaymentPhoneModel();
                            loanPaymentPhoneModel.setUser(transactionsModel.getUser());
                            loanPaymentPhoneModel.setPaymentPhone(payment_phone);
                            loanPaymentPhoneModel.setAccountNumber(transactionsModel.getAccountNumber());
                            loanPaymentPhoneModel.setAccountName(transactionsModel.getAccountName());
                            loanPaymentPhoneModel.setAmount(Utility.formatedAmount(transactionsModel.getAmount()));

                            loanPaymentPhoneRepository.save(loanPaymentPhoneModel);
*/
                            MpesaResponseLogsModel mpesaResponseLogsModel = new MpesaResponseLogsModel();
                            mpesaResponseLogsModel.setPhone(transactionsModel.getUser());
                            mpesaResponseLogsModel.setMerchantRequestID(response.body().getMerchantRequestID());
                            mpesaResponseLogsModel.setCheckoutRequestID(response.body().getCheckoutRequestID());
                            mpesaResponseLogsModel.setPass(password);
                            mpesaResponseLogsModel.setTimestamp(timestamp);

                            ApiResponse apiResponse1 = mpesaResponseLogsService.saveMpesaResponseLog(mpesaResponseLogsModel);
                            if (apiResponse1.getError()) {
                                transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, apiResponse1.getMessage());
                            }


                            transactionsModel.setReference(response.body().getMerchantRequestID());
                            ApiResponse apiResponse2 = transactionsService.updateTransaction(transactionsModel);
                           /* if(apiResponse2.getError()){
                                appUtils.TextAdmin("Unresolved Payment save from user TransactionServiceImp "+apiResponse2.getMessage());

                            }*/

                            // return new ApiResponse(Boolean.FALSE, " " +instantPaymentQueryResponse.getResponseDescription() +  instantPaymentQueryResponse.getResultDescription());
                        } else {
                            transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, response.body().toString());


                        }
                    } else {
                        transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, response.body().toString());
                    }

                 /*   ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                    //ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

                    executorService.schedule(() -> {
                        instantPaymentQuery(mpesa, response.body().getCheckoutRequestID(), transactionsModel, accessToken, shortCode, timestamp, password);
                    }, 65, TimeUnit.SECONDS);

                    executorService.shutdown();*/

                    // return AppUtils.Success();

                } else {
                    Logger logger = LogManager.getLogger(getClass());
                    logger.error("MpesaError " + response.message());


                    try {
                        transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, response.errorBody().string());
                        LogResult(transactionsModel.getUser(), response.errorBody().string());
                        LogResult(transactionsModel.getUser(), response.code() + " " + Utility.getErrorCodeString(response.code()));

                    } catch (IOException e) {
                        LogResult(transactionsModel.getUser(), e.getLocalizedMessage());

                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<InstantPaymentRequestResponse> call, Throwable throwable) {

                Logger logger = LogManager.getLogger(getClass());
                logger.error("MpesaError " + throwable.getLocalizedMessage());
                LogResult(transactionsModel.getUser(), throwable.getLocalizedMessage());

                transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, throwable.getLocalizedMessage());


            }
        });
    }

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
                    LogResult(transactionsModel.getUser(), response.body().getResultDesc());
                    TransactionsModel models = new TransactionsModel();

                    if (response.body().getResultDesc().contains("The service request is processed successfully.")) {
                        models.setStatus("Success");


                    } else {
                        models.setStatus("Failed");

                    }


                    models.setResponse(response.body().getResultDesc());
                    models.setRef(transactionsModel.getRef());
                    transactionsService.updateTransaction(models);

                    if (response.body().getResultDesc().contains("The balance is insufficient for the transaction")) {

                       // appUtils.SendPushNotification("", "", transactionsModel.getUser());

                    }
                    Logger logger = LogManager.getLogger(getClass());
                    logger.info(response.body());

                } else {
                    try {
                        transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), response.errorBody().string());
                        LogResult(transactionsModel.getUser(), response.errorBody().string());
                        LogResult(transactionsModel.getUser(), response.code() + " " + Utility.getErrorCodeString(response.code()));

                    } catch (IOException e) {
                        e.printStackTrace();
                        LogResult(transactionsModel.getUser(), e.getLocalizedMessage());

                    }

                }

            }

            @Override
            public void onFailure(Call<InstantPaymentQueryResponse> call, Throwable throwable) {

                LogResult(transactionsModel.getUser(), throwable.getMessage());
                transactionsService.updateTransactionFailed(transactionsModel.getUser(), transactionsModel.getRef(), throwable.getLocalizedMessage());


            }
        });


    }


  /*  public ApiResponse mpesaStkPushCallback(String jsonAsString){
        if (jsonAsString != null && !TextUtils.isEmpty(jsonAsString)) {


            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String shortCode = LipaNaMpesaShortCode.of(MPESA_4085267).getValue();


            try {
                StkCallBackResponse readValue = mapper
                        .readValue(jsonAsString, StkCallBackResponse.class);



                MpesaResponseLogsModel model = mpesaResponseLogsRepository.findTopByCheckoutRequestIDOrderByIdDesc(readValue.getBody().getStkCallback().getMerchantRequestID()).orElseThrow(() ->  new UsernameNotFoundException("CheckoutRequestID not Found: " + readValue.getBody().getStkCallback().getMerchantRequestID()));

                Mpesa mpesa = new RequestClient(MPESA_USERNAME_4085267, MPESA_PASSWORD_4085267, true);

                AuthorizationCache authorizationCache = AuthorizationCache.getInstance();

                if (!authorizationCache.isEmpty()) {

                    AccessToken accessToken = authorizationCache.get();
                    Logger logger = LogManager.getLogger(getClass());
                    logger.error("AccessToken " + accessToken.getAccessToken());
                    instantPaymentQuery(mpesa, readValue.getBody().getStkCallback().getMerchantRequestID(), transactionsModel, accessToken.getAccessToken(), shortCode, model.getTimestamp(), model.getPass());


                } else {

                    try {
                        mpesa.authenticate().getAccessToken().enqueue(new Callback<>() {
                            @Override
                            public void onResponse(Call<AccessToken> call, Response<AccessToken> res) {
                                if (res.isSuccessful()) {
                                    String accessToken = res.body().getAccessToken();

                                    Logger logger = LogManager.getLogger(getClass());
                                    logger.error("New AccessToken " + accessToken);
                                    authorizationCache.put(AccessToken.builder().accessToken(accessToken).build());

                                    stkPush(accessToken, mpesa, transactionsModel, ref);

                                } else {

                                    try {
                                        Logger logger = LogManager.getLogger(getClass());
                                        logger.error("MpesaError " + res.code() + res.message());
                                        LogResult(transactionsModel.getUser(), res.code() + " " + Utility.getErrorCodeString(res.code()));

                                        transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, "" + res.errorBody().string());
                                        LogResult(transactionsModel.getUser(), res.errorBody().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<AccessToken> call, Throwable throwable) {
                                Logger logger = LogManager.getLogger(getClass());
                                logger.error("MpesaError " + throwable.getLocalizedMessage());
                                LogResult(transactionsModel.getUser(), throwable.getLocalizedMessage());

                                transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, throwable.getLocalizedMessage());

                            }
                        });


                    } catch (Exception e) {
                        e.printStackTrace();
                        transactionsService.updateTransactionFailed(transactionsModel.getUser(), ref, e.getLocalizedMessage());
                        return Utility.Error();
                    }
                }


            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Error();

            }
        } else {
            return Error();
        }
    }*/

    @Override
    public ApiResponse mpesaStkPushCallback(String jsonAsString) {

        if (jsonAsString != null && !TextUtils.isEmpty(jsonAsString)) {


            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {
                StkCallBackResponse readValue = mapper
                        .readValue(jsonAsString, StkCallBackResponse.class);


                if (readValue.getBody().getStkCallback().getResultCode() == 0) {


                    String Amount = null;
                    String MpesaReceiptNumber = null;
                    String TransactionDate = null;
                    String PhoneNumber = null;


                    for (int i = 0; i < readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().size(); i++) {
                        if (readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getName().equals("Amount")) {
                            Amount = readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getValue();
                        }
                        if (readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getName().equals("MpesaReceiptNumber")) {
                            MpesaReceiptNumber = readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getValue();
                        }
                        if (readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getName().equals("TransactionDate")) {
                            TransactionDate = readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getValue();
                        }
                        if (readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getName().equals("PhoneNumber")) {
                            PhoneNumber = readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getValue();
                        }
                    }

                    if (paymentsRepository.existsByTransId(MpesaReceiptNumber)) {

                        //TODO save to logs, send to admin
                        LogResult(PhoneNumber, MpesaReceiptNumber + " Payment Already exists");

                        return new ApiResponse(Boolean.TRUE, "Payment Already exists");
                    } else {
                        MpesaLogsModel mpesaLogsModel = new MpesaLogsModel();
                        mpesaLogsModel.setPhone(PhoneNumber);
                        mpesaLogsModel.setLogs(jsonAsString);
                        mpesaLogsService.addLog(mpesaLogsModel);

                        try {

                            PaymentsModel paymentsModel = PaymentsModel.builder()
                                    .transAmount(Utility.formatedAmount(Amount))
                                    .transId(MpesaReceiptNumber)
                                    .transTime(TransactionDate)
                                    .mSISDN(PhoneNumber)
                                    .businessShortCode(MPESA_4085267)
                                    .build();
                            //TODO update on CallBack from Registered -buygoodsUrl
                            paymentsRepository.save(paymentsModel);


                            /*Validate Mpesa Payment*/

                            ApiResponse apiResponse1 = validatePayment(MPESA_4085267, MpesaReceiptNumber, PhoneNumber);
                            TransactionsModel transactionsModel = transactionsRepository.getTransactionByReference(readValue.getBody().getStkCallback().getCheckoutRequestID());

                            transactionsModel.setReference(apiResponse1.getMessage()); // Update transaction with originatorID
                            ApiResponse apiResponse = transactionsService.updateTransaction(transactionsModel);

                            return new ApiResponse(apiResponse1.getError(), apiResponse1.getMessage());
                            //TODO validate callback, handle payment else update transactionError, Notify user
                            //Thread.sleep(1000);

                        } catch (Exception e) {
                            LogResult(PhoneNumber, e.getLocalizedMessage());
                            return new ApiResponse(Boolean.TRUE, e.getLocalizedMessage());
                        }
                    }
                } else {


                    TransactionsModel transactionsModel = transactionsRepository.getTransactionByReference(readValue.getBody().getStkCallback().getCheckoutRequestID());

                    transactionsModel.setResponse(readValue.getBody().getStkCallback().getResultDesc());
                    transactionsModel.setStatus("Failed");
                    transactionsService.updateTransaction(transactionsModel);

                    LogResult(readValue.getBody().getStkCallback().getMerchantRequestID(), jsonAsString);

                    return new ApiResponse(Boolean.TRUE, readValue.getBody().getStkCallback().getResultDesc() );

                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return new ApiResponse(Boolean.TRUE, e.getLocalizedMessage());


            }
        } else {
            return Error();
        }
    }

    @Override
    public ApiResponse validatePayment(String shortCode, String transactionID, String paymentPhone) {


        try {

            Logger logger1 = LogManager.getLogger(getClass());
            logger1.error("AccessToken " + "validatePayment");

            Mpesa mpesa = new RequestClient(getMpesaUsername(shortCode), getMpesaPassword(shortCode), true);

            AuthorizationCache authorizationCache = AuthorizationCache.getInstance();

            if (!authorizationCache.isEmpty()) {

                AccessToken accessToken = authorizationCache.get();
                Logger logger = LogManager.getLogger(getClass());
                logger.error("AccessToken " + "validatePayment"+accessToken.getAccessToken());
                ApiResponse apiResponse = getValidatedPayment(accessToken.getAccessToken(),  shortCode, transactionID, paymentPhone, mpesa);
                return new ApiResponse(apiResponse.getError(), apiResponse.getMessage());

            } else {
                Response<AccessToken> res = mpesa.authenticate().getAccessToken().execute();

                if (res.isSuccessful()) {
                    Logger logger = LogManager.getLogger(getClass());
                    logger.error("AccessToken " + "validatePayment"+ res.body().getAccessToken());

                    String accessToken = res.body().getAccessToken();

                    ApiResponse apiResponse = getValidatedPayment(accessToken,  shortCode, transactionID, paymentPhone, mpesa);
                    return new ApiResponse(apiResponse.getError(), apiResponse.getMessage());

                } else {
                    Logger logger = LogManager.getLogger(getClass());
                    logger.error("AccessToken " + "validatePayment"+ res.toString());

                    LogResult(paymentPhone, res.errorBody().string());
                    return new ApiResponse(Boolean.TRUE, res.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse(Boolean.TRUE, e.getLocalizedMessage());

        }


    }

    @Value("${MPESA_CALLBACK_URL_TRANSACTION_QUERY_RESULT_URL}")
    String MPESA_CALLBACK_URL_TRANSACTION_QUERY_RESULT_URL;

    private ApiResponse getValidatedPayment(String accessToken, String shortCode, String transactionID, String paymentPhone, Mpesa mpesa) {

        InitiatorPasswordEncryption app = new InitiatorPasswordEncryption();

        try {
            String ciphertext = app.getEncryptedPasswd(getMpesaInitiatorPassword(shortCode));


            TransactionQueryRequest transactionQueryRequest = TransactionQueryRequest.builder()
                    .initiatorName(getMpesaInitiator(shortCode))
                    .credentials(ciphertext)
                    .transactionType(CommandID.TRANSACTION_STATUS_QUERY.getCommandId())
                    .identifierType(IdentifierType.SHORTCODE.getIdentifierType())
                    .transactionID(transactionID)
                    .sender(shortCode)
                    .description("Customer Payment to Business via API")
                    .occasion("CustomerPayment")
                    .queueTimeoutUrl(MPESA_CALLBACK_URL_TRANSACTION_QUERY_RESULT_URL)
                    .resultUrl(MPESA_CALLBACK_URL_TRANSACTION_QUERY_RESULT_URL)
                    .build();
            Response<BusinessTransactionQueryResponse> response = mpesa.stkPush(accessToken).queryBusinessTransaction(transactionQueryRequest).execute();


            if (response.isSuccessful()) {
                LogResult(paymentPhone, response.body().toString());

                Logger logger = LogManager.getLogger(getClass());
                logger.error("AccessToken " + "getValidatedPayment" + response.body().toString());

                if (response.body().getResponseCode().equals("0")) {
                    return new ApiResponse(Boolean.FALSE, response.body().getOriginatorConversationId());
                } else {
                    LogResult(paymentPhone, response.body().getResponseCode());
                    return new ApiResponse(Boolean.TRUE, response.body().toString());

                }
            } else {
                LogResult(paymentPhone, response.errorBody().string());

                Logger logger = LogManager.getLogger(getClass());
                logger.error("AccessToken " + "getValidatedPayment" + response.toString());

                return new ApiResponse(Boolean.TRUE, response.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger logger = LogManager.getLogger(getClass());
            logger.error("AccessToken " + "getValidatedPayment" + e.getMessage());

            return new ApiResponse(Boolean.TRUE, e.getLocalizedMessage());

        }
    }


    @Override
    public ApiResponse ReversalResponse(String jsonAsString) {

        if (jsonAsString != null && !TextUtils.isEmpty(jsonAsString)) {


            ReversalLogsModel reversalLogsModel = ReversalLogsModel.builder()
                    .postData(jsonAsString)
                    .build();

            reversalLogsRepository.save(reversalLogsModel);

            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {

                MpesaResponse readValue = mapper
                        .readValue(jsonAsString, MpesaResponse.class);

                if (readValue.getResult().getResultCode() == 0) {


                    String amount = null;
                    String transCompletedTime = null;
                    String transactionID = (readValue.getResult().getTransactionID()) == null ? "" : readValue.getResult().getTransactionID();
                    String originalTransactionID = null;
                    String creditPartyPublicName = null;
                    String charge = null;
                    String debitPartyPublicName = null;

                    for (int i = 0; i < readValue.getResult().getResultParameters().getResultParameterList().size(); i++) {

                        if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("Amount")) {
                            amount = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("TransCompletedTime")) {
                            transCompletedTime = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("OriginalTransactionID")) {
                            originalTransactionID = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("CreditPartyPublicName")) {
                            if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue().length() < 50) {
                                creditPartyPublicName = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                            }
                        }
                        if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("Charge")) {
                            charge = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if (readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("DebitPartyPublicName")) {
                            debitPartyPublicName = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                    }

                    ReversalModel reversalModel = ReversalModel.builder()
                            .amount(amount)
                            .transCompletedTime(transCompletedTime)
                            .transactionID(transactionID)
                            .originalTransactionID(originalTransactionID)
                            .charge(charge)
                            .creditPartyPublicName(creditPartyPublicName)
                            .debitPartyPublicName(debitPartyPublicName)
                            .build();

                    try {
                        reversalRepository.save(reversalModel);

                        TransactionsModel transactionsModel = transactionsRepository.findTopByReferenceOrderByIdDesc(readValue.getResult().getOriginatorConversationID());

                        String ref = String.valueOf(Long.parseLong(transactionsRepository.generateReference()) + 1);

                        TransactionsModel model = TransactionsModel.builder()
                                .ref(ref)
                                .user(transactionsModel.getUser())
                                .accountNumber(transactionsModel.getAccountNumber())
                                .accountName(transactionsModel.getAccountName())
                                .amount(transactionsModel.getAmount())
                                .status("Success")
                                .description(readValue.getResult().getResultDesc())
                                .paymentMethod("M-Pesa")
                                .paymentRef(transactionID)
                                .paymentAccountNumber(creditPartyPublicName)
                                .build();


                        transactionsRepository.save(model);

                        String title = "PAYMENT REVERSAL";
                        String msg = "We have successfully reversed your payment for Ksh." + transactionsModel.getAmount() + " to your Mpesa Account. Our services are temporarily down at the moment, please try again later to make payment using WAHI ";

                        Utility utility = new Utility();
                                utility.SendPushNotification(title, msg, transactionsModel.getUser());
                        return Success();
                    } catch (Exception e) {
                        LogResult(readValue.getResult().getTransactionID(), e.getLocalizedMessage());
                        return Error();
                    }

                } else {
                    LogResult(readValue.getResult().getTransactionID(), readValue.getResult().getResultDesc());

                    return Error();

                }

            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Error();

            }
        } else {
            return Error();
        }
    }

    @Override
    public ApiResponse MpesaStkPushTransactionQueryResult(String jsonAsString) {

        if (jsonAsString != null && !TextUtils.isEmpty(jsonAsString)) {


            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {
                MpesaResponse readValue = mapper
                        .readValue(jsonAsString, MpesaResponse.class);

                if (readValue.getResult().getResultCode() == 0) {


                    String DebitPartyName = null;
                    String CreditPartyName = null;
                    String OriginatorConversationID = null;
                    String InitiatedTime = null;
                    String ReasonType = null;
                    String TransactionStatus = null;
                    String FinalisedTime = null;
                    String Amount = null;
                    String ConversationID =null;
                    String ReceiptNo = null;
                    String Occasion = null;

                    for(int i = 0; i < readValue.getResult().getResultParameters().getResultParameterList().size(); i++ ){

                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("DebitPartyName")){
                            if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue().length() < 50) {
                                DebitPartyName = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                            }
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("CreditPartyName")){
                            CreditPartyName = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("OriginatorConversationID")){
                            OriginatorConversationID = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("InitiatedTime") ){
                            InitiatedTime = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();

                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("ReasonType")){
                            ReasonType = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("TransactionStatus")){
                            TransactionStatus = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("FinalisedTime")){
                            FinalisedTime = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("Amount")){
                            Amount = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("ConversationID")){
                            ConversationID = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("ReceiptNo")){
                            ReceiptNo = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }

                    }
                    if(readValue.getResult().getReferenceData().getReferenceItem().getKey().equals("Occasion")){
                        Occasion = readValue.getResult().getReferenceData().getReferenceItem().getValue();
                    }

                    //TODO create new Table update payment
                    Logger logger1 = LogManager.getLogger(getClass());
                    logger1.error("MpesaErrorMpesaError " +readValue.getResult().getOriginatorConversationID());


                    TransactionsModel model = transactionsRepository.getTransactionByReference(readValue.getResult().getOriginatorConversationID());
                     PaymentsModel paymentsModel = paymentsRepository.getTransId(ReceiptNo);

                     //TODO LoanPayment different phone
                    //LoanPaymentPhoneModel loanPaymentPhoneModel = loanPaymentPhoneRepository.getLoanPaymentByPaymentPhone(paymentsModel.getMSISDN());


                    model.setResponse(readValue.getResult().getResultDesc());
                    model.setStatus("Success");
                    model.setResponse("Paid");
                    model.setPaymentRef(ReceiptNo);
                    if (DebitPartyName != null) {
                        model.setPaymentAccountNumber(DebitPartyName.substring(12));
                    }

                    ApiResponse apiResponse = transactionsService.updateTransaction(model);

                    //Update loan application
                    LoanApplicationModel loanApplicationModel = loanApplicationRepository.findByLoanId(model.getLoanId());
                    //LoanCategoriesModel loanCategoriesModel = loanCategoriesRepository.findByLoanCategoryName(loanApplicationModel.getLoanCategory());

                    //TODO if loan is fully paid update to 5
                    loanApplicationModel.setLoanStatus(4);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();

                    if (Amount != null) {
                        loanApplicationModel.setAmountPaid( Integer.parseInt(!Amount.contains(".") ? Amount : Amount.replaceAll("0*$", "").replaceAll("\\.$", "")));

                    }
                    loanApplicationModel.setLastPaidDate(dtf.format(now));


                    try {


                        loanApplicationRepository.save(loanApplicationModel);

                        LoanApplicationModel loanApplicationModel1 = loanApplicationRepository.findByLoanId(model.getLoanId());

                        loanApplicationModel.setLoanBalance(loanApplicationModel1.getLoanBalance() - loanApplicationModel1.getAmountPaid() );
                        loanApplicationRepository.save(loanApplicationModel1);

                        if (!apiResponse.getError()) {
                            //TODO send Sms. send different sms if loan is fully paid or outstanding and rem days...Backgound service to remind users loan due date
                            String msg =  "Confirmed. Ksh." + Amount + " Paid to your outstanding Loan " ;
                            String title = "SheBnks";
                            appUtils.SendPushNotification(title, msg, model.getUser());


                        }
                        return Success();
                    }   catch (Exception e) {
                        return new ApiResponse(Boolean.TRUE, e.getLocalizedMessage());

                    }

                    //TODO handle Loan Repayment, Get loanId, update transaction as loan repayment, if successfully
                   /* BillPaymentModel billPaymentModel = billPaymentsRepository.getBillPaymentByPaymentPhone(paymentsModel.getMSISDN());

                    ApiResponse apiResponse = appUtils.handlePayment(billPaymentModel, paymentsModel, transactionsModel);


                    return new ApiResponse(apiResponse.getError(), apiResponse.getMessage());
*/
                } else {
                    LogResult(readValue.getResult().getOriginatorConversationID(), jsonAsString);

                    return Error();

                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Error();

            }
        } else {
            return Error();
        }

    }
   /* @Override
    public ApiResponse savePayment(String jsonAsString) {

        if (jsonAsString != null && !TextUtils.isEmpty(jsonAsString)) {


            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {
                StkCallBackResponse readValue = mapper
                        .readValue(jsonAsString, StkCallBackResponse.class);

                if (readValue.getBody().getStkCallback().getResultCode() == 0) {


                    String Amount = null;
                    String MpesaReceiptNumber = null;
                    String TransactionDate = null;
                    String PhoneNumber = null;


                    for (int i = 0; i < readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().size(); i++) {
                        if (readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getName().equals("Amount")) {
                            Amount = readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getValue();
                        }
                        if (readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getName().equals("MpesaReceiptNumber")) {
                            MpesaReceiptNumber = readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getValue();
                        }
                        if (readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getName().equals("TransactionDate")) {
                            TransactionDate = readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getValue();
                        }
                        if (readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getName().equals("PhoneNumber")) {
                            PhoneNumber = readValue.getBody().getStkCallback().getCallbackMetadata().getItemList().get(i).getValue();
                        }
                    }

                    if (paymentsRepository.existsByTransId(MpesaReceiptNumber)) {

                        //TODO save to logs, send to admin
                        appUtils.Utility.LogResult(PhoneNumber, MpesaReceiptNumber + " Payment Already exists");
                        appUtils.SendSms("Payment Already exists " +PhoneNumber+" "+ MpesaReceiptNumber, "+254718621991", "+254718621991");

                        return new ApiResponse(Boolean.TRUE, "Payment Already exists");
                    } else {
                        MpesaLogsModel mpesaLogsModel = new MpesaLogsModel();
                        mpesaLogsModel.setPhone(PhoneNumber);
                        mpesaLogsModel.setLogs(jsonAsString);
                        mpesaLogsService.addLog(mpesaLogsModel);

                        try {


                            PaymentsModel paymentsModel = PaymentsModel.builder()
                                    .transAmount(AppUtils.formatedAmount(Amount))
                                    .transId(MpesaReceiptNumber)
                                    .transTime(TransactionDate)
                                    .mSISDN(PhoneNumber)
                                    .businessShortCode(MPESA_WAHI_PAY_7789023)
                                    .build();
                            //TODO update on CallBack from Registered -buygoodsUrl
                            paymentsRepository.save(paymentsModel);


                            *//*Validate Mpesa Payment*//*

                            ApiResponse apiResponse1 = validatePayment(MPESA_WAHI_PAY_7789023, MpesaReceiptNumber, PhoneNumber);
                            TransactionsModel transactionsModel = transactionsRepository.getTransactionByReference(readValue.getBody().getStkCallback().getMerchantRequestID());

                            transactionsModel.setReference(apiResponse1.getMessage()); // Update transaction with originatorID
                            ApiResponse apiResponse = transactionsService.updateTransaction(transactionsModel);

                            if(!apiResponse.getError()){
                                return AppUtils.Success();

                            }else {
                                return AppUtils.Error();
                            }
                            //TODO validate callback, handle payment else update transactionError, Notify user
                            //Thread.sleep(1000);

                        } catch (Exception e) {
                            appUtils.Utility.LogResult(PhoneNumber, e.getLocalizedMessage());
                            return AppUtils.Error();
                        }
                    }
                } else {
                    appUtils.Utility.LogResult(readValue.getBody().getStkCallback().getMerchantRequestID(), jsonAsString);

                    return AppUtils.Error();

                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return AppUtils.Error();

            }
        } else {
            return AppUtils.Error();
        }
    }

    @Override
    public ApiResponse validatePayment(String shortCode, String transactionID, String paymentPhone) {


        try {


            Mpesa mpesa = new RequestClient(appUtils.getMpesaUsername(shortCode), appUtils.getMpesaPassword(shortCode), true);

            AuthorizationCache authorizationCache = AuthorizationCache.getInstance();

            if (!authorizationCache.isEmpty()) {

                AccessToken accessToken = authorizationCache.get();
                Logger logger = LogManager.getLogger(getClass());
                ApiResponse apiResponse = getValidatedPayment(accessToken.getAccessToken(), appUtils, shortCode, transactionID, paymentPhone, mpesa);
                return new ApiResponse(apiResponse.getError(), apiResponse.getMessage());

            } else {
                Response<AccessToken> res = mpesa.authenticate().getAccessToken().execute();

                if (res.isSuccessful()) {
                    String accessToken = res.body().getAccessToken();

                    ApiResponse apiResponse = getValidatedPayment(accessToken, appUtils, shortCode, transactionID, paymentPhone, mpesa);
                    return new ApiResponse(apiResponse.getError(), apiResponse.getMessage());

                } else {
                    appUtils.Utility.LogResult(paymentPhone, res.errorBody().string());
                    return AppUtils.Error();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AppUtils.Error();

        }


    }

    @Override
    public ApiResponse MpesaStkPushTransactionQueryResult(String jsonAsString) {

        if (jsonAsString != null && !TextUtils.isEmpty(jsonAsString)) {


            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {
                MpesaResponse readValue = mapper
                        .readValue(jsonAsString, MpesaResponse.class);

                if (readValue.getResult().getResultCode() == 0) {


                    String DebitPartyName = null;
                    String CreditPartyName = null;
                    String OriginatorConversationID = null;
                    String InitiatedTime = null;
                    String ReasonType = null;
                    String TransactionStatus = null;
                    String FinalisedTime = null;
                    String Amount = null;
                    String ConversationID =null;
                    String ReceiptNo = null;
                    String Occasion = null;

                    for(int i = 0; i < readValue.getResult().getResultParameters().getResultParameterList().size(); i++ ){

                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("DebitPartyName")){
                            if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue().length() < 50) {
                                DebitPartyName = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                            }
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("CreditPartyName")){
                            CreditPartyName = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("OriginatorConversationID")){
                            OriginatorConversationID = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("InitiatedTime") ){
                                InitiatedTime = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();

                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("ReasonType")){
                            ReasonType = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("TransactionStatus")){
                            TransactionStatus = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("FinalisedTime")){
                            FinalisedTime = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("Amount")){
                            Amount = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("ConversationID")){
                            ConversationID = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }
                        if(readValue.getResult().getResultParameters().getResultParameterList().get(i).getKey().equals("ReceiptNo")){
                            ReceiptNo = readValue.getResult().getResultParameters().getResultParameterList().get(i).getValue();
                        }

                    }
                    if(readValue.getResult().getReferenceData().getReferenceItem().getKey().equals("Occasion")){
                        Occasion = readValue.getResult().getReferenceData().getReferenceItem().getValue();
                    }

                    //TODO create new Table update payment


                    TransactionsModel transactionsModel = transactionsRepository.getTransactionByReference(readValue.getResult().getOriginatorConversationID());
                    PaymentsModel paymentsModel = paymentsRepository.getTransId(ReceiptNo);

                    BillPaymentModel billPaymentModel = billPaymentsRepository.getBillPaymentByPaymentPhone(paymentsModel.getMSISDN());

                    ApiResponse apiResponse = appUtils.handlePayment(billPaymentModel, paymentsModel, transactionsModel);


                    return new ApiResponse(apiResponse.getError(), apiResponse.getMessage());

                } else {
                    appUtils.Utility.LogResult(readValue.getResult().getOriginatorConversationID(), jsonAsString);
                    appUtils.SendSms("Unresolved Payment from user ", "+254718621991", "+254718621991");

                    return AppUtils.Error();

                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return AppUtils.Error();

            }
        } else {
            return AppUtils.Error();
        }

    }



    @Value("${MPESA_CALLBACK_URL_TRANSACTION_QUERY_RESULT_URL}")
    String MPESA_CALLBACK_URL_TRANSACTION_QUERY_RESULT_URL;

    private ApiResponse getValidatedPayment(String accessToken, AppUtils appUtils, String shortCode, String transactionID, String paymentPhone, Mpesa mpesa) {

        InitiatorPasswordEncryption app = new InitiatorPasswordEncryption();

        try {
            String ciphertext = app.getEncryptedPasswd(appUtils.getMpesaInitiatorPassword(shortCode));


            checkInitiatorPreconditions(
                    appUtils.getMpesaInitiator(shortCode),
                    shortCode,
                    ciphertext);

            TransactionQueryRequest transactionQueryRequest = TransactionQueryRequest.builder()
                    .initiatorName(appUtils.getMpesaInitiator(shortCode))
                    .credentials(ciphertext)
                    .transactionType(CommandID.TRANSACTION_STATUS_QUERY.getCommandId())
                    .identifierType(IdentifierType.SHORTCODE.getIdentifierType())
                    .transactionID(transactionID)
                    .sender(shortCode)
                    .description("Customer Payment to Business via API")
                    .occasion("CustomerPayment")
                    .queueTimeoutUrl(MPESA_CALLBACK_URL_TRANSACTION_QUERY_RESULT_URL)
                    .resultUrl(MPESA_CALLBACK_URL_TRANSACTION_QUERY_RESULT_URL)
                    .build();
            Response<BusinessTransactionQueryResponse> response = mpesa.stkPush(accessToken).queryBusinessTransaction(transactionQueryRequest).execute();

            if (response.isSuccessful()) {
                appUtils.Utility.LogResult(paymentPhone, response.body().toString());

                if (response.body().getResponseCode().equals("0")) {
                    return new ApiResponse(Boolean.FALSE, response.body().getOriginatorConversationId());
                } else {
                    appUtils.Utility.LogResult(paymentPhone, response.body().getResponseCode());
                    return AppUtils.Error();

                }
            } else {
                appUtils.Utility.LogResult(paymentPhone, response.errorBody().string());
                return AppUtils.Error();

            }
        } catch (Exception e) {
            e.printStackTrace();
            return AppUtils.Error();

        }
    }
*/
}
