package com.dotconnectafrica.shebnks_rest_api.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigInteger;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@Table(name = "loan_application")
public class LoanApplicationModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private BigInteger loanId;

    @Column(name = "loan_code")
    @Size(max = 15)
    private String loanCode;

    @Column(name = "loan_amount")
    private Integer loanAmount;

    @Column(name = "loan_interest_accrued")
    private Integer loanInterestAccrued;

    @Column(name = "loan_balance")
    private Integer loanBalance;

    @Column(name = "amount_paid")
    private Integer amountPaid;

    @Column(name = "last_paid_date")
    @Size(max = 30)
    private String lastPaidDate;

    @Column(name = "loan_status")
    private Integer loanStatus = 1;

    @Column(name = "loan_category")
    @Size(max = 15)
    private String loanCategory;

    @CreatedDate
    @Column(name = "loan_application_date")
    private String loanApplicationDate;


    @Column(name = "loan_disbursement")
    private Boolean loanDisbursement;


    @Column(name = "date_given")
    private String dateGiven;

    @Column(name = "loan_due_date")
    private String loanDueDate;

    @Column(name = "loan_mobile")
    @Size(max = 255)
    private String loanMobile;


}
