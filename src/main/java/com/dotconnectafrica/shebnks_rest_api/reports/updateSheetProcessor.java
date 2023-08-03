package com.dotconnectafrica.shebnks_rest_api.reports;

import com.dotconnectafrica.shebnks_rest_api.models.updateDataToSpreadSheetModel;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class updateSheetProcessor {
    private static final String CREDENTIALS_FILE_PATH = "/client_secret.json";
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String APPLICATION_NAME = "Google Sheets API";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "/home/charles/tokens";
    public updateSheetProcessor() {
    }

    public  void updateApplicationToSheet(updateDataToSpreadSheetModel dataDetails) throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        //final String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
        final String spreadsheetId = "1TvF9LNOFgKI_MjezjkZ9LEd-UYhuykNIBukeBdrbBw0";
        final String range = "Sheet1!A2:S2";
        System.out.println("the tokesn are "+ updateSheetProcessor.class.getResource(TOKENS_DIRECTORY_PATH));
        List<List<Object>>updateValue=new ArrayList<>();
        List<Object>data=new ArrayList<>();
        data.add(dataDetails.getDate());
        data.add(dataDetails.getPhone());
        data.add(dataDetails.getCode());
        data.add(dataDetails.getAmount());
        data.add(dataDetails.getInterest());

        data.add(dataDetails.getLoanBalance());
        data.add(dataDetails.getAmountPaid());
        data.add(dataDetails.getInterestPaid());
        data.add(dataDetails.getPrinciplePaid());
        data.add(dataDetails.getLastPaidDate());
        data.add(dataDetails.getLoanDisbursement());
        data.add(dataDetails.getLoanStatus());

        data.add(dataDetails.getNameCategory());
        String denyLink="Deny loan";
        String awardLink="grant loan";
        String denyLinkFull= MessageFormat.format("=HYPERLINK('{0}','{1}')", dataDetails.getDisburseLoanLink(), awardLink);
        String awardLinkFull= MessageFormat.format("=HYPERLINK('{0}','{1}')", dataDetails.getDenyLoanLink(), denyLink);
        JSONObject jsonObject1=new JSONObject();
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("formulaValue","=HYPERLINK(\"wwww.google.com\",\"google\")");
        jsonObject1.put("userEnteredValue",jsonObject);
        data.add(dataDetails.getDisburseLoanLink());
        data.add(dataDetails.getDenyLoanLink());



        data.add(dataDetails.getDueDate());
        data.add(dataDetails.getDateGiven());
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
updateValue.add(data);
        ValueRange body = new ValueRange()
                .setValues(updateValue);
        AppendValuesResponse result =
                service.spreadsheets().values().append(spreadsheetId, "Sheet1", body)
                        .setValueInputOption("USER_ENTERED")
                        .setInsertDataOption("INSERT_ROWS")

                        .execute();
        System.out.printf("%d cells appended.", result.getUpdates().getUpdatedCells());


//                ValueRange response = service.spreadsheets().values()
//                .get(spreadsheetId, range)
//                .execute();
//        List<List<Object>> values = response.getValues();
//        if (values == null || values.isEmpty()) {
//            System.out.println("No data found.");
//        } else {
//
//            for (List row : values) {
//                // Print columns A and E, which correspond to indices 0 and 4.
//                System.out.printf(row.toString());
//            }
//        }
    }
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = updateSheetProcessor.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(33787).build();
        return new AuthorizationCodeInstalledApp(flow,receiver).authorize("user");
    }


}
