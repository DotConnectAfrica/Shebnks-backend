package com.dotconnectafrica.shebnks_rest_api.Utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jac
 */



import com.dotconnectafrica.shebnks_rest_api.contants.AppConstants;

import java.util.Properties;

public class EmailHandler {
    
    
    
    public EmailHandler()
    {
        
    }




    public void sendEmail(String recipientEmail,String subject,String mesg){
        String hostname = "smtpout.secureserver.net";
        final String username = AppConstants.EMAIL_USERNAME;
        final String password = AppConstants.EMAIL_PASSWORD;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.host", hostname);
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");

        jakarta.mail.Authenticator auth = new jakarta.mail.Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(username, password);
            }
        };

        jakarta.mail.Session session = jakarta.mail.Session.getInstance(props, auth);

        try {
            jakarta.mail.internet.MimeMessage msg = new jakarta.mail.internet.MimeMessage(session);
            msg.setFrom(new jakarta.mail.internet.InternetAddress(username));
            jakarta.mail.internet.InternetAddress[] address = {new jakarta.mail.internet.InternetAddress(recipientEmail)};
            msg.setRecipients(jakarta.mail.Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.addHeader("x-cloudmta-class", "standard");
            msg.addHeader("x-cloudmta-tags", "demo, example");
            msg.setContent(mesg, "text/html; charset=utf-8");

            jakarta.mail.Transport.send(msg);


        } catch (jakarta.mail.MessagingException ex) {
            throw new RuntimeException(ex);
        }

    }
    

 
    public static void main(String[] args) 
    {



        new EmailHandler().sendEmail("muchpaul2@gmail.com", "Test Subject","Email is working!"); ;
    }
    
}
