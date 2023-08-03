package com.dotconnectafrica.shebnks_rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;


@Getter
@Setter
public class SheIqRequestJsonModel {

    @JsonProperty("loanNumber")
    private Integer loanNumber;

    @JsonProperty("loanPurpose")
    private String[] loanPurpose;

    @JsonProperty("whereTaken")
    private String whereTaken;

    @JsonProperty("howLongAgoTaken")
    private String howLongAgoTaken;

    @JsonProperty("whoTookTheLoan")
    private String whoTookTheLoan;

    @JsonProperty("bankAccount")
    private boolean bankAccount;

    @JsonProperty("card")
    private boolean card;

    @JsonProperty("insurance")
    private boolean insurance;

    @JsonProperty("business")
    private boolean business;

    @JsonProperty("typeOfBusiness")
    private String typeOfBusiness;

    @JsonProperty("businessDuration")
    private String businessDuration;

    @JsonProperty("industry")
    private String industry;

    @JsonProperty("businessTypeOfLoan")
    private String businessTypeOfLoan;

    @JsonProperty("collateralType")
    private String collateralType;

    @JsonProperty("userId")
    private BigInteger userId;

}
