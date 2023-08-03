package com.dotconnectafrica.shebnks_rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "payment_transactions", uniqueConstraints = {@UniqueConstraint(columnNames = {"ref"})})
public class TransactionsModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;


    @NotBlank
    @JsonProperty("ref")
    @Column(name = "ref")
    @Size(max = 20)
    private String ref;

    @JsonProperty("reference")
    @Column(unique = true, name = "reference")
    @Size(max = 100)
    private String reference;


    @NotBlank
    @JsonProperty("userMobile")
    @Column(name = "user_mobile")
    @Size(max = 20)
    private String user;

    @NotBlank
    @JsonProperty("accountNumber")
    @Column(name = "account_number")
    @Size(max = 20)
    private String accountNumber;

    @JsonProperty("accountName")
    @Column(name = "account_name")
    @Size(max = 200)
    private String accountName;

    @NotEmpty
    @JsonProperty("amount")
    @Column(name = "amount")
    @Size(max = 10)
    private String amount;

    @JsonProperty("response")
    @Column(name = "response")
    private String response;


    @JsonProperty("status")
    @Column(name = "status")
    @Size(max = 20)
    private String status = "Pending";

    @JsonProperty("paymentMethod")
    @Column(name = "payment_method")
    @Size(max = 50)
    private String paymentMethod;

    @JsonProperty("paymentRef")
    @Column(name = "payment_ref")
    @Size(max = 50)
    private String paymentRef;

    @JsonProperty("paymentAccountNumber")
    @Column(name = "payment_account_number")
    @Size(max = 50)
    private String paymentAccountNumber;

    @JsonProperty("description")
    @Column(name = "description")
    @Size(max = 200)
    private String description;

    @Column(name = "created_at")
    String createdAt;


    @LastModifiedDate
    @Column(name = "updated_at")
    String updatedAt;


    @JsonProperty("loanId")
    @Column(name = "loan_id")
    private BigInteger loanId;


    @JsonProperty("TransactionDesc")
    @Transient
    private String transactionDesc;

    public TransactionsModel(BigInteger id, String ref, String reference, String user, String accountNumber, String accountName, String amount, String response, String status, String paymentMethod, String paymentRef, String paymentAccountNumber, String description, String createdAt, String updatedAt, BigInteger loanId, String transactionDesc) {
        this.id = id;
        this.ref = ref;
        this.reference = reference;
        this.user = user;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.amount = amount;
        this.response = response;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.paymentRef = paymentRef;
        this.paymentAccountNumber = paymentAccountNumber;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.loanId = loanId;
        this.transactionDesc = transactionDesc;
    }
}
