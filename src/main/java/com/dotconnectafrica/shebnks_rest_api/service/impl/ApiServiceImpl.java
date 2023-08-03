package com.dotconnectafrica.shebnks_rest_api.service.impl;

import com.dotconnectafrica.shebnks_rest_api.Utility.AES;
import com.dotconnectafrica.shebnks_rest_api.Utility.EmailHandler;
import com.dotconnectafrica.shebnks_rest_api.Utility.Utility;
import com.dotconnectafrica.shebnks_rest_api.auth.security.jwt.JwtUtils;
import com.dotconnectafrica.shebnks_rest_api.auth.security.services.RefreshTokenService;
import com.dotconnectafrica.shebnks_rest_api.models.*;
import com.dotconnectafrica.shebnks_rest_api.mpesa.responses.MpesaResponse;
import com.dotconnectafrica.shebnks_rest_api.payload.*;
import com.dotconnectafrica.shebnks_rest_api.repository.*;
import com.dotconnectafrica.shebnks_rest_api.service.ApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.util.TextUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.dotconnectafrica.shebnks_rest_api.Utility.Utility.Error;


@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private SHELoansRequestRepository sheLoansRequestRepository;

    @Autowired
    private LoanCategoriesRepository loanCategoriesRepository;

    @Autowired
    private SheIqRepository sheIqRepository;

    @Autowired
    private SeedFundApplicationRepository seedFundApplicationRepository;

    @Autowired
    private SeedFundWinnersRepository seedFundWinnersRepository;

    @Autowired
    private SeedFundJudgesRepository seedFundJudgesRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RefreshTokenService refreshTokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ApiResponse testUser() {

       // UserModel userModel = userRepository.findByUserId(1);
        return new ApiResponse(Boolean.FALSE, "userModel.getFirstName()");
    }

    @Value("${shebnks.app.loanlimit}")
    private String loanlimit;

    @Override
    public SignupResponse signup(UserModel userModel) {
        String firstName = new AES().encrypt(userModel.getFirstName());
        String middleName = new AES().encrypt(userModel.getMiddleName());
        String lastName = new AES().encrypt(userModel.getLastName());
        String idNumber = new AES().encrypt(userModel.getIdNumber());
        String mobileNumber = new AES().encrypt(userModel.getMobileNumber());
        String emailAddress = new AES().encrypt(userModel.getEmailAddress());


        if (!userRepository.existsByMobileNumberOrEmailAddressOrIdNumber(mobileNumber, emailAddress, idNumber)) {


            boolean isEmail = new Utility().isValidEmail(userModel.getEmailAddress());

            if (isEmail) {

                String encodedPassword = passwordEncoder.encode(userModel.getIdNumber());
                userModel.setFirstName(firstName);
                userModel.setMiddleName(middleName);
                userModel.setLastName(lastName);
                userModel.setIdNumber(idNumber);
                userModel.setMobileNumber(mobileNumber);
                userModel.setEmailAddress(emailAddress);
                userModel.setPassword(encodedPassword);

                //TODO
                userModel.setLoanLimit(loanlimit);

                try {

                    userRepository.save(userModel);

                    UserModel userModel1 = userRepository.findByMobileNumber(mobileNumber).orElseThrow(() ->  new UsernameNotFoundException("User Not Found with phone: " + userModel.getMobileNumber()));

                    Authentication authentication = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(userModel1.getMobileNumber(), new AES().decrypt( userModel1.getIdNumber())));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    String jwt = jwtUtils.generateJwtToken(authentication);
                    //long userId = userModel1.getUserId();
                   // RefreshToken refreshToken = refreshTokenService.createRefreshToken(userId);

                    SignupResponse.ResponseDetails responseDetails = new SignupResponse.ResponseDetails();
                    responseDetails.setId(userModel1.getUserId());
                    responseDetails.setPhone(new AES().decrypt(userModel1.getMobileNumber()));
                    responseDetails.setFirst_name(new AES().decrypt(userModel1.getFirstName()));
                    responseDetails.setLast_name(new AES().decrypt(userModel1.getLastName()));
                    responseDetails.setEmail(new AES().decrypt(userModel1.getEmailAddress()));
                    responseDetails.setToken(jwt);
                   // responseDetails.setRefreshToken(refreshToken.getToken());

                    return new SignupResponse(Boolean.FALSE, "Successfully created new user", responseDetails);
                } catch (Exception e) {

                    return new SignupResponse(Boolean.TRUE,  e.getMessage());

                }


            } else {
                return new SignupResponse(Boolean.TRUE, "Oops! An error occurred. Try again");
            }
        } else {

            UserModel userModel1 = userRepository.findByMobileNumber(mobileNumber).orElseThrow(() ->  new UsernameNotFoundException("User Not Found with phone: " + userModel.getMobileNumber()));

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userModel1.getMobileNumber(), new AES().decrypt( userModel1.getIdNumber())));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            SignupResponse.ResponseDetails responseDetails = new SignupResponse.ResponseDetails();
            responseDetails.setId(userModel1.getUserId());
            responseDetails.setPhone(new AES().decrypt(userModel1.getMobileNumber()));
            responseDetails.setFirst_name(new AES().decrypt(userModel1.getFirstName()));
            responseDetails.setLast_name(new AES().decrypt(userModel1.getLastName()));
            responseDetails.setEmail(new AES().decrypt(userModel1.getEmailAddress()));
            responseDetails.setToken(jwt);
            // responseDetails.setRefreshToken(refreshToken.getToken());

            return new SignupResponse(Boolean.FALSE, "User login successfully", responseDetails);
           // return new SignupResponse(Boolean.TRUE, "Account already exist, User already has an account");
        }
    }

    @Override
    public UserProfileResponse getUserDetails(String user) {

        if (userRepository.existsByMobileNumber(new AES().encrypt(user))) {
            UserModel model = userRepository.findByMobileNumber(new AES().encrypt(user)).orElseThrow(() -> new UsernameNotFoundException("User Not Found with phone: " + user));;

            UserProfileResponse.ResponseDetails responseDetails = new UserProfileResponse.ResponseDetails();
            responseDetails.setUserId(model.getUserId());
            responseDetails.setFirstName(new AES().decrypt(model.getFirstName()));
            responseDetails.setMiddleName(new AES().decrypt(model.getMiddleName()));
            responseDetails.setLastName(new AES().decrypt(model.getLastName()));
            responseDetails.setEmailAddress(new AES().decrypt(model.getEmailAddress()));
            responseDetails.setBalance(model.getBalance());
            responseDetails.setCurrency(model.getCurrency());
            responseDetails.setCardExpiry(model.getCardExpiry());
            responseDetails.setMobileuuid(model.getMobileuuid());
            responseDetails.setFirebaseId(model.getFirebaseId());
            responseDetails.setMobileNumber(new AES().decrypt(model.getMobileNumber()));
            responseDetails.setLoanLimit(model.getLoanLimit());
            responseDetails.setSheloans(model.getSheloans());
            responseDetails.setShebnksCardNumber(model.getShebnksCardNumber());
            responseDetails.setUuid(model.getUuid());
            responseDetails.setProfileImage(model.getProfileImage());
            responseDetails.setMessagingToken(model.getMessagingToken());
            responseDetails.setAccountVerificationStatus(model.getAccountVerificationStatus());
            responseDetails.setIdNumber(new AES().decrypt(model.getIdNumber()));

            return new UserProfileResponse(Boolean.FALSE, "User account details", responseDetails);
        } else {
            return new UserProfileResponse(Boolean.TRUE, "User does not exist");
        }

    }

    @Override
    public ApiResponse updateUserData(UserModel userModel) {
        if (userRepository.existsByMobileNumber(new AES().encrypt(userModel.getMobileNumber()))) {
            UserModel model = userRepository.findByMobileNumber(new AES().encrypt(userModel.getMobileNumber())).orElseThrow(() -> new UsernameNotFoundException("User Not Found with phone: " + userModel.getMobileNumber()));;
            model.setFirstName(new AES().encrypt(userModel.getFirstName()));
            model.setMiddleName(new AES().encrypt(userModel.getMiddleName()));
            model.setLastName(new AES().encrypt(userModel.getLastName()));

            try {
                userRepository.save(model);
                return Utility.Success();
            } catch (Exception e) {
                return Utility.Error();
            }
        } else {
            return new ApiResponse(Boolean.TRUE, "User does not exist");
        }
    }

    @Override
    public ApiResponse GetNotifications(String user) {
        return null;
    }

    @Override
    public ApiResponse userStatisticsData(String user, String deviceMessagingToken) {
        return null;
    }

    @Override
    public ApiResponse getUserDetailsFingerPrint(String user) {
        return null;
    }

    @Override
    public ApiResponse updateNotification(String user) {
        return null;
    }

    @Override
    public ApiResponse loanApplication(String user, String loanCategoryApplied, String loanAmountApplied, String loanCode ) {

        if(userRepository.existsByMobileNumber(user)) {

            int unProcessedLoanCount = checkForUnprocessedLoan(user);

            if (unProcessedLoanCount < 50) {
               // int status = checkForExistingLoan(user);

               /* Logger logger = LogManager.getLogger(getClass());
                logger.info("checkForExistingLoan " +user +" "+ status);
*/
               // if (status == 0) {
                    String[] loanDetails = doCalculation(loanCategoryApplied, Integer.parseInt(loanAmountApplied));
                    if (loanDetails[0].equals("Loan Not Found")) {
                        return new ApiResponse(Boolean.TRUE, "Loan category missing the loan category sent was not found");

                    } else if (loanDetails[0].equals("Invalid Amount")) {
                        return new ApiResponse(Boolean.TRUE, "Invalid loan amount, Amount is greater or less than the loan limit amount");

                    } else {
                        LoanApplicationModel loanApplicationModel = new LoanApplicationModel();
                        loanApplicationModel.setLoanMobile(user);
                        loanApplicationModel.setLoanAmount(Integer.valueOf(loanDetails[0]));
                        loanApplicationModel.setLoanCategory(loanCategoryApplied);
                        loanApplicationModel.setLoanCode(loanCode);
                        loanApplicationModel.setLoanInterestAccrued(Integer.valueOf(loanDetails[1]));
                        loanApplicationModel.setLoanBalance(Integer.valueOf(loanDetails[2]));

                        //TODO when apply loan is done, update it to 2, when loan is disbursed 3, when loan is paid update it to 4.
                        loanApplicationModel.setLoanStatus(2);


                        try {
                            loanApplicationRepository.save(loanApplicationModel);

                            //TODO  Send updateSheetProcessor

                            String msg="Your loan application has been received and is being processed.Thank you.  ";
                            String title="Shebnks Loan Applied Successfully";
                            Utility utility = new Utility();
                                    utility.SendPushNotification( title,  msg, user);
                       /* Runnable runnable= () -> {
                            updateSheetProcessor p = new updateSheetProcessor();
                            LoanApplicationModel applicationModel = loanApplicationRepository.findByLoanCode(loanCode);

                           // updateDataToSpreadSheetModel model =

                           *//* try {
                                p.updateApplicationToSheet(model);
                            } catch (IOException | GeneralSecurityException e) {
                                e.printStackTrace();
                            }*//*
                        };
                        runnable.run();*/
                            return new ApiResponse(Boolean.FALSE, "Loan application successful. Loan has been validated and saved for processing");

                        } catch (Exception e) {
                            return new ApiResponse(Boolean.TRUE, "Loan application failed. Please try again: " );
                        }
                    }
               /* } else {
                    return new ApiResponse(Boolean.TRUE, "Loan application failed. You have an existing loan that is not cleared");

                }*/
            } else {
                return new ApiResponse(Boolean.TRUE, "You have an existing loan that is not yet processed");

            }
        }else {
            return new ApiResponse(Boolean.TRUE, "User does not exist");

        }
    }

    @Override
    public LoanStatusResponse loanApplicationStatus(String user) {

        if(userRepository.existsByMobileNumber(user)){
            Logger logger = LogManager.getLogger(getClass());
            logger.info("checkForExistingLoan " +user +" "+ checkForExistingLoan(user));

           // if(checkForExistingLoan(user) == 1){
                if(checkForExistingLoan(user) >= 1){

            List<LoanApplicationModel> loanApplicationModelList = loanApplicationRepository.getUnpaidLoanData(user);

            List<LoanStatusResponse.ResponseDetails> responseDetailsList = new ArrayList<>();


            for (LoanApplicationModel model : loanApplicationModelList) {

                LoanStatusResponse.ResponseDetails responseDetails = new LoanStatusResponse.ResponseDetails();
                responseDetails.setLoanId(model.getLoanId());
                responseDetails.setLoanCode(model.getLoanCode());
                responseDetails.setLoanAmount(model.getLoanAmount());
                responseDetails.setLoanInterestAccrued(model.getLoanInterestAccrued());
                responseDetails.setLoanBalance(model.getLoanBalance());
                responseDetails.setAmountPaid(model.getAmountPaid());
                responseDetails.setLastPaidDate(model.getLastPaidDate());
                responseDetails.setLoanStatus(model.getLoanStatus());
                responseDetails.setLoanCategory(model.getLoanCategory());
                responseDetails.setLoanApplicationDate(model.getLoanApplicationDate());
                responseDetails.setLoanDisbursement(model.getLoanDisbursement());
                responseDetails.setDateGiven(model.getDateGiven());
                responseDetails.setLoanDueDate(model.getLoanDueDate());
                responseDetails.setLoanMobile(model.getLoanMobile());
                UserModel loanApplicationData = userRepository.getLoanApplicationData(user);

                if(loanApplicationData.getLoanLimit().isEmpty()||loanApplicationData.getLoanLimit() == null){
                    responseDetails.setLoanLimit("0");
                }else {
                    responseDetails.setLoanLimit(loanApplicationData.getLoanLimit());
                }

                responseDetailsList.add(responseDetails);
            }

            LoanStatusResponse.requestDetails requestDetails = new LoanStatusResponse.requestDetails();

            if(sheLoansRequestRepository.existsByPhoneNumber(user)) {
                SHELoansRequestModel sheLoansRequestModel = sheLoansRequestRepository.hasAnExistingLoanRequest(user);

                requestDetails.setId(sheLoansRequestModel.getId());
                requestDetails.setUserName(sheLoansRequestModel.getUserName());
                requestDetails.setEmail(sheLoansRequestModel.getEmail());
                requestDetails.setPhoneNumber(sheLoansRequestModel.getPhoneNumber());
                requestDetails.setGovernmentId(sheLoansRequestModel.getGovernmentId());
                requestDetails.setDate_approved(sheLoansRequestModel.getDateApproved());
                requestDetails.setRejection_message_seen(sheLoansRequestModel.getRejectionMessageSeen());
                requestDetails.setDate_applied(sheLoansRequestModel.getDateApplied());
                requestDetails.setApproved(sheLoansRequestModel.getApproved());
            }
            return new LoanStatusResponse(Boolean.FALSE, "Client loan data", responseDetailsList, requestDetails);


        }else {

            UserModel loanApplicationData = userRepository.getLoanApplicationData(user);
            LoanStatusResponse.ResponseDetails responseDetails = new LoanStatusResponse.ResponseDetails();

            List<LoanStatusResponse.ResponseDetails> responseDetailsList = new ArrayList<>();

            LoanStatusResponse.requestDetails requestDetails = new LoanStatusResponse.requestDetails();


            responseDetails.setLoanMobile(new AES().decrypt(loanApplicationData.getMobileNumber()));
            requestDetails.setUserName(new AES().decrypt(loanApplicationData.getFirstName()));

            responseDetailsList.add(responseDetails);

            if(loanApplicationData.getLoanLimit().isEmpty()||loanApplicationData.getLoanLimit() == null){
                responseDetails.setLoanLimit("0");
            }else {
                responseDetails.setLoanLimit(loanApplicationData.getLoanLimit());
            }

            return new LoanStatusResponse(Boolean.FALSE, "Loan data", responseDetailsList, requestDetails);

        }}
            else {
                return new LoanStatusResponse(Boolean.TRUE, "User does not exist");

            }


    }

    @Override
    public LoansCategoryResponse loanCategories() {
        List<LoanCategoriesModel> loansCategories = loanCategoriesRepository.findAll();
        List<LoansCategoryResponse.ResponseDetails> responseDetailsList = new ArrayList<>();

        for (LoanCategoriesModel loanCategory : loansCategories) {
            LoansCategoryResponse.ResponseDetails responseDetails = new LoansCategoryResponse.ResponseDetails();
            responseDetails.setId(loanCategory.getId());
            responseDetails.setLoanCategoryName(loanCategory.getLoanCategoryName());
            responseDetails.setLoanInterest(loanCategory.getLoanInterest());
            responseDetails.setLoanMinimumAmount(loanCategory.getLoanMinimumAmount());
            responseDetails.setLoanMaximumAmount(loanCategory.getLoanMaximumAmount());
            responseDetails.setLoanRepaymentPeriod(loanCategory.getLoanRepaymentPeriod());

            responseDetailsList.add(responseDetails);
        }

            return new LoansCategoryResponse(Boolean.FALSE, "Loans categories", responseDetailsList);
        }

    @Override
    public ApiResponse updateSheIq(SheIqRequestModel sheIqRequestModel) {
        if(userRepository.existsByUserId(sheIqRequestModel.getUserId())){
        try {

            String loanPurpose  =  String.join("#", sheIqRequestModel.getLoanPurpose());
            String whereTaken  =  String.join("#", sheIqRequestModel.getWhereTaken());
            String typeOfBusiness  =  String.join("#", sheIqRequestModel.getTypeOfBusiness());
            String industry  =  String.join("#", sheIqRequestModel.getIndustry());
            String businessTypeOfLoan  =  String.join("#", sheIqRequestModel.getBusinessTypeOfLoan());
            String collateralType  =  String.join("#", sheIqRequestModel.getCollateralType());

            SheIqModel model = new SheIqModel();
            model.setUserId(String.valueOf(sheIqRequestModel.getUserId()));
            model.setLoanPurpose(loanPurpose);
            model.setWheretaken(whereTaken);
            model.setHowLongAgoTaken(sheIqRequestModel.getHowLongAgoTaken());
            model.setWhoTookTheLoan(sheIqRequestModel.getWhoTookTheLoan());
            model.setBankAccount(sheIqRequestModel.isBankAccount());
            model.setAtm(sheIqRequestModel.isCard());
            model.setInsurance(sheIqRequestModel.isInsurance());
            model.setBusiness(sheIqRequestModel.isBusiness());
            model.setTypeOfBusiness(typeOfBusiness);
            model.setBusinessDuration(String.valueOf(sheIqRequestModel.getBusinessDuration()));
            model.setIndustry(industry);
            model.setBusinessTypeOfLoan(businessTypeOfLoan);
            model.setCollateralType(collateralType);
            model.setNumberOfLoans(sheIqRequestModel.getLoanNumber());

            sheIqRepository.save(model);

            return new ApiResponse(Boolean.FALSE, "SheIq Questionnaire saved successfully");

        }  catch (Exception e) {
            return new ApiResponse(Boolean.TRUE, e.toString());
    }}else {
            return new ApiResponse(Boolean.TRUE, "User does not exist");

        }
    }

    @Override
    public SeedFundWinnersResponse seedFundWinners(String user) {
        List<seedFundWinnersModel> winnersList = seedFundWinnersRepository.findAll();

        List<SeedFundWinnersResponse.ResponseDetails> responseDetailsList = new ArrayList<>();

        for (seedFundWinnersModel model : winnersList) {
            SeedFundWinnersResponse.ResponseDetails responseDetails = new SeedFundWinnersResponse.ResponseDetails();

            responseDetails.setWinner_info(model.getWinner_info());
            responseDetails.setWinner_title(model.getWinner_title());
            responseDetails.setWinner_article_link(model.getWinner_article_link());
            responseDetails.setWinner_image_link(model.getWinner_image_link());
            responseDetails.setWinning_year(model.getWinning_year());

            responseDetailsList.add(responseDetails);
        }

            return new SeedFundWinnersResponse(Boolean.FALSE, "Seed Fund winners", responseDetailsList);
    }

    @Override
    public SeedFundApplicationStatusResponse seedFundApplicationStatus(String user) {
        SeedFundApplicationStatusResponse.ResponseDetails responseDetails = new SeedFundApplicationStatusResponse.ResponseDetails();

        if(userRepository.existsByMobileNumber(user)){
        if(seedFundApplicationRepository.checkForActiveApplication(user) == 1){
            seedFundApplicationModel model = seedFundApplicationRepository.getApplicationStatus(user);

            responseDetails.setApplicationStatus(model.getApplication_status());
            responseDetails.setConditionStatus(model.getApplication_rules_status());
            responseDetails.setAdminCheckStatus(model.getApplication_admin_check_status());
            responseDetails.setEvaluationStatus(model.getApplication_evaluation_status());
            responseDetails.setReceivedStatus(model.getApplication_received_status());

            return new SeedFundApplicationStatusResponse(Boolean.FALSE, "Seed Fund Application Status", responseDetails);

        }else {
            return new SeedFundApplicationStatusResponse(Boolean.FALSE, "User does not have active application");
        }}else {
            return new SeedFundApplicationStatusResponse(Boolean.TRUE, "User does not exist");

        }
    }



    @Override
    public ApiResponse deleteUser(UserModel user) {
        if(userRepository.existsByMobileNumber(user.getMobileNumber())){
            try {
                userRepository.deleteByMobileNumber(user.getMobileNumber());
                return new ApiResponse(Boolean.FALSE, "User deleted successfully");

            }
            catch (Exception e) {

                return new ApiResponse(Boolean.TRUE,  e.getMessage());

            }
        }else {
            return new ApiResponse(Boolean.TRUE, "User does not exist");

        }
    }

    @Override
    public ApiResponse deleteLoans(LoanApplicationModel loanApplicationModel) {
        if(loanApplicationRepository.existsByLoanMobile(loanApplicationModel.getLoanMobile())){
            try {
                loanApplicationRepository.deleteAllByLoanMobile(loanApplicationModel.getLoanMobile());
                return new ApiResponse(Boolean.FALSE, "User Loans deleted successfully");

            }
            catch (Exception e) {

                return new ApiResponse(Boolean.TRUE,  e.getMessage());

            }
        }else {
            return new ApiResponse(Boolean.TRUE, "User loan does not exist");

        }
    }

    @Override
    public ApiResponse seedFundApplication(SeedFundApplicationRequestModel seedFundApplicationRequestModel) {



       // return new ApiResponse(Boolean.TRUE, "Application saved for processing "+seedFundApplicationRepository.datediff_years());
        if(seedFundApplicationRepository.getApplicationCount(seedFundApplicationRequestModel.getUsername()) == 0){
            if(seedFundApplicationRepository.validateApplication(seedFundApplicationRequestModel.getUsername()) == 0){

                try {
                    String business_founders  =  String.join("#", seedFundApplicationRequestModel.getFounders());
                    String business_sectors  =  String.join("#", seedFundApplicationRequestModel.getSectors());
                    String business_target  =  String.join("#", seedFundApplicationRequestModel.getPrimaryTarget());

                    seedFundApplicationModel model = new seedFundApplicationModel();
                    model.setApplicant(seedFundApplicationRequestModel.getUsername());
                    model.setBusiness_name(seedFundApplicationRequestModel.getName());
                    model.setBussiness_mobile(seedFundApplicationRequestModel.getNumber());
                    model.setBusiness_founders(business_founders);
                    model.setBussiness_about(seedFundApplicationRequestModel.getAbout());
                    model.setBussiness_vision_mission(seedFundApplicationRequestModel.getStatements());
                    model.setOwnedbywomen(String.valueOf(seedFundApplicationRequestModel.isWomanOwned()));
                    model.setBussiness_sectors(business_sectors);
                    model.setBussiness_target(business_target);
                    model.setProven_traction(seedFundApplicationRequestModel.getIncomeGeneration());
                    model.setFunding_reason(seedFundApplicationRequestModel.getIncome());
                    model.setBusiness_share_capital(seedFundApplicationRequestModel.getAttachments().getShareCapital());
                    model.setFandraised_before(String.valueOf(seedFundApplicationRequestModel.isFundraised()));
                    model.setBussiness_goals(seedFundApplicationRequestModel.getScalingGoals());
                    model.setBussiness_challenge(seedFundApplicationRequestModel.getProblems());
                    model.setBussiness_challenge_solution(seedFundApplicationRequestModel.getSolution());
                    model.setProject_budget(seedFundApplicationRequestModel.getAttachments().getProjectBudget());
                    model.setJoint_statement(seedFundApplicationRequestModel.getAttachments().getJointStatement());
                    model.setTax_admin_cert(seedFundApplicationRequestModel.getAttachments().getTaxAdminCert());
                    model.setOther_attachements(seedFundApplicationRequestModel.getAttachments().getOthers());
                    model.setBusiness_other_info(seedFundApplicationRequestModel.getOtherInfo());
                    model.setApplication_code(seedFundApplicationRequestModel.getApplicationCode());

                    seedFundApplicationRepository.save(model);

                    //TODO send Notifications & email


                    String msg="Hi, \nYour seed fund application has been sent successfully.You will be notified on the progress once the evaluation starts.Thank you.\n\n"+
                            "Regards,\n" +
                            "Seed Fund Team";
                    String title="Shebnks SeedFund Applied Successfully";
                    Utility utility = new Utility();

                    utility.SendPushNotification( title,  msg, seedFundApplicationRequestModel.getUsername());

                   /* Runnable myrunnable=() ->
                    {
                        String applicant = seedFundApplicationRequestModel.getEmail();
                        new EmailHandler().sendEmail(applicant, "Verification Code", msg);

                        String msgtoSeedfunddesk = "Hi," +
                                " \nYou have a new Seed Fund Application from "+applicant +" \n" +
                                "Here are the seed fund application details: \n \n \n" +
                                "Email address: "+applicant +" \n \n " +
                                "Business Name: "+businessName+" \n \nBusiness Mobile: "+businessMobile+" \n \nBusiness Email: "+businessEmail+" \n \nFounders Names: "+foundersNames+" \n \nBusiness description: "+businessAbout+" \n \nVission/Mission: "+vission_mission+" \n \nOwned by women: "+womenOwned+" \n \nBusiness Sectors: "+businessSectors+" \n \nBussiness Target: "+bussinessTarget+" \n \nIncome Generation Status: "+incomegenearionStatus+" \n \nIncome Value: "+incomeValue+" \n \nShare Capital: "+shareCapital+" \n \nFundraised Before: "+fundraisedBefore+" \n \nBusiness Goals: "+businessGoals+" \n \nBusiness Challenge: "+businessChallenge+" \n \nChallenge Solution: "+challengeSolution+" \n \nProject Budget: "+projectBudget+"\n \nJoint Statement: "+jointStatement+"\n \nTaxAdmin Certificate: "+taxAdminCert+" \n \nAnnual Financial Statement: "+annualFinacialStatement+" \n \nOther Attachments: "+otherAttachments+" \n \nOther Business Information "+otherBusinessInfo+" \n \nApplication Code "+applicationCode+"\n\n\nSeed Fund Team ";

                        new EmailHandler().sendEmail("muchpaul2@gmail.com","Seedfund Application", msgtoSeedfunddesk);

                        try {
                            String  deviceMessagingToken  = new UserDetailsProcessor().getUserMessagingToken(userIdFromToken);
                            new NotificationProcessor().sendNotificationsViaApi(deviceMessagingToken, "Loan Application", msg);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    };
                    new Thread(myrunnable).start();*/
                    return new ApiResponse(Boolean.TRUE, "Application saved for processing");


                }
            catch (Exception e) {

                return new ApiResponse(Boolean.TRUE,  e.getMessage());

            }
            }else
            {
                Runnable myrunnable=() ->
                {
                    String msg="Hi, \nYou seed fund application does not meet the time limit of (3 years) after the previous grant.Thank you.\n\n"+
                            "Regards,\n" +
                            "Seed Fund Team";
                    new EmailHandler().sendEmail(seedFundApplicationRequestModel.getUsername(), "Verification Code", msg);
                };
                new Thread(myrunnable).start();

                  return new ApiResponse(Boolean.TRUE, "Application not allowed. Applicant applied within 3 years after the last grant");

            }
        }else {
            return new ApiResponse(Boolean.TRUE, "Applicant has already sent the application");

        }
    }

    @Autowired
    private ReversalLogsRepository reversalLogsRepository;

    @Override
    public ApiResponse SheIqTest(String jsonAsString) {

        if (jsonAsString != null && !TextUtils.isEmpty(jsonAsString)) {

            ReversalLogsModel reversalLogsModel = ReversalLogsModel.builder()
                    .postData(jsonAsString)
                    .build();

            reversalLogsRepository.save(reversalLogsModel);


            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

            try {

                SheIqRequestJsonModel readValue = mapper
                        .readValue(jsonAsString, SheIqRequestJsonModel.class);



                 int loanNumber = readValue.getLoanNumber();

                //String loanPurpose  =  String.join("#", readValue.getLoanPurpose());

                String[] loanPurpose = readValue.getLoanPurpose();
                String loanPurpose1  =  String.join("#", loanPurpose);

                /* String[] whereTaken;
                 String howLongAgoTaken;
                 String whoTookTheLoan;
                 boolean bankAccount;
                 boolean card;
                 boolean insurance;
                 boolean business;
                 String[] typeOfBusiness;
                 String businessDuration;
                 String[] industry;
                 String[] businessTypeOfLoan;
                 String[] collateralType;
                 BigInteger userId;*/


                 return new ApiResponse(Boolean.FALSE, "loanNumber: "+loanNumber+"loanpurpose: "+loanPurpose1);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Error();

            }

        }else {
        return Utility.Error();}
    }

    private int checkForExistingLoan(String user){
       return loanApplicationRepository.checkForExistingLoan(user);

    }

    private int checkForUnprocessedLoan(String user){
        return loanApplicationRepository.checkForUnprocessedLoan(user);

    }

    public String [] doCalculation(String loanCategory,int amount)
    {
        String[] respo;

        if(loanCategoriesRepository.existsByLoanCategoryName(loanCategory)) {
            LoanCategoriesModel loanDetails = loanCategoriesRepository.getLoanDetails(loanCategory);

            int minAmount = loanDetails.getLoanMinimumAmount();
            int maxAmount = loanDetails.getLoanMaximumAmount();
            double interest = Double.valueOf(loanDetails.getLoanInterest());
            int repaymentDays = Integer.parseInt(loanDetails.getLoanRepaymentPeriod());

            if (amount > 0 && amount >= minAmount && amount <= maxAmount) {
                double loanInterest = (interest / 100) * (double) amount;
                double totalLoan = (double) amount + loanInterest;

                String loanAmount = String.valueOf(amount);
                String LoanInterest = String.valueOf(Math.round(loanInterest));
                String totalLoanAmount = String.valueOf(Math.round(totalLoan));
                String loanoRepaymentPeriod = String.valueOf(Math.round(totalLoan));

                respo = new String[]{loanAmount, LoanInterest, totalLoanAmount, loanoRepaymentPeriod};
            } else {
                respo = new String[]{"Invalid Amount"};
            }
        }else {
            respo = new String[]{"Loan Not Found"};

        }

        return respo;
    }
}
