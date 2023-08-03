package com.dotconnectafrica.shebnks_rest_api.contants;

public class seedFundConstants {
    public static int CURRENT_SEEDFUND_YEAR=2021;
    public static String INITIAL_SIGN_IN_TOKEN="eyJhbGciOiJSUzI1NiIsImtpZCI6IjFiYjk2MDVjMzZlOThlMzAxMTdhNjk1MTc1NjkzODY4MzAyMDJiMmQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vc2hlYm5rc2FwcCIsImF1ZCI6InNoZWJua3NhcHAiLCJhdXRoX3RpbWUiOjE2Mjc1NzA0NzIsInVzZXJfaWQiOiJiNmFFQnlBRjNIZEFIc2JETTlxVXF1dUppZnYxIiwic3ViIjoiYjZhRUJ5QUYzSGRBSHNiRE05cVVxdXVKaWZ2MSIsImlhdCI6MTYyNzU3MDQ3MiwiZXhwIjoxNjI3NTc0MDcyLCJlbWFpbCI6InBhdWxvYmllcm8xNDdAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7ImVtYWlsIjpbInBhdWxvYmllcm8xNDdAZ21haWwuY29tIl19LCJzaWduX2luX3Byb3ZpZGVyIjoicGFzc3dvcmQifX0.UFBBhmSXcEMj01z1P2YqEwuaUxDBCwJQB8vFCnllGOjAj17IAxnJwg_x9Lr8TyXoPAotCauQwULfMWKH4KqjFTSroDfzvVGf6YaOYIVFGiwySEadmb5EyuT9MhMpw1SRsUvnYYMmJaId890L-OF1_f9Z1r8Nm_9Ze7YhV3UtVePccHe5dU2DpnmIPdmvceDO9N3LOVwMzsVbw_d55eltm4gnbKfxRaSdaCUDZ0Ee3RxSJHyo8FV0fdLpbb8glsxpIJHbET0ISqXecWdCuDX9QsKcbhe1R3PNYc3W4KjXiBQmwD8ak892nZt3XxFwq2ghXHdNKTbIzeDUTr2KoB4QoQ";
   public static String STATIC_CONTENT_URL="http://18.221.12.141:8080/seedfund/static/";
   public static String LINK_EXTENTION(String code,String amount)
   {
       return "http://18.221.12.141:8080/shebnks_war/api/LoanDisbursmentAPI?ApplicationCode="+code+"&token="+INITIAL_SIGN_IN_TOKEN+"&amount="+amount;
   }
    public static String EMAIL_VERIFICATION_STRING(String link, String title, String description, String imageDescription, String salutation, String buttonText)
    {
     return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
             "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
             "<head>\n" +
             "<!--[if gte mso 9]>\n" +
             "<xml>\n" +
             "  <o:OfficeDocumentSettings>\n" +
             "    <o:AllowPNG/>\n" +
             "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
             "  </o:OfficeDocumentSettings>\n" +
             "</xml>\n" +
             "<![endif]-->\n" +
             "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
             "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
             "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
             "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
             "  <title></title>\n" +
             "  \n" +
             "    <style type=\"text/css\">\n" +
             "      table, td { color: #000000; } a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_image_3 .v-src-width { width: 183px !important; } #u_content_image_3 .v-src-max-width { max-width: 35% !important; } #u_content_image_2 .v-src-width { width: 479px !important; } #u_content_image_2 .v-src-max-width { max-width: 55% !important; } #u_content_image_5 .v-container-padding-padding { padding: 30px 10px 10px !important; } #u_content_image_5 .v-src-width { width: 540px !important; } #u_content_image_5 .v-src-max-width { max-width: 45% !important; } #u_content_image_5 .v-text-align { text-align: center !important; } #u_content_image_4 .v-container-padding-padding { padding: 10px 10px 30px !important; } #u_content_image_4 .v-src-width { width: 540px !important; } #u_content_image_4 .v-src-max-width { max-width: 45% !important; } #u_content_image_4 .v-text-align { text-align: center !important; } #u_content_menu_1 .v-container-padding-padding { padding: 10px !important; } }\n" +
             "@media only screen and (min-width: 570px) {\n" +
             "  .u-row {\n" +
             "    width: 550px !important;\n" +
             "  }\n" +
             "  .u-row .u-col {\n" +
             "    vertical-align: top;\n" +
             "  }\n" +
             "\n" +
             "  .u-row .u-col-50 {\n" +
             "    width: 275px !important;\n" +
             "  }\n" +
             "\n" +
             "  .u-row .u-col-100 {\n" +
             "    width: 550px !important;\n" +
             "  }\n" +
             "\n" +
             "}\n" +
             "\n" +
             "@media (max-width: 570px) {\n" +
             "  .u-row-container {\n" +
             "    max-width: 100% !important;\n" +
             "    padding-left: 0px !important;\n" +
             "    padding-right: 0px !important;\n" +
             "  }\n" +
             "  .u-row .u-col {\n" +
             "    min-width: 320px !important;\n" +
             "    max-width: 100% !important;\n" +
             "    display: block !important;\n" +
             "  }\n" +
             "  .u-row {\n" +
             "    width: calc(100% - 40px) !important;\n" +
             "  }\n" +
             "  .u-col {\n" +
             "    width: 100% !important;\n" +
             "  }\n" +
             "  .u-col > div {\n" +
             "    margin: 0 auto;\n" +
             "  }\n" +
             "}\n" +
             "body {\n" +
             "  margin: 0;\n" +
             "  padding: 0;\n" +
             "}\n" +
             "\n" +
             "table,\n" +
             "tr,\n" +
             "td {\n" +
             "  vertical-align: top;\n" +
             "  border-collapse: collapse;\n" +
             "}\n" +
             "\n" +
             "p {\n" +
             "  margin: 0;\n" +
             "}\n" +
             "\n" +
             ".ie-container table,\n" +
             ".mso-container table {\n" +
             "  table-layout: fixed;\n" +
             "}\n" +
             "\n" +
             "* {\n" +
             "  line-height: inherit;\n" +
             "}\n" +
             "\n" +
             "a[x-apple-data-detectors='true'] {\n" +
             "  color: inherit !important;\n" +
             "  text-decoration: none !important;\n" +
             "}\n" +
             "\n" +
             "@media (max-width: 480px) {\n" +
             "  .hide-mobile {\n" +
             "    display: none !important;\n" +
             "    max-height: 0px;\n" +
             "    overflow: hidden;\n" +
             "  }\n" +
             "\n" +
             "}\n" +
             "    </style>\n" +
             "  \n" +
             "  \n" +
             "\n" +
             "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
             "\n" +
             "</head>\n" +
             "\n" +
             "<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #e0e5eb;color: #000000\">\n" +
             "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
             "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
             "  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #e0e5eb;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
             "  <tbody>\n" +
             "  <tr style=\"vertical-align: top\">\n" +
             "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
             "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #e0e5eb;\"><![endif]-->\n" +
             "    \n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 0px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
             "    <tbody>\n" +
             "      <tr style=\"vertical-align: top\">\n" +
             "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
             "          <span>&#160;</span>\n" +
             "        </td>\n" +
             "      </tr>\n" +
             "    </tbody>\n" +
             "  </table>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #d5827c;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #d5827c;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"background-color: #edecf5;width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"background-color: #edecf5;width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table id=\"u_content_image_3\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
             "  <tr>\n" +
             "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
             "      \n" +
             "      <img align=\"center\" border=\"0\" src=\""+STATIC_CONTENT_URL+"images/image-1.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 26%;max-width: 137.8px;\" width=\"137.8\" class=\"v-src-width v-src-max-width\"/>\n" +
             "      \n" +
             "    </td>\n" +
             "  </tr>\n" +
             "</table>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #d5827c;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #d5827c;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"background-color: #edecf5;width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"background-color: #edecf5;width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:15px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #000000; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: book antiqua,palatino; font-size: 35px;\">\n" +
             salutation+"\n" +
             "  </h1>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "  <h3 class=\"v-text-align\" style=\"margin: 0px; color: #0a0a0a; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: book antiqua,palatino; font-size: 18px;\">\n" +
                description+"\n" +
             "  </h3>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #d5827c;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #d5827c;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"background-color: #edecf5;width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"background-color: #edecf5;width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table id=\"u_content_image_2\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
             "  <tr>\n" +
             "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
             "      \n" +
             "      <img align=\"center\" border=\"0\" src=\""+STATIC_CONTENT_URL+"images/image-8.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 39%;max-width: 206.7px;\" width=\"206.7\" class=\"v-src-width v-src-max-width\"/>\n" +
             "      \n" +
             "    </td>\n" +
             "  </tr>\n" +
             "</table>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 40px 20px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "  <div class=\"v-text-align\" style=\"color: #4b4a4a; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
             "    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 12px; line-height: 16.8px;\">"+imageDescription+"</span></p>\n" +
             "  </div>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "<div class=\"v-text-align\" align=\"center\">\n" +
             "  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;font-family:'Lato',sans-serif;\"><tr><td class=\"v-text-align\" style=\"font-family:'Lato',sans-serif;\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"\" style=\"height:39px; v-text-anchor:middle; width:186px;\" arcsize=\"2.5%\" strokecolor=\"#CCC\" strokeweight=\"3px\" fillcolor=\"#ffffff\"><w:anchorlock/><center style=\"color:#000000;font-family:'Lato',sans-serif;\"><![endif]-->\n" +
             "    <a href=\""+link+"\" target=\"_blank\" style=\"box-sizing: border-box;display: inline-block;font-family:'Lato',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #000000; background-color: #ffffff; border-radius: 1px; -webkit-border-radius: 1px; -moz-border-radius: 1px; width:auto; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;border-top-color: #CCC; border-top-style: solid; border-top-width: 3px; border-left-color: #CCC; border-left-style: solid; border-left-width: 3px; border-right-color: #CCC; border-right-style: solid; border-right-width: 3px; border-bottom-color: #CCC; border-bottom-style: solid; border-bottom-width: 3px;\">\n" +
             "      <span style=\"display:block;padding:10px 30px;line-height:120%;\"><span style=\"font-size: 16px; line-height: 19.2px; font-family: Lato, sans-serif;\">"+buttonText+"</span></span>\n" +
             "    </a>\n" +
             "  <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\n" +
             "</div>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #eef2f5;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #eef2f5;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 0px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
             "    <tbody>\n" +
             "      <tr style=\"vertical-align: top\">\n" +
             "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
             "          <span>&#160;</span>\n" +
             "        </td>\n" +
             "      </tr>\n" +
             "    </tbody>\n" +
             "  </table>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #eef2f5;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #eef2f5;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"275\" style=\"width: 275px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 275px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table id=\"u_content_image_5\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 20px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
             "  <tr>\n" +
             "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"right\">\n" +
             "      \n" +
             "      <img align=\"right\" border=\"0\" src=\""+STATIC_CONTENT_URL+"images/image-7.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 57%;max-width: 139.65px;\" width=\"139.65\" class=\"v-src-width v-src-max-width\"/>\n" +
             "      \n" +
             "    </td>\n" +
             "  </tr>\n" +
             "</table>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"275\" style=\"width: 275px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 275px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table id=\"u_content_image_4\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 20px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
             "  <tr>\n" +
             "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"left\">\n" +
             "      \n" +
             "      <img align=\"left\" border=\"0\" src=\""+STATIC_CONTENT_URL+"images/image-3.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 57%;max-width: 133.95px;\" width=\"133.95\" class=\"v-src-width v-src-max-width\"/>\n" +
             "      \n" +
             "    </td>\n" +
             "  </tr>\n" +
             "</table>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #eef2f5;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #eef2f5;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 0px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
             "    <tbody>\n" +
             "      <tr style=\"vertical-align: top\">\n" +
             "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
             "          <span>&#160;</span>\n" +
             "        </td>\n" +
             "      </tr>\n" +
             "    </tbody>\n" +
             "  </table>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "<div align=\"center\">\n" +
             "  <div style=\"display: table; max-width:167px;\">\n" +
             "  <!--[if (mso)|(IE)]><table width=\"167\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:167px;\"><tr><![endif]-->\n" +
             "  \n" +
             "    \n" +
             "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
             "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
             "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
             "        <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\n" +
             "          <img src=\""+STATIC_CONTENT_URL+"images/image-2.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
             "        </a>\n" +
             "      </td></tr>\n" +
             "    </tbody></table>\n" +
             "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "    \n" +
             "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
             "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
             "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
             "        <a href=\"https://twitter.com/\" title=\"Twitter\" target=\"_blank\">\n" +
             "          <img src=\""+STATIC_CONTENT_URL+"images/image-6.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
             "        </a>\n" +
             "      </td></tr>\n" +
             "    </tbody></table>\n" +
             "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "    \n" +
             "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
             "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
             "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
             "        <a href=\"https://linkedin.com/\" title=\"LinkedIn\" target=\"_blank\">\n" +
             "          <img src=\""+STATIC_CONTENT_URL+"images/image-4.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
             "        </a>\n" +
             "      </td></tr>\n" +
             "    </tbody></table>\n" +
             "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "    \n" +
             "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
             "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
             "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
             "        <a href=\"https://instagram.com/\" title=\"Instagram\" target=\"_blank\">\n" +
             "          <img src=\""+STATIC_CONTENT_URL+"images/image-5.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
             "        </a>\n" +
             "      </td></tr>\n" +
             "    </tbody></table>\n" +
             "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "    \n" +
             "    \n" +
             "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table id=\"u_content_menu_1\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "<div class=\"menu\" style=\"text-align:center\">\n" +
             "<!--[if (mso)|(IE)]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"><tr><![endif]-->\n" +
             "\n" +
             "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
             "  \n" +
             "  <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\">\n" +
             "    About Us\n" +
             "  </span>\n" +
             "  \n" +
             "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "  \n" +
             "    <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
             "    <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\" class=\"hide-mobile\">\n" +
             "      |\n" +
             "    </span>\n" +
             "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "  \n" +
             "\n" +
             "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
             "  \n" +
             "  <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\">\n" +
             "    Contact Us\n" +
             "  </span>\n" +
             "  \n" +
             "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "  \n" +
             "    <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
             "    <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\" class=\"hide-mobile\">\n" +
             "      |\n" +
             "    </span>\n" +
             "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "  \n" +
             "\n" +
             "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
             "  \n" +
             "  <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\">\n" +
             "    Help center\n" +
             "  </span>\n" +
             "  \n" +
             "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "  \n" +
             "\n" +
             "<!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
             "</div>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 15px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "  <div class=\"v-text-align\" style=\"color: #7e8c8d; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
             "    <p style=\"font-size: 14px; line-height: 140%;\">&copy; SheBanks @2021. All Rights Reserved.</p>\n" +
             "  </div>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "\n" +
             "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
             "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
             "    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
             "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
             "      \n" +
             "<!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
             "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
             "  <div style=\"width: 100% !important;\">\n" +
             "  <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
             "  \n" +
             "<table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
             "  <tbody>\n" +
             "    <tr>\n" +
             "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
             "        \n" +
             "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 0px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
             "    <tbody>\n" +
             "      <tr style=\"vertical-align: top\">\n" +
             "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
             "          <span>&#160;</span>\n" +
             "        </td>\n" +
             "      </tr>\n" +
             "    </tbody>\n" +
             "  </table>\n" +
             "\n" +
             "      </td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>\n" +
             "\n" +
             "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
             "  </div>\n" +
             "</div>\n" +
             "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
             "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
             "    </div>\n" +
             "  </div>\n" +
             "</div>\n" +
             "\n" +
             "\n" +
             "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
             "    </td>\n" +
             "  </tr>\n" +
             "  </tbody>\n" +
             "  </table>\n" +
             "  <!--[if mso]></div><![endif]-->\n" +
             "  <!--[if IE]></div><![endif]-->\n" +
             "</body>\n" +
             "\n" +
             "</html>";
    }
    public static String EMAIL_VERIFICATION_LINK(String link,String name){
       return "<!doctype html>\n" +
               "<html>\n" +
               "<head>\n" +
               "  <meta name=\"viewport\" content=\"width=device-width\" />\n" +
               "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
               "  <title>Simple Transactional Email</title>\n" +
               "  <style>\n" +
               "    /* -------------------------------------\n" +
               "        GLOBAL RESETS\n" +
               "    ------------------------------------- */\n" +
               "\n" +
               "    /*All the styling goes here*/\n" +
               "\n" +
               "    img {\n" +
               "      border: none;\n" +
               "      -ms-interpolation-mode: bicubic;\n" +
               "      max-width: 100%;\n" +
               "    }\n" +
               "\n" +
               "    body {\n" +
               "      background-color: #f6f6f6;\n" +
               "      font-family: sans-serif;\n" +
               "      -webkit-font-smoothing: antialiased;\n" +
               "      font-size: 14px;\n" +
               "      line-height: 1.4;\n" +
               "      margin: 0;\n" +
               "      padding: 0;\n" +
               "      -ms-text-size-adjust: 100%;\n" +
               "      -webkit-text-size-adjust: 100%;\n" +
               "    }\n" +
               "\n" +
               "    table {\n" +
               "      border-collapse: separate;\n" +
               "      mso-table-lspace: 0pt;\n" +
               "      mso-table-rspace: 0pt;\n" +
               "      width: 100%; }\n" +
               "    table td {\n" +
               "      font-family: sans-serif;\n" +
               "      font-size: 14px;\n" +
               "      vertical-align: top;\n" +
               "    }\n" +
               "\n" +
               "    /* -------------------------------------\n" +
               "        BODY & CONTAINER\n" +
               "    ------------------------------------- */\n" +
               "\n" +
               "    .body {\n" +
               "      background-color: #f6f6f6;\n" +
               "      width: 100%;\n" +
               "    }\n" +
               "\n" +
               "    /* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n" +
               "    .container {\n" +
               "      display: block;\n" +
               "      margin: 0 auto !important;\n" +
               "      /* makes it centered */\n" +
               "      max-width: 580px;\n" +
               "      padding: 10px;\n" +
               "      width: 580px;\n" +
               "    }\n" +
               "\n" +
               "    /* This should also be a block element, so that it will fill 100% of the .container */\n" +
               "    .content {\n" +
               "      box-sizing: border-box;\n" +
               "      display: block;\n" +
               "      margin: 0 auto;\n" +
               "      max-width: 580px;\n" +
               "      padding: 10px;\n" +
               "    }\n" +
               "\n" +
               "    /* -------------------------------------\n" +
               "        HEADER, FOOTER, MAIN\n" +
               "    ------------------------------------- */\n" +
               "    .main {\n" +
               "      background: #ffffff;\n" +
               "      border-radius: 3px;\n" +
               "      width: 100%;\n" +
               "    }\n" +
               "\n" +
               "    .wrapper {\n" +
               "      box-sizing: border-box;\n" +
               "      padding: 20px;\n" +
               "    }\n" +
               "\n" +
               "    .content-block {\n" +
               "      padding-bottom: 10px;\n" +
               "      padding-top: 10px;\n" +
               "    }\n" +
               "\n" +
               "    .footer {\n" +
               "      clear: both;\n" +
               "      margin-top: 10px;\n" +
               "      text-align: center;\n" +
               "      width: 100%;\n" +
               "    }\n" +
               "    .footer td,\n" +
               "    .footer p,\n" +
               "    .footer span,\n" +
               "    .footer a {\n" +
               "      color: #999999;\n" +
               "      font-size: 12px;\n" +
               "      text-align: center;\n" +
               "    }\n" +
               "\n" +
               "    /* -------------------------------------\n" +
               "        TYPOGRAPHY\n" +
               "    ------------------------------------- */\n" +
               "    h1,\n" +
               "    h2,\n" +
               "    h3,\n" +
               "    h4 {\n" +
               "      color: #000000;\n" +
               "      font-family: sans-serif;\n" +
               "      font-weight: 400;\n" +
               "      line-height: 1.4;\n" +
               "      margin: 0;\n" +
               "      margin-bottom: 30px;\n" +
               "    }\n" +
               "\n" +
               "    h1 {\n" +
               "      font-size: 35px;\n" +
               "      font-weight: 300;\n" +
               "      text-align: center;\n" +
               "      text-transform: capitalize;\n" +
               "    }\n" +
               "\n" +
               "    p,\n" +
               "    ul,\n" +
               "    ol {\n" +
               "      font-family: sans-serif;\n" +
               "      font-size: 14px;\n" +
               "      font-weight: normal;\n" +
               "      margin: 0;\n" +
               "      margin-bottom: 15px;\n" +
               "    }\n" +
               "    p li,\n" +
               "    ul li,\n" +
               "    ol li {\n" +
               "      list-style-position: inside;\n" +
               "      margin-left: 5px;\n" +
               "    }\n" +
               "\n" +
               "    a {\n" +
               "      color: #3498db;\n" +
               "      text-decoration: underline;\n" +
               "    }\n" +
               "\n" +
               "    /* -------------------------------------\n" +
               "        BUTTONS\n" +
               "    ------------------------------------- */\n" +
               "    .btn {\n" +
               "      box-sizing: border-box;\n" +
               "      width: 100%; }\n" +
               "    .btn > tbody > tr > td {\n" +
               "      padding-bottom: 15px; }\n" +
               "    .btn table {\n" +
               "      width: auto;\n" +
               "    }\n" +
               "    .btn table td {\n" +
               "      background-color: #ffffff;\n" +
               "      border-radius: 5px;\n" +
               "      text-align: center;\n" +
               "    }\n" +
               "    .btn a {\n" +
               "      background-color: #ffffff;\n" +
               "      border: solid 1px #3498db;\n" +
               "      border-radius: 5px;\n" +
               "      box-sizing: border-box;\n" +
               "      color: #3498db;\n" +
               "      cursor: pointer;\n" +
               "      display: inline-block;\n" +
               "      font-size: 14px;\n" +
               "      font-weight: bold;\n" +
               "      margin: 0;\n" +
               "      padding: 12px 25px;\n" +
               "      text-decoration: none;\n" +
               "      text-transform: capitalize;\n" +
               "    }\n" +
               "\n" +
               "    .btn-primary table td {\n" +
               "      background-color: #3498db;\n" +
               "    }\n" +
               "\n" +
               "    .btn-primary a {\n" +
               "      background-color: #3498db;\n" +
               "      border-color: #3498db;\n" +
               "      color: #ffffff;\n" +
               "    }\n" +
               "\n" +
               "    /* -------------------------------------\n" +
               "        OTHER STYLES THAT MIGHT BE USEFUL\n" +
               "    ------------------------------------- */\n" +
               "    .last {\n" +
               "      margin-bottom: 0;\n" +
               "    }\n" +
               "\n" +
               "    .first {\n" +
               "      margin-top: 0;\n" +
               "    }\n" +
               "\n" +
               "    .align-center {\n" +
               "      text-align: center;\n" +
               "    }\n" +
               "\n" +
               "    .align-right {\n" +
               "      text-align: right;\n" +
               "    }\n" +
               "\n" +
               "    .align-left {\n" +
               "      text-align: left;\n" +
               "    }\n" +
               "\n" +
               "    .clear {\n" +
               "      clear: both;\n" +
               "    }\n" +
               "\n" +
               "    .mt0 {\n" +
               "      margin-top: 0;\n" +
               "    }\n" +
               "\n" +
               "    .mb0 {\n" +
               "      margin-bottom: 0;\n" +
               "    }\n" +
               "\n" +
               "    .preheader {\n" +
               "      color: transparent;\n" +
               "      display: none;\n" +
               "      height: 0;\n" +
               "      max-height: 0;\n" +
               "      max-width: 0;\n" +
               "      opacity: 0;\n" +
               "      overflow: hidden;\n" +
               "      mso-hide: all;\n" +
               "      visibility: hidden;\n" +
               "      width: 0;\n" +
               "    }\n" +
               "\n" +
               "    .powered-by a {\n" +
               "      text-decoration: none;\n" +
               "    }\n" +
               "\n" +
               "    hr {\n" +
               "      border: 0;\n" +
               "      border-bottom: 1px solid #f6f6f6;\n" +
               "      margin: 20px 0;\n" +
               "    }\n" +
               "\n" +
               "    /* -------------------------------------\n" +
               "        RESPONSIVE AND MOBILE FRIENDLY STYLES\n" +
               "    ------------------------------------- */\n" +
               "    @media only screen and (max-width: 620px) {\n" +
               "      table[class=body] h1 {\n" +
               "        font-size: 28px !important;\n" +
               "        margin-bottom: 10px !important;\n" +
               "      }\n" +
               "      table[class=body] p,\n" +
               "      table[class=body] ul,\n" +
               "      table[class=body] ol,\n" +
               "      table[class=body] td,\n" +
               "      table[class=body] span,\n" +
               "      table[class=body] a {\n" +
               "        font-size: 16px !important;\n" +
               "      }\n" +
               "      table[class=body] .wrapper,\n" +
               "      table[class=body] .article {\n" +
               "        padding: 10px !important;\n" +
               "      }\n" +
               "      table[class=body] .content {\n" +
               "        padding: 0 !important;\n" +
               "      }\n" +
               "      table[class=body] .container {\n" +
               "        padding: 0 !important;\n" +
               "        width: 100% !important;\n" +
               "      }\n" +
               "      table[class=body] .main {\n" +
               "        border-left-width: 0 !important;\n" +
               "        border-radius: 0 !important;\n" +
               "        border-right-width: 0 !important;\n" +
               "      }\n" +
               "      table[class=body] .btn table {\n" +
               "        width: 100% !important;\n" +
               "      }\n" +
               "      table[class=body] .btn a {\n" +
               "        width: 100% !important;\n" +
               "      }\n" +
               "      table[class=body] .img-responsive {\n" +
               "        height: auto !important;\n" +
               "        max-width: 100% !important;\n" +
               "        width: auto !important;\n" +
               "      }\n" +
               "    }\n" +
               "\n" +
               "    /* -------------------------------------\n" +
               "        PRESERVE THESE STYLES IN THE HEAD\n" +
               "    ------------------------------------- */\n" +
               "    @media all {\n" +
               "      .ExternalClass {\n" +
               "        width: 100%;\n" +
               "      }\n" +
               "      .ExternalClass,\n" +
               "      .ExternalClass p,\n" +
               "      .ExternalClass span,\n" +
               "      .ExternalClass font,\n" +
               "      .ExternalClass td,\n" +
               "      .ExternalClass div {\n" +
               "        line-height: 100%;\n" +
               "      }\n" +
               "      .apple-link a {\n" +
               "        color: inherit !important;\n" +
               "        font-family: inherit !important;\n" +
               "        font-size: inherit !important;\n" +
               "        font-weight: inherit !important;\n" +
               "        line-height: inherit !important;\n" +
               "        text-decoration: none !important;\n" +
               "      }\n" +
               "      #MessageViewBody a {\n" +
               "        color: inherit;\n" +
               "        text-decoration: none;\n" +
               "        font-size: inherit;\n" +
               "        font-family: inherit;\n" +
               "        font-weight: inherit;\n" +
               "        line-height: inherit;\n" +
               "      }\n" +
               "      .btn-primary table td:hover {\n" +
               "        background-color: #34495e !important;\n" +
               "      }\n" +
               "      .btn-primary a:hover {\n" +
               "        background-color: #34495e !important;\n" +
               "        border-color: #34495e !important;\n" +
               "      }\n" +
               "    }\n" +
               "\n" +
               "  </style>\n" +
               "</head>\n" +
               "<body class=\"\">\n" +
               "<span class=\"preheader\">Verify your SHEBnks account</span>\n" +
               "<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\">\n" +
               "  <tr>\n" +
               "    <td>&nbsp;</td>\n" +
               "    <td class=\"container\">\n" +
               "      <div class=\"content\">\n" +
               "\n" +
               "        <!-- START CENTERED WHITE CONTAINER -->\n" +
               "        <table role=\"presentation\" class=\"main\">\n" +
               "\n" +
               "          <!-- START MAIN CONTENT AREA -->\n" +
               "          <tr>\n" +
               "            <td class=\"wrapper\">\n" +
               "              <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
               "                <tr>\n" +
               "                  <td>\n" +
               "                    <p>Hi "+name+",</p>\n" +
               "                    <p>We have sent you an email verification link so that we can verify your possesion of the email</p>\n" +
               "                    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\">\n" +
               "                      <tbody>\n" +
               "                      <tr>\n" +
               "                        <td align=\"left\">\n" +
               "                          <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
               "                            <tbody>\n" +
               "                            <tr>\n" +
               "                              <td> <a href=\""+link+"\" target=\"_blank\">Verify account</a> </td>\n" +
               "                            </tr>\n" +
               "                            </tbody>\n" +
               "                          </table>\n" +
               "                        </td>\n" +
               "                      </tr>\n" +
               "                      </tbody>\n" +
               "                    </table>\n" +
               "                    <p>Good luck! Hope it works.</p>\n" +
               "                  </td>\n" +
               "                </tr>\n" +
               "              </table>\n" +
               "            </td>\n" +
               "          </tr>\n" +
               "\n" +
               "          <!-- END MAIN CONTENT AREA -->\n" +
               "        </table>\n" +
               "        <!-- END CENTERED WHITE CONTAINER -->\n" +
               "\n" +
               "        <!-- START FOOTER -->\n" +
               "        <div class=\"footer\">\n" +
               "          <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
               "            <tr>\n" +
               "              <td class=\"content-block\">\n" +
               "                <span class=\"apple-link\">CIC Plaza, Ground floor, Mara Road Upper Hill</span>\n" +
               "\n" +
               "               </td>\n" +
               "            </tr>\n" +
               "            <tr>\n" +
               "              <td class=\"content-block powered-by\">\n" +
               "                Powered by <a href=\"http://shebnks.mobi\">SHEBnks</a>.\n" +
               "              </td>\n" +
               "            </tr>\n" +
               "          </table>\n" +
               "        </div>\n" +
               "        <!-- END FOOTER -->\n" +
               "\n" +
               "      </div>\n" +
               "    </td>\n" +
               "    <td>&nbsp;</td>\n" +
               "  </tr>\n" +
               "</table>\n" +
               "</body>\n" +
               "</html>";
    }
    public static String PASSWORD_RESET_LINK(String link,String name){
        return "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta name=\"viewport\" content=\"width=device-width\" />\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "  <title>Simple Transactional Email</title>\n" +
                "  <style>\n" +
                "    /* -------------------------------------\n" +
                "        GLOBAL RESETS\n" +
                "    ------------------------------------- */\n" +
                "\n" +
                "    /*All the styling goes here*/\n" +
                "\n" +
                "    img {\n" +
                "      border: none;\n" +
                "      -ms-interpolation-mode: bicubic;\n" +
                "      max-width: 100%;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      background-color: #f6f6f6;\n" +
                "      font-family: sans-serif;\n" +
                "      -webkit-font-smoothing: antialiased;\n" +
                "      font-size: 14px;\n" +
                "      line-height: 1.4;\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "      -ms-text-size-adjust: 100%;\n" +
                "      -webkit-text-size-adjust: 100%;\n" +
                "    }\n" +
                "\n" +
                "    table {\n" +
                "      border-collapse: separate;\n" +
                "      mso-table-lspace: 0pt;\n" +
                "      mso-table-rspace: 0pt;\n" +
                "      width: 100%; }\n" +
                "    table td {\n" +
                "      font-family: sans-serif;\n" +
                "      font-size: 14px;\n" +
                "      vertical-align: top;\n" +
                "    }\n" +
                "\n" +
                "    /* -------------------------------------\n" +
                "        BODY & CONTAINER\n" +
                "    ------------------------------------- */\n" +
                "\n" +
                "    .body {\n" +
                "      background-color: #f6f6f6;\n" +
                "      width: 100%;\n" +
                "    }\n" +
                "\n" +
                "    /* Set a max-width, and make it display as block so it will automatically stretch to that width, but will also shrink down on a phone or something */\n" +
                "    .container {\n" +
                "      display: block;\n" +
                "      margin: 0 auto !important;\n" +
                "      /* makes it centered */\n" +
                "      max-width: 580px;\n" +
                "      padding: 10px;\n" +
                "      width: 580px;\n" +
                "    }\n" +
                "\n" +
                "    /* This should also be a block element, so that it will fill 100% of the .container */\n" +
                "    .content {\n" +
                "      box-sizing: border-box;\n" +
                "      display: block;\n" +
                "      margin: 0 auto;\n" +
                "      max-width: 580px;\n" +
                "      padding: 10px;\n" +
                "    }\n" +
                "\n" +
                "    /* -------------------------------------\n" +
                "        HEADER, FOOTER, MAIN\n" +
                "    ------------------------------------- */\n" +
                "    .main {\n" +
                "      background: #ffffff;\n" +
                "      border-radius: 3px;\n" +
                "      width: 100%;\n" +
                "    }\n" +
                "\n" +
                "    .wrapper {\n" +
                "      box-sizing: border-box;\n" +
                "      padding: 20px;\n" +
                "    }\n" +
                "\n" +
                "    .content-block {\n" +
                "      padding-bottom: 10px;\n" +
                "      padding-top: 10px;\n" +
                "    }\n" +
                "\n" +
                "    .footer {\n" +
                "      clear: both;\n" +
                "      margin-top: 10px;\n" +
                "      text-align: center;\n" +
                "      width: 100%;\n" +
                "    }\n" +
                "    .footer td,\n" +
                "    .footer p,\n" +
                "    .footer span,\n" +
                "    .footer a {\n" +
                "      color: #999999;\n" +
                "      font-size: 12px;\n" +
                "      text-align: center;\n" +
                "    }\n" +
                "\n" +
                "    /* -------------------------------------\n" +
                "        TYPOGRAPHY\n" +
                "    ------------------------------------- */\n" +
                "    h1,\n" +
                "    h2,\n" +
                "    h3,\n" +
                "    h4 {\n" +
                "      color: #000000;\n" +
                "      font-family: sans-serif;\n" +
                "      font-weight: 400;\n" +
                "      line-height: 1.4;\n" +
                "      margin: 0;\n" +
                "      margin-bottom: 30px;\n" +
                "    }\n" +
                "\n" +
                "    h1 {\n" +
                "      font-size: 35px;\n" +
                "      font-weight: 300;\n" +
                "      text-align: center;\n" +
                "      text-transform: capitalize;\n" +
                "    }\n" +
                "\n" +
                "    p,\n" +
                "    ul,\n" +
                "    ol {\n" +
                "      font-family: sans-serif;\n" +
                "      font-size: 14px;\n" +
                "      font-weight: normal;\n" +
                "      margin: 0;\n" +
                "      margin-bottom: 15px;\n" +
                "    }\n" +
                "    p li,\n" +
                "    ul li,\n" +
                "    ol li {\n" +
                "      list-style-position: inside;\n" +
                "      margin-left: 5px;\n" +
                "    }\n" +
                "\n" +
                "    a {\n" +
                "      color: #3498db;\n" +
                "      text-decoration: underline;\n" +
                "    }\n" +
                "\n" +
                "    /* -------------------------------------\n" +
                "        BUTTONS\n" +
                "    ------------------------------------- */\n" +
                "    .btn {\n" +
                "      box-sizing: border-box;\n" +
                "      width: 100%; }\n" +
                "    .btn > tbody > tr > td {\n" +
                "      padding-bottom: 15px; }\n" +
                "    .btn table {\n" +
                "      width: auto;\n" +
                "    }\n" +
                "    .btn table td {\n" +
                "      background-color: #ffffff;\n" +
                "      border-radius: 5px;\n" +
                "      text-align: center;\n" +
                "    }\n" +
                "    .btn a {\n" +
                "      background-color: #ffffff;\n" +
                "      border: solid 1px #3498db;\n" +
                "      border-radius: 5px;\n" +
                "      box-sizing: border-box;\n" +
                "      color: #3498db;\n" +
                "      cursor: pointer;\n" +
                "      display: inline-block;\n" +
                "      font-size: 14px;\n" +
                "      font-weight: bold;\n" +
                "      margin: 0;\n" +
                "      padding: 12px 25px;\n" +
                "      text-decoration: none;\n" +
                "      text-transform: capitalize;\n" +
                "    }\n" +
                "\n" +
                "    .btn-primary table td {\n" +
                "      background-color: #3498db;\n" +
                "    }\n" +
                "\n" +
                "    .btn-primary a {\n" +
                "      background-color: #3498db;\n" +
                "      border-color: #3498db;\n" +
                "      color: #ffffff;\n" +
                "    }\n" +
                "\n" +
                "    /* -------------------------------------\n" +
                "        OTHER STYLES THAT MIGHT BE USEFUL\n" +
                "    ------------------------------------- */\n" +
                "    .last {\n" +
                "      margin-bottom: 0;\n" +
                "    }\n" +
                "\n" +
                "    .first {\n" +
                "      margin-top: 0;\n" +
                "    }\n" +
                "\n" +
                "    .align-center {\n" +
                "      text-align: center;\n" +
                "    }\n" +
                "\n" +
                "    .align-right {\n" +
                "      text-align: right;\n" +
                "    }\n" +
                "\n" +
                "    .align-left {\n" +
                "      text-align: left;\n" +
                "    }\n" +
                "\n" +
                "    .clear {\n" +
                "      clear: both;\n" +
                "    }\n" +
                "\n" +
                "    .mt0 {\n" +
                "      margin-top: 0;\n" +
                "    }\n" +
                "\n" +
                "    .mb0 {\n" +
                "      margin-bottom: 0;\n" +
                "    }\n" +
                "\n" +
                "    .preheader {\n" +
                "      color: transparent;\n" +
                "      display: none;\n" +
                "      height: 0;\n" +
                "      max-height: 0;\n" +
                "      max-width: 0;\n" +
                "      opacity: 0;\n" +
                "      overflow: hidden;\n" +
                "      mso-hide: all;\n" +
                "      visibility: hidden;\n" +
                "      width: 0;\n" +
                "    }\n" +
                "\n" +
                "    .powered-by a {\n" +
                "      text-decoration: none;\n" +
                "    }\n" +
                "\n" +
                "    hr {\n" +
                "      border: 0;\n" +
                "      border-bottom: 1px solid #f6f6f6;\n" +
                "      margin: 20px 0;\n" +
                "    }\n" +
                "\n" +
                "    /* -------------------------------------\n" +
                "        RESPONSIVE AND MOBILE FRIENDLY STYLES\n" +
                "    ------------------------------------- */\n" +
                "    @media only screen and (max-width: 620px) {\n" +
                "      table[class=body] h1 {\n" +
                "        font-size: 28px !important;\n" +
                "        margin-bottom: 10px !important;\n" +
                "      }\n" +
                "      table[class=body] p,\n" +
                "      table[class=body] ul,\n" +
                "      table[class=body] ol,\n" +
                "      table[class=body] td,\n" +
                "      table[class=body] span,\n" +
                "      table[class=body] a {\n" +
                "        font-size: 16px !important;\n" +
                "      }\n" +
                "      table[class=body] .wrapper,\n" +
                "      table[class=body] .article {\n" +
                "        padding: 10px !important;\n" +
                "      }\n" +
                "      table[class=body] .content {\n" +
                "        padding: 0 !important;\n" +
                "      }\n" +
                "      table[class=body] .container {\n" +
                "        padding: 0 !important;\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table[class=body] .main {\n" +
                "        border-left-width: 0 !important;\n" +
                "        border-radius: 0 !important;\n" +
                "        border-right-width: 0 !important;\n" +
                "      }\n" +
                "      table[class=body] .btn table {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table[class=body] .btn a {\n" +
                "        width: 100% !important;\n" +
                "      }\n" +
                "      table[class=body] .img-responsive {\n" +
                "        height: auto !important;\n" +
                "        max-width: 100% !important;\n" +
                "        width: auto !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    /* -------------------------------------\n" +
                "        PRESERVE THESE STYLES IN THE HEAD\n" +
                "    ------------------------------------- */\n" +
                "    @media all {\n" +
                "      .ExternalClass {\n" +
                "        width: 100%;\n" +
                "      }\n" +
                "      .ExternalClass,\n" +
                "      .ExternalClass p,\n" +
                "      .ExternalClass span,\n" +
                "      .ExternalClass font,\n" +
                "      .ExternalClass td,\n" +
                "      .ExternalClass div {\n" +
                "        line-height: 100%;\n" +
                "      }\n" +
                "      .apple-link a {\n" +
                "        color: inherit !important;\n" +
                "        font-family: inherit !important;\n" +
                "        font-size: inherit !important;\n" +
                "        font-weight: inherit !important;\n" +
                "        line-height: inherit !important;\n" +
                "        text-decoration: none !important;\n" +
                "      }\n" +
                "      #MessageViewBody a {\n" +
                "        color: inherit;\n" +
                "        text-decoration: none;\n" +
                "        font-size: inherit;\n" +
                "        font-family: inherit;\n" +
                "        font-weight: inherit;\n" +
                "        line-height: inherit;\n" +
                "      }\n" +
                "      .btn-primary table td:hover {\n" +
                "        background-color: #34495e !important;\n" +
                "      }\n" +
                "      .btn-primary a:hover {\n" +
                "        background-color: #34495e !important;\n" +
                "        border-color: #34495e !important;\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body class=\"\">\n" +
                "<span class=\"preheader\">Verify your SHEBnks account</span>\n" +
                "<table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"body\">\n" +
                "  <tr>\n" +
                "    <td>&nbsp;</td>\n" +
                "    <td class=\"container\">\n" +
                "      <div class=\"content\">\n" +
                "\n" +
                "        <!-- START CENTERED WHITE CONTAINER -->\n" +
                "        <table role=\"presentation\" class=\"main\">\n" +
                "\n" +
                "          <!-- START MAIN CONTENT AREA -->\n" +
                "          <tr>\n" +
                "            <td class=\"wrapper\">\n" +
                "              <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                <tr>\n" +
                "                  <td>\n" +
                "                    <p>Hi "+name+",</p>\n" +
                "                    <p>We have sent you an email verification link so that we can verify your possesion of the email</p>\n" +
                "                    <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\">\n" +
                "                      <tbody>\n" +
                "                      <tr>\n" +
                "                        <td align=\"left\">\n" +
                "                          <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                            <tbody>\n" +
                "                            <tr>\n" +
                "                              <td> <a href=\""+link+"\" target=\"_blank\">Verify account</a> </td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                          </table>\n" +
                "                        </td>\n" +
                "                      </tr>\n" +
                "                      </tbody>\n" +
                "                    </table>\n" +
                "                    <p>Good luck! Hope it works.</p>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "\n" +
                "          <!-- END MAIN CONTENT AREA -->\n" +
                "        </table>\n" +
                "        <!-- END CENTERED WHITE CONTAINER -->\n" +
                "\n" +
                "        <!-- START FOOTER -->\n" +
                "        <div class=\"footer\">\n" +
                "          <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "            <tr>\n" +
                "              <td class=\"content-block\">\n" +
                "                <span class=\"apple-link\">CIC Plaza, Ground floor, Mara Road Upper Hill</span>\n" +
                "\n" +
                "               </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td class=\"content-block powered-by\">\n" +
                "                Powered by <a href=\"http://shebnks.mobi\">SHEBnks</a>.\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </table>\n" +
                "        </div>\n" +
                "        <!-- END FOOTER -->\n" +
                "\n" +
                "      </div>\n" +
                "    </td>\n" +
                "    <td>&nbsp;</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
    }

    public static String DETAILS_STRING(String salutation,String content){
      return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
              "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
              "<head>\n" +
              "    <!--[if gte mso 9]>\n" +
              "    <xml>\n" +
              "        <o:OfficeDocumentSettings>\n" +
              "            <o:AllowPNG/>\n" +
              "            <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
              "        </o:OfficeDocumentSettings>\n" +
              "    </xml>\n" +
              "    <![endif]-->\n" +
              "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
              "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
              "    <meta name=\"x-apple-disable-message-reformatting\">\n" +
              "    <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
              "    <title>\n" +
              "\n" +
              "    </title>\n" +
              "\n" +
              "    <style type=\"text/css\">\n" +
              "        table, td { color: #000000; } a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_image_3 .v-src-width { width: 183px !important; } #u_content_image_3 .v-src-max-width { max-width: 35% !important; } #u_content_image_2 .v-src-width { width: 479px !important; } #u_content_image_2 .v-src-max-width { max-width: 55% !important; } #u_content_image_5 .v-container-padding-padding { padding: 30px 10px 10px !important; } #u_content_image_5 .v-src-width { width: 540px !important; } #u_content_image_5 .v-src-max-width { max-width: 45% !important; } #u_content_image_5 .v-text-align { text-align: center !important; } #u_content_image_4 .v-container-padding-padding { padding: 10px 10px 30px !important; } #u_content_image_4 .v-src-width { width: 540px !important; } #u_content_image_4 .v-src-max-width { max-width: 45% !important; } #u_content_image_4 .v-text-align { text-align: center !important; } #u_content_menu_1 .v-container-padding-padding { padding: 10px !important; } }\n" +
              "        @media only screen and (min-width: 570px) {\n" +
              "            .u-row {\n" +
              "                width: 550px !important;\n" +
              "            }\n" +
              "            .u-row .u-col {\n" +
              "                vertical-align: top;\n" +
              "            }\n" +
              "\n" +
              "            .u-row .u-col-50 {\n" +
              "                width: 275px !important;\n" +
              "            }\n" +
              "\n" +
              "            .u-row .u-col-100 {\n" +
              "                width: 550px !important;\n" +
              "            }\n" +
              "\n" +
              "        }\n" +
              "\n" +
              "        @media (max-width: 570px) {\n" +
              "            .u-row-container {\n" +
              "                max-width: 100% !important;\n" +
              "                padding-left: 0px !important;\n" +
              "                padding-right: 0px !important;\n" +
              "            }\n" +
              "            .u-row .u-col {\n" +
              "                min-width: 320px !important;\n" +
              "                max-width: 100% !important;\n" +
              "                display: block !important;\n" +
              "            }\n" +
              "            .u-row {\n" +
              "                width: calc(100% - 40px) !important;\n" +
              "            }\n" +
              "            .u-col {\n" +
              "                width: 100% !important;\n" +
              "            }\n" +
              "            .u-col > div {\n" +
              "                margin: 0 auto;\n" +
              "            }\n" +
              "        }\n" +
              "        body {\n" +
              "            margin: 0;\n" +
              "            padding: 0;\n" +
              "        }\n" +
              "\n" +
              "        table,\n" +
              "        tr,\n" +
              "        td {\n" +
              "            vertical-align: top;\n" +
              "            border-collapse: collapse;\n" +
              "        }\n" +
              "\n" +
              "        p {\n" +
              "            margin: 0;\n" +
              "        }\n" +
              "\n" +
              "        .ie-container table,\n" +
              "        .mso-container table {\n" +
              "            table-layout: fixed;\n" +
              "        }\n" +
              "\n" +
              "        * {\n" +
              "            line-height: inherit;\n" +
              "        }\n" +
              "\n" +
              "        a[x-apple-data-detectors='true'] {\n" +
              "            color: inherit !important;\n" +
              "            text-decoration: none !important;\n" +
              "        }\n" +
              "\n" +
              "        @media (max-width: 480px) {\n" +
              "            .hide-mobile {\n" +
              "                display: none !important;\n" +
              "                max-height: 0px;\n" +
              "                overflow: hidden;\n" +
              "            }\n" +
              "\n" +
              "        }\n" +
              "    </style>\n" +
              "\n" +
              "\n" +
              "\n" +
              "    <!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Cabin:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Lato:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
              "\n" +
              "</head>\n" +
              "\n" +
              "<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #e0e5eb;color: #000000\">\n" +
              "<!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
              "<!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
              "<table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #e0e5eb;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
              "    <tbody>\n" +
              "    <tr style=\"vertical-align: top\">\n" +
              "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
              "            <!--[if (mso)|(IE)]>\n" +
              "            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
              "                <tr>\n" +
              "                    <td align=\"center\" style=\"background-color: #e0e5eb;\"><![endif]-->\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 0px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
              "                                                <tbody>\n" +
              "                                                <tr style=\"vertical-align: top\">\n" +
              "                                                    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
              "                                                        <span>&#160;</span>\n" +
              "                                                    </td>\n" +
              "                                                </tr>\n" +
              "                                                </tbody>\n" +
              "                                            </table>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #d5827c;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #d5827c;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"background-color: #edecf5;width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"background-color: #edecf5;width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table id=\"u_content_image_3\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
              "                                                <tr>\n" +
              "                                                    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
              "\n" +
              "                                                        <img align=\"center\" border=\"0\" src=\"images/image-1.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 26%;max-width: 137.8px;\" width=\"137.8\" class=\"v-src-width v-src-max-width\"/>\n" +
              "\n" +
              "                                                    </td>\n" +
              "                                                </tr>\n" +
              "                                            </table>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #d5827c;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #d5827c;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"background-color: #edecf5;width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"background-color: #edecf5;width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:15px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <h1 class=\"v-text-align\" style=\"margin: 0px; color: #000000; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: book antiqua,palatino; font-size: 35px;\">\n" +
                                                               salutation+"\n" +
              "                                            </h1>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <h3 class=\"v-text-align\" style=\"margin: 0px; color: #0a0a0a; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: book antiqua,palatino; font-size: 18px;\">\n" +
                                                             content+"\n" +
              "                                            </h3>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #d5827c;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #d5827c;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"background-color: #edecf5;width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"background-color: #edecf5;width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #eef2f5;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #eef2f5;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 0px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
              "                                                <tbody>\n" +
              "                                                <tr style=\"vertical-align: top\">\n" +
              "                                                    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
              "                                                        <span>&#160;</span>\n" +
              "                                                    </td>\n" +
              "                                                </tr>\n" +
              "                                                </tbody>\n" +
              "                                            </table>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #eef2f5;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #eef2f5;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"275\" style=\"width: 275px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 275px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table id=\"u_content_image_5\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 20px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
              "                                                <tr>\n" +
              "                                                    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"right\">\n" +
              "\n" +
              "                                                        <img align=\"right\" border=\"0\" src=\"images/image-7.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 57%;max-width: 139.65px;\" width=\"139.65\" class=\"v-src-width v-src-max-width\"/>\n" +
              "\n" +
              "                                                    </td>\n" +
              "                                                </tr>\n" +
              "                                            </table>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"275\" style=\"width: 275px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 275px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table id=\"u_content_image_4\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:20px 20px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
              "                                                <tr>\n" +
              "                                                    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"left\">\n" +
              "\n" +
              "                                                        <img align=\"left\" border=\"0\" src=\"images/image-3.png\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 57%;max-width: 133.95px;\" width=\"133.95\" class=\"v-src-width v-src-max-width\"/>\n" +
              "\n" +
              "                                                    </td>\n" +
              "                                                </tr>\n" +
              "                                            </table>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #eef2f5;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #eef2f5;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 0px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
              "                                                <tbody>\n" +
              "                                                <tr style=\"vertical-align: top\">\n" +
              "                                                    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
              "                                                        <span>&#160;</span>\n" +
              "                                                    </td>\n" +
              "                                                </tr>\n" +
              "                                                </tbody>\n" +
              "                                            </table>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <div align=\"center\">\n" +
              "                                                <div style=\"display: table; max-width:167px;\">\n" +
              "                                                    <!--[if (mso)|(IE)]><table width=\"167\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:167px;\"><tr><![endif]-->\n" +
              "\n" +
              "\n" +
              "                                                    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
              "                                                    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
              "                                                        <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
              "                                                            <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\n" +
              "                                                                <img src=\"images/image-2.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
              "                                                            </a>\n" +
              "                                                        </td></tr>\n" +
              "                                                        </tbody></table>\n" +
              "                                                    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "                                                    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
              "                                                    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
              "                                                        <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
              "                                                            <a href=\"https://twitter.com/\" title=\"Twitter\" target=\"_blank\">\n" +
              "                                                                <img src=\"images/image-6.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
              "                                                            </a>\n" +
              "                                                        </td></tr>\n" +
              "                                                        </tbody></table>\n" +
              "                                                    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "                                                    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
              "                                                    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
              "                                                        <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
              "                                                            <a href=\"https://linkedin.com/\" title=\"LinkedIn\" target=\"_blank\">\n" +
              "                                                                <img src=\"images/image-4.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
              "                                                            </a>\n" +
              "                                                        </td></tr>\n" +
              "                                                        </tbody></table>\n" +
              "                                                    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "                                                    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
              "                                                    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
              "                                                        <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
              "                                                            <a href=\"https://instagram.com/\" title=\"Instagram\" target=\"_blank\">\n" +
              "                                                                <img src=\"images/image-5.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
              "                                                            </a>\n" +
              "                                                        </td></tr>\n" +
              "                                                        </tbody></table>\n" +
              "                                                    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "\n" +
              "                                                    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                                                </div>\n" +
              "                                            </div>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: #ffffff;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: #ffffff;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table id=\"u_content_menu_1\" style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <div class=\"menu\" style=\"text-align:center\">\n" +
              "                                                <!--[if (mso)|(IE)]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"><tr><![endif]-->\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
              "\n" +
              "                                                <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\">\n" +
              "    About Us\n" +
              "  </span>\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
              "                                                <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\" class=\"hide-mobile\">\n" +
              "      |\n" +
              "    </span>\n" +
              "                                                <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
              "\n" +
              "                                                <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\">\n" +
              "    Contact Us\n" +
              "  </span>\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
              "                                                <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\" class=\"hide-mobile\">\n" +
              "      |\n" +
              "    </span>\n" +
              "                                                <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
              "\n" +
              "                                                <span style=\"padding:5px 15px;display:inline;color:#7e8c8d;font-family:'Cabin',sans-serif;font-size:14px\">\n" +
              "    Help center\n" +
              "  </span>\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "\n" +
              "\n" +
              "                                                <!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
              "                                            </div>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 15px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <div class=\"v-text-align\" style=\"color: #7e8c8d; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
              "                                                <p style=\"font-size: 14px; line-height: 140%;\">&copy; 202X Company. All Rights Reserved.</p>\n" +
              "                                            </div>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "\n" +
              "            <div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
              "                <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 550px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
              "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color: transparent;\">\n" +
              "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:550px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
              "\n" +
              "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"550\" style=\"width: 550px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
              "                        <div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 550px;display: table-cell;vertical-align: top;\">\n" +
              "                            <div style=\"width: 100% !important;\">\n" +
              "                                <!--[if (!mso)&(!IE)]><!--><div style=\"padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
              "\n" +
              "                                <table style=\"font-family:'Lato',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
              "                                    <tbody>\n" +
              "                                    <tr>\n" +
              "                                        <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Lato',sans-serif;\" align=\"left\">\n" +
              "\n" +
              "                                            <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 0px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
              "                                                <tbody>\n" +
              "                                                <tr style=\"vertical-align: top\">\n" +
              "                                                    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
              "                                                        <span>&#160;</span>\n" +
              "                                                    </td>\n" +
              "                                                </tr>\n" +
              "                                                </tbody>\n" +
              "                                            </table>\n" +
              "\n" +
              "                                        </td>\n" +
              "                                    </tr>\n" +
              "                                    </tbody>\n" +
              "                                </table>\n" +
              "\n" +
              "                                <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
              "                            </div>\n" +
              "                        </div>\n" +
              "                        <!--[if (mso)|(IE)]></td><![endif]-->\n" +
              "                        <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
              "                    </div>\n" +
              "                </div>\n" +
              "            </div>\n" +
              "\n" +
              "\n" +
              "            <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
              "        </td>\n" +
              "    </tr>\n" +
              "    </tbody>\n" +
              "</table>\n" +
              "<!--[if mso]></div><![endif]-->\n" +
              "<!--[if IE]></div><![endif]-->\n" +
              "</body>\n" +
              "\n" +
              "</html>";
    }
}
