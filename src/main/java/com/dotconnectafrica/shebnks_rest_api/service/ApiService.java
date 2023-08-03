package com.dotconnectafrica.shebnks_rest_api.service;


import com.dotconnectafrica.shebnks_rest_api.models.*;
import com.dotconnectafrica.shebnks_rest_api.payload.*;

public interface ApiService {

    ApiResponse testUser();

    SignupResponse signup(UserModel userModel);

    UserProfileResponse getUserDetails(String user);

    ApiResponse updateUserData(UserModel userModel);

    ApiResponse GetNotifications(String user);

    ApiResponse userStatisticsData(String user, String deviceMessagingToken);

    ApiResponse getUserDetailsFingerPrint(String user);

    ApiResponse updateNotification(String user);

    ApiResponse loanApplication(String user, String loanCategoryApplied, String loanAmountApplied, String loanCode);

    LoanStatusResponse loanApplicationStatus(String user);

    LoansCategoryResponse loanCategories();

    ApiResponse updateSheIq(SheIqRequestModel sheIqRequestModel);

    SeedFundWinnersResponse seedFundWinners(String user);

    SeedFundApplicationStatusResponse seedFundApplicationStatus(String user);


    ApiResponse deleteUser(UserModel user);

    ApiResponse deleteLoans(LoanApplicationModel loanApplicationModel);

    ApiResponse seedFundApplication(SeedFundApplicationRequestModel seedFundApplicationRequestModel);

    ApiResponse SheIqTest(String jsonAsString);

}