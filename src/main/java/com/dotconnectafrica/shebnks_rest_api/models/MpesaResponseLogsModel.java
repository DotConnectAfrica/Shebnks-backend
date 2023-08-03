package com.dotconnectafrica.shebnks_rest_api.models;

import com.dotconnectafrica.shebnks_rest_api.models.audit.RegisterDateAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "mpesa_responselogs")
public class MpesaResponseLogsModel extends RegisterDateAudit {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;


    @NotBlank
    @Column(name = "phone")
    @Size(max = 20)
    private String phone;

    @Column(name = "merchant_request_id")
    @Size(max = 50)
    private String merchantRequestID;

    @Column(name = "checkout_request_id")
    @Size(max = 50)
    private String checkoutRequestID;

    @Column(name = "timestamp")
    @Size(max = 20)
    private String timestamp;

    @Column(name = "pass")
    private String pass;



    public MpesaResponseLogsModel(BigInteger id, String phone, String merchantRequestID, String checkoutRequestID, String timestamp, String pass) {
        this.id = id;
        this.phone = phone;
        this.merchantRequestID = merchantRequestID;
        this.checkoutRequestID = checkoutRequestID;
        this.timestamp = timestamp;
        this.pass = pass;
    }
}
