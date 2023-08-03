package com.dotconnectafrica.shebnks_rest_api.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "reversal")
public class ReversalModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;


    @NotBlank
    @Column(name = "amount")
    @Size(max = 20)
    private String amount;

    @NotNull
    @Column(name = "trans_completed_time")
    @Size(max = 50)
    private String transCompletedTime;

    @Column(name = "transaction_id")
    @Size(max = 100)
    private String transactionID;

    @Column(name = "original_transaction_id")
    @Size(max = 200)
    private String originalTransactionID;

    @Column(name = "charge")
    @Size(max = 20)
    private String charge;

    @Column(name = "credit_party_public_name")
    @Size(max = 255)
    private String creditPartyPublicName;

    @Column(name = "debit_party_public_name")
    @Size(max = 255)
    private String debitPartyPublicName;

    public ReversalModel(BigInteger id, String amount, String transCompletedTime, String transactionID, String originalTransactionID, String charge, String creditPartyPublicName, String debitPartyPublicName) {
        this.id = id;
        this.amount = amount;
        this.transCompletedTime = transCompletedTime;
        this.transactionID = transactionID;
        this.originalTransactionID = originalTransactionID;
        this.charge = charge;
        this.creditPartyPublicName = creditPartyPublicName;
        this.debitPartyPublicName = debitPartyPublicName;
    }
}
