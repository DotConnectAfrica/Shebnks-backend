package com.dotconnectafrica.shebnks_rest_api.controller;

import com.dotconnectafrica.shebnks_rest_api.Utility.AES;
import com.dotconnectafrica.shebnks_rest_api.models.*;
import com.dotconnectafrica.shebnks_rest_api.payload.*;
import com.dotconnectafrica.shebnks_rest_api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/test-api")
    public ResponseEntity<ApiResponse> testApi() {

        ApiResponse apiResponse = apiService.testUser();


        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), new AES().encrypt("+254718621991")));

    }

    @PostMapping("/auth/signup")
    public ResponseEntity<SignupResponse> signup(@RequestParam( name = "firstName") String firstName,
                                                 @RequestParam(name = "middleName") String middleName,
                                                 @RequestParam(name = "lastName") String lastName,
                                                 @RequestParam(name = "idNumber") String idNumber,
                                                 @RequestParam(name = "mobileNumber") String mobileNumber,
                                                 @RequestParam(name = "emailAddress") String emailAddress) {

        UserModel model = new UserModel();
        model.setFirstName(firstName);
        model.setMiddleName(middleName);
        model.setLastName(lastName);
        model.setIdNumber(idNumber);
        model.setMobileNumber(mobileNumber);
        model.setEmailAddress(emailAddress);

        SignupResponse apiResponse = apiService.signup(model);


        if(apiResponse.getError()){
            return ResponseEntity.status(HttpStatus.CREATED).body(new SignupResponse(apiResponse.getError(), apiResponse.getMessage()));

        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new SignupResponse(apiResponse.getError(), apiResponse.getMessage(), apiResponse.getResponseDetails()));
        }
    }

    @PostMapping("/profile/get-user-details")
    public ResponseEntity<UserProfileResponse> getUserDetails(@RequestParam(name = "user") String user) {


        UserProfileResponse apiResponse = apiService.getUserDetails(user);


        if(apiResponse.getError()){
            return ResponseEntity.status(HttpStatus.CREATED).body(new UserProfileResponse(apiResponse.getError(), apiResponse.getMessage()));

        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new UserProfileResponse(apiResponse.getError(), apiResponse.getMessage(), apiResponse.getResponseDetails()));
        }
    }

    @PostMapping("/profile/update-user-data")
    public ResponseEntity<ApiResponse> updateUserData(@RequestParam(name = "firstName") String firstName,
                                                              @RequestParam(name = "middleName") String middleName,
                                                              @RequestParam(name = "lastName") String lastName,
                                                              @RequestParam(name = "mobileNumber") String mobileNumber) {
        UserModel model = new UserModel();
        model.setFirstName(firstName);
        model.setMiddleName(middleName);
        model.setLastName(lastName);
        model.setMobileNumber(mobileNumber);

        ApiResponse apiResponse = apiService.updateUserData(model);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));

    }

    @PostMapping("/loans/apply")
    public ResponseEntity<ApiResponse> loansApply(@RequestParam(name = "user") String user,
                                                  @RequestParam(name = "category") String category,
                                                  @RequestParam(name = "amount") String amount,
                                                  @RequestParam(name = "loan_code") String loan_code) {


        ApiResponse apiResponse = apiService.loanApplication(new AES().encrypt(user), category, amount, loan_code);


        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));

    }

    @PostMapping("/loans/status")
    public ResponseEntity<LoanStatusResponse> loansStatus(@RequestParam(name = "user") String user) {


        LoanStatusResponse apiResponse = apiService.loanApplicationStatus(new AES().encrypt(user));


        if(apiResponse.getError()){
            return ResponseEntity.status(HttpStatus.CREATED).body(new LoanStatusResponse(apiResponse.getError(), apiResponse.getMessage()));

        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new LoanStatusResponse(apiResponse.getError(), apiResponse.getMessage(), apiResponse.getResponseDetails(), apiResponse.getRequestDetails()));
        }
    }

    @GetMapping("/loans/categories")
    public ResponseEntity<LoansCategoryResponse> loansCategories() {


        LoansCategoryResponse apiResponse = apiService.loanCategories();


        if(apiResponse.getError()){
            return ResponseEntity.status(HttpStatus.CREATED).body(new LoansCategoryResponse(apiResponse.getError(), apiResponse.getMessage()));

        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new LoansCategoryResponse(apiResponse.getError(), apiResponse.getMessage(), apiResponse.getResponseDetails()));
        }
    }

    @PostMapping("/delete-user")
    public ResponseEntity<ApiResponse> deleteUser(@RequestParam(name = "user") String user) {


        UserModel model = new UserModel();
        model.setMobileNumber(new AES().encrypt(user));
         ApiResponse apiResponse = apiService.deleteUser(model);


            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));


    }
    @PostMapping("/delete-user-loans")
    public ResponseEntity<ApiResponse> deleteUserLoans(@RequestParam(name = "user") String user) {


        LoanApplicationModel model = new LoanApplicationModel();
        model.setLoanMobile(new AES().encrypt(user));
        ApiResponse apiResponse = apiService.deleteLoans(model);


        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));


    }


    @PostMapping(path = "/sheiq")
    public ResponseEntity<ApiResponse> sheIq(SheIqRequestModel sheIqRequestModel){

        ApiResponse apiResponse = apiService.updateSheIq(sheIqRequestModel);

            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));


    }

    @GetMapping("/sheiq-test")
    public ResponseEntity<ApiResponse> sheIqTest(@RequestBody String jsonAsString) {

        ApiResponse apiResponse = apiService.SheIqTest(jsonAsString);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));


    }

    @PostMapping("/seed-fund-winners")
    public ResponseEntity<SeedFundWinnersResponse> seedFundWinners(@RequestParam(name = "user") String user) {


        SeedFundWinnersResponse apiResponse = apiService.seedFundWinners(user);


        if(apiResponse.getError()){
            return ResponseEntity.status(HttpStatus.CREATED).body(new SeedFundWinnersResponse(apiResponse.getError(), apiResponse.getMessage()));

        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new SeedFundWinnersResponse(apiResponse.getError(), apiResponse.getMessage(), apiResponse.getResponseDetails()));
        }
    }

    @PostMapping("/seed-fund-application-status")
    public ResponseEntity<SeedFundApplicationStatusResponse> seedFundApplicationStatus(@RequestParam(name = "user") String user) {


        SeedFundApplicationStatusResponse apiResponse = apiService.seedFundApplicationStatus(user);


        if(apiResponse.getError()){
            return ResponseEntity.status(HttpStatus.CREATED).body(new SeedFundApplicationStatusResponse(apiResponse.getError(), apiResponse.getMessage()));

        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(new SeedFundApplicationStatusResponse(apiResponse.getError(), apiResponse.getMessage(), apiResponse.getResponseDetails()));
        }
    }

    @PostMapping("/seed-fund-application")
    public ResponseEntity<ApiResponse> seedFundApplication(SeedFundApplicationRequestModel model) {

        ApiResponse apiResponse = apiService.seedFundApplication(model);

            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(apiResponse.getError(), apiResponse.getMessage()));

    }
}
