package com.dotconnectafrica.shebnks_rest_api.models;

import com.dotconnectafrica.shebnks_rest_api.models.audit.DateAudit;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "b2c_payment")
public class B2CPaymentModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;


    @NotBlank
    @Column(name = "amount")
    @Size(max = 10)
    private String amount;

    @NotNull
    @Column(name = "transaction_id")
    @Size(max = 20)
    private String transactionID;

    @Column(name = "transaction_completed_date_time")
    @Size(max = 50)
    private String transactionCompletedDateTime;

    @Column(name = "receiver_party_public_name")
    @Size(max = 200)
    private String receiverPartyPublicName;

    @Column(name = "b2c_utility_account_available_funds")
    @Size(max = 50)
    private String b2CUtilityAccountAvailableFunds;

    @Column(name = "b2c_working_account_available_funds")
    @Size(max = 50)
    private String b2CWorkingAccountAvailableFunds;

    @Column(name = "b2c_recipient_is_registered_customer")
    @Size(max = 5)
    private String b2CRecipientIsRegisteredCustomer;

    @Column(name = "b2c_charges_paid_account_available_funds")
    @Size(max = 20)
    private String b2CChargesPaidAccountAvailableFunds;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private String createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private String updatedAt;

    public B2CPaymentModel(BigInteger id, String amount, String transactionID, String transactionCompletedDateTime, String receiverPartyPublicName, String b2CUtilityAccountAvailableFunds, String b2CWorkingAccountAvailableFunds, String b2CRecipientIsRegisteredCustomer, String b2CChargesPaidAccountAvailableFunds, String createdAt, String updatedAt) {
        this.id = id;
        this.amount = amount;
        this.transactionID = transactionID;
        this.transactionCompletedDateTime = transactionCompletedDateTime;
        this.receiverPartyPublicName = receiverPartyPublicName;
        this.b2CUtilityAccountAvailableFunds = b2CUtilityAccountAvailableFunds;
        this.b2CWorkingAccountAvailableFunds = b2CWorkingAccountAvailableFunds;
        this.b2CRecipientIsRegisteredCustomer = b2CRecipientIsRegisteredCustomer;
        this.b2CChargesPaidAccountAvailableFunds = b2CChargesPaidAccountAvailableFunds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
