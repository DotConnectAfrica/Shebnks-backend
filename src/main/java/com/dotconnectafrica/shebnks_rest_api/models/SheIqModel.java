package com.dotconnectafrica.shebnks_rest_api.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Table(name = "she_iq")
public class SheIqModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "userId")
    @Size(max = 70)
    private String userId;

    @Column(name = "number_of_loans")
    private Integer numberOfLoans;

    @Column(name = "wheretaken")
    private String wheretaken;

    @Column(name = "how_long_ago_taken")
    @Size(max = 50)
    private String howLongAgoTaken;

    @Column(name = "who_took_the_loan")
    @Size(max = 50)
    private String whoTookTheLoan;

    @Column(name = "bank_account")
    private Boolean bankAccount;

    @Column(name = "atm")
    private Boolean atm;

    @Column(name = "insurance")
    private Boolean insurance;

    @Column(name = "business")
    private Boolean business;

    @Column(name = "type_of_business")
    private String TypeOfBusiness;

    @Column(name = "business_duration")
    @Size(max = 50)
    private String businessDuration;

    @Column(name = "industry")
    private String industry;

    @Column(name = "business_type_of_loan")
    private String businessTypeOfLoan ;

    @Column(name = "collateral_type")
    private String collateralType;

    @Column(name = "loan_purpose")
    private String loanPurpose;


}
