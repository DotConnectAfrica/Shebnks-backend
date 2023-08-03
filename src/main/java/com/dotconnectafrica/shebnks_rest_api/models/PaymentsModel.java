package com.dotconnectafrica.shebnks_rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "payments_paybill", uniqueConstraints = {@UniqueConstraint(columnNames = {"trans_id"})})
public class PaymentsModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;


    @JsonProperty("TransactionType")
    @Column(name = "transaction_type")
    @Size(max = 100)
    private String transactionType;

    @NotBlank
    @JsonProperty("TransID")
    @Column(unique = true, name = "trans_id")
    @Size(max = 100)
    private String transId;

    @JsonProperty("TransTime")
    @Column(name = "trans_time")
    @Size(max = 100)
    private String transTime;

    @JsonProperty("TransAmount")
    @Column(name = "trans_amount")
    @Size(max = 100)
    private String transAmount;

    @JsonProperty("BusinessShortCode")
    @Column(name = "business_shortcode")
    @Size(max = 100)
    private String businessShortCode;

    @JsonProperty("BillRefNumber")
    @Column(name = "bill_ref_number")
    @Size(max = 100)
    private String billRefNumber;

    @JsonProperty("InvoiceNumber")
    @Column(name = "invoice_number")
    @Size(max = 100)
    private String invoiceNumber;

    @JsonProperty("OrgAccountBalance")
    @Column(name = "org_account_balance")
    @Size(max = 100)
    private String orgAccountBalance;

    @JsonProperty("ThirdPartyTransID")
    @Column(name = "third_party_trans_id")
    @Size(max = 100)
    private String thirdPartyTransID;

    @JsonProperty("MSISDN")
    @Column(name = "msisdn")
    @Size(max = 100)
    private String mSISDN;

    @JsonProperty("FirstName")
    @Column(name = "first_name")
    @Size(max = 100)
    private String firstName;

    @JsonProperty("MiddleName")
    @Column(name = "middle_name")
    @Size(max = 100)
    private String middleName;

    @JsonProperty("LastName")
    @Column(name = "last_name")
    @Size(max = 100)
    private String lastName;

    @JsonProperty("TransactionFee")
    @Column(name = "transaction_fee")
    private BigInteger transactionFee;

    public PaymentsModel(BigInteger id, String transactionType, String transId, String transTime, String transAmount, String businessShortCode, String billRefNumber, String invoiceNumber, String orgAccountBalance, String thirdPartyTransID, String mSISDN, String firstName, String middleName, String lastName, BigInteger transactionFee) {
        this.id = id;
        this.transactionType = transactionType;
        this.transId = transId;
        this.transTime = transTime;
        this.transAmount = transAmount;
        this.businessShortCode = businessShortCode;
        this.billRefNumber = billRefNumber;
        this.invoiceNumber = invoiceNumber;
        this.orgAccountBalance = orgAccountBalance;
        this.thirdPartyTransID = thirdPartyTransID;
        this.mSISDN = mSISDN;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.transactionFee = transactionFee;
    }
}
