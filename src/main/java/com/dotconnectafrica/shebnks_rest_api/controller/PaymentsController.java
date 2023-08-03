package com.dotconnectafrica.shebnks_rest_api.controller;

import com.dotconnectafrica.shebnks_rest_api.models.TransactionsModel;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import com.dotconnectafrica.shebnks_rest_api.service.PaymentsService;
import com.dotconnectafrica.shebnks_rest_api.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.text.DecimalFormat;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class PaymentsController {
    @Autowired
    private PaymentsService paymentsService;

    @Autowired
    private TransactionsService transactionsService;



    @PostMapping("/mpesa-stk-push")
    //TODO @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> sendMpesaStkPushWahiPay(@RequestParam(name = "user") String user,
                                                               @RequestParam(name = "amount") String Amount,
                                                               @RequestParam(name = "payment_phone") String payment_phone,
                                                               @RequestParam(name = "TransactionDesc") String TransactionDesc,
                                                               @RequestParam(name = "loanId") BigInteger loanId
                                                               ) {

        Float _amount = Float.parseFloat(Amount);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        String amount = df.format(_amount);
        TransactionsModel transactionsModel = new TransactionsModel();
        transactionsModel.setUser(user);
        transactionsModel.setAmount(amount);
        transactionsModel.setPaymentAccountNumber(payment_phone);
        transactionsModel.setTransactionDesc(TransactionDesc);
        transactionsModel.setStatus("Pending");


        ApiResponse apiResponse = paymentsService.saveTransactionStkPush(transactionsModel,  loanId);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));

    }

    @GetMapping("/mpesa-stk-push-callback")
    public ResponseEntity<ApiResponse> mpesaStkPushCallback(@Valid @RequestBody String jsonAsString) {

        ApiResponse apiResponse = paymentsService.mpesaStkPushCallback(jsonAsString);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));

    }

    @PostMapping("/validate-payment")
    public ResponseEntity<ApiResponse> validatePayment(@RequestParam(name = "shortCode") String shortCode,
                                                   @RequestParam(name = "transactionID") String transactionID,
                                                   @RequestParam(name = "paymentPhone") String paymentPhone) {

        ApiResponse apiResponse = paymentsService.validatePayment( shortCode,  transactionID,  paymentPhone);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(false, apiResponse.getMessage()));

    }
    @GetMapping("/mpesa-stk-push-transaction-query-result")
    public ResponseEntity<ApiResponse> MpesaStkPushTransactionQueryResult(@Valid @RequestBody String jsonAsString) {

        ApiResponse apiResponse = paymentsService.MpesaStkPushTransactionQueryResult(jsonAsString);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));

    }



    @PostMapping("/mpesa-b2c-payment")
    public ResponseEntity<ApiResponse> loanDisbursement(@RequestParam(name = "user") String user,
                                                        @RequestParam(name = "remarks") String remarks,
                                                        @RequestParam(name = "amount") String amount,
                                                        @RequestParam(name = "loanId") BigInteger loanId){

        TransactionsModel model = new TransactionsModel();
        model.setUser(user);
        model.setAmount(amount);

        ApiResponse apiResponse = paymentsService.saveTransactionB2C( model,  remarks, loanId);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(false, apiResponse.getMessage()));

    }

    @GetMapping("/mpesa-b2c-callback")
    public ResponseEntity<ApiResponse> B2CPaymentResponse(@Valid @RequestBody String jsonAsString) {

        ApiResponse apiResponse = paymentsService.B2CPaymentResponse(jsonAsString);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));

    }

    @GetMapping("/mpesa-stk-b2c-push-callback-timeout")
    public ResponseEntity<ApiResponse> B2CPaymentResponseTimeout(@RequestBody String jsonAsString) {

        ApiResponse apiResponse = paymentsService.B2CPaymentResponseTimeout(jsonAsString);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));


    }

    @PostMapping("/reverse")
    public ResponseEntity<ApiResponse> reverseMpesaPayment(@RequestParam(name = "user") String user,
                                                           @RequestParam(name = "transID") String transID,
                                                           @RequestParam(name = "amount") float amount,
                                                           @RequestParam(name = "shortCode") String shortCode) {


        ApiResponse apiResponse = paymentsService.reverseMpesaPayment(user, transID, amount,  shortCode);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));


    }

    @GetMapping("/reversal-callback")
    public ResponseEntity<ApiResponse> ReversalResponse(@RequestBody String jsonAsString) {

        ApiResponse apiResponse = paymentsService.ReversalResponse(jsonAsString);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));


    }


}
