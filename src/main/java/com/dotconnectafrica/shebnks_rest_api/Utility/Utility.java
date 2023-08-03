package com.dotconnectafrica.shebnks_rest_api.Utility;


import com.dotconnectafrica.shebnks_rest_api.models.UserModel;
import com.dotconnectafrica.shebnks_rest_api.models.types.LipaNaMpesaPasskey;
import com.dotconnectafrica.shebnks_rest_api.models.types.LipaNaMpesaShortCode;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import com.dotconnectafrica.shebnks_rest_api.repository.UserRepository;
import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import us.raudi.pushraven.FcmResponse;
import us.raudi.pushraven.Message;
import us.raudi.pushraven.Notification;
import us.raudi.pushraven.Pushraven;
import us.raudi.pushraven.configs.AndroidConfig;
import us.raudi.pushraven.notifications.AndroidNotification;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.dotconnectafrica.shebnks_rest_api.Utility.Preconditions.*;
import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;


import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.BAD_REQUEST;
import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.FORBIDDEN;
import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.INTERNAL_SERVER_ERROR;
import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.METHOD_NOT_ALLOWED;
import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.NOT_ACCEPTABLE;
import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.NOT_FOUND;
import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.SERVICE_UNAVAILABLE;
import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.TOO_MANY_REQUESTS;
import static com.dotconnectafrica.shebnks_rest_api.exception.HttpResponseCode.UNAUTHORIZED;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jac
 */

@Component
public class Utility {


    @Autowired
    private UserRepository userRepository;

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public JSONObject getServerFirebaseDetails=new JSONObject();
    public Utility()
    {
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseOptions options = null;
            CredentialsProvider credentialsProvider;
            try {
                InputStream refreshToken = new URL("https://firebasestorage.googleapis.com/v0/b/matibabu-1254d.appspot.com/o/serviceaccount.json?alt=media&token=8854873a-fbe3-465c-95a6-fed3c8635e6c").openStream();

                options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(refreshToken))
                        .setDatabaseUrl("https://shebnksapp-default-rtdb.firebaseio.com/")
                        .build();
                FirebaseApp.initializeApp(options);
            } catch (IOException e) {
                e.printStackTrace();
                getServerFirebaseDetails.put("firbaseErrors", e.toString());
            }
        }

        getServerFirebaseDetails.put("servers",FirebaseApp.getApps().size());


    }
    public boolean isValidEmail(String email)
    {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static ApiResponse Success(){
        return new ApiResponse(Boolean.FALSE, "Success");
    }
    public static ApiResponse Error(){
        return new ApiResponse(Boolean.TRUE, "Oops! An error occurred. Please Try again");
    }

    public String generateCode(int count)
    {
        /*String ALPHA_NUMERIC_STRING = "15104359524231928374650007709240938170";*/
        SecureRandom objSecureRandom = new SecureRandom();
        int random = objSecureRandom.nextInt(10000000);
        String randomInt=String.valueOf(random);

        StringBuilder builder = new StringBuilder();

        while (count-- != 0)
        {
            int character = (int) (Math.random() * randomInt.length());

            builder.append(randomInt.charAt(character));
            String out = builder.toString();
        }
        return builder.toString();
    }

    public void SendPushNotification(String title, String msg, String phone) {
        try {
            Pushraven.setCredential(new File("google-services.json"));
            Pushraven.setProjectId("shebnksapp");

            Notification not = new Notification()
                    .title(title)
                    .body(msg);

            AndroidConfig droidCfg = new AndroidConfig()
                    .notification(
                            new AndroidNotification()
                                    .color("#ff0000")
                    )

                    .ttl(1800)
                    .priority(AndroidConfig.Priority.HIGH);


            UserModel model = userRepository.findByMobileNumber(phone)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with phone: " + phone));

            Message raven = new Message()


                    .notification(not)
                    .token(model.getMessagingToken()) // could instead use: topic(String) or condition(String)
                    .android(droidCfg);


            FcmResponse response = Pushraven.push(raven);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkInstantPayPreconditions(
            LipaNaMpesaShortCode shortCode, LipaNaMpesaPasskey passkey) {
        checkNotNull(shortCode, "LipaNaMpesa shortcode missing");
        checkEmptyString(shortCode.getValue(), "LipaNaMpesa shortcode missing");
        checkNotNull(passkey, "LipaNaMpesa passkey missing");
        checkEmptyString(passkey.getValue(), "LipaNaMpesa passkey missing");
    }

    public static void checkInitiatorPreconditions(
            String name, String shortCode, String securityCredential) {
        checkNotNull(name, "Initiator name missing");
        checkEmptyString(name, "Initiator name missing");
        checkNotNull(shortCode, "Initiator code missing");
        checkEmptyString(shortCode, "Initiator code missing");
        checkNotNull(securityCredential, "Initiator security credential missing");
        checkEmptyString(securityCredential, "Initiator security credential missing");
    }

    public static String sanitizePhone(String phone) {
        if (phone.contains("-")) {
            phone = phone.replace("-", "");
        }
        if (phone.length() == 10 && phone.startsWith("0") && phone.charAt(1) == '7') {
            phone = "2547" + phone.substring(2, 10);
        }
        if (phone.length() == 10 && phone.startsWith("0") && phone.charAt(1) == '1') {
            phone = "2541" + phone.substring(2, 10);
        }
        if (phone.length() == 13 && phone.startsWith("+")) {
            phone = "" + phone.substring(1, 13);
        }

        return phone;
    }

    public static void LogResult(String user, String body) {

        //TODO
    }

    public static String formatedAmount(String _amount) {
        double amount = Double.parseDouble(_amount);

        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        amount = Double.parseDouble(df.format(amount));

        return String.format("%.2f", amount);
    }

    public static String getErrorCodeString( int statusCode)  {

        String message;

        message =
                Match(statusCode)
                        .of(
                                Case($(BAD_REQUEST), "Oops! Bad Request"),
                                Case(
                                        $(UNAUTHORIZED),
                                        "Invalid or missing authentication credentials. Ensure that you have set valid consumer key/secret and the system clock is in sync."),
                                Case($(FORBIDDEN), "The request is understood, but it has been refused."),
                                Case(
                                        $(NOT_FOUND),
                                        "The URI requested is invalid or the resource requested. Also returned when the requested format is not supported by the requested method."),
                                Case($(METHOD_NOT_ALLOWED), "The request is not allowed."),
                                Case(
                                        $(NOT_ACCEPTABLE),
                                        "The request is not acceptable. Probably requested a format that is not json."),
                                Case(
                                        $(TOO_MANY_REQUESTS),
                                        "Returned when a request cannot be served due to the application's rate limit having been exhausted for the resource."),
                                Case(
                                        $(INTERNAL_SERVER_ERROR),
                                        "Something is broken. Please post to the group (https://developer.safaricom.co.ke/) so the Safaricom Daraja team can investigate."),
                                Case($(SERVICE_UNAVAILABLE), "Service unavailable. Try again later."),
                                Case($(), ""));
        return message;

    }
}




