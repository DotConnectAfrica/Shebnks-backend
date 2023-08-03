package com.dotconnectafrica.shebnks_rest_api.mpesa.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InstantPaymentRequestResponse {

    @Expose
    @SerializedName("MerchantRequestID")
    private String MerchantRequestID;

    @Expose
    @SerializedName("CheckoutRequestID")
    private String CheckoutRequestID;

    @Expose
    @SerializedName("ResponseDescription")
    private String ResponseDescription;

    @Expose
    @SerializedName("ResponseCode")
    private int ResponseCode;

    @Expose
    @SerializedName("CustomerMessage")
    private String CustomerMessage;

}
