package com.dotconnectafrica.shebnks_rest_api.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.List;


@Getter
@Setter
public class SheIqRequestModel {

    private Integer loanNumber;
    private String[] loanPurpose;
    private String[] whereTaken;
    private String howLongAgoTaken;
    private String whoTookTheLoan;
    private boolean bankAccount;
    private boolean card;
    private boolean insurance;
    private boolean business;
    private String[] typeOfBusiness;
    private String businessDuration;
    private String[] industry;
    private String[] businessTypeOfLoan;
    private String[] collateralType;
    private BigInteger userId;

}
