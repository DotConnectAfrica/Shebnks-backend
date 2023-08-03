package com.dotconnectafrica.shebnks_rest_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "payment_b2c_logs")
public class PaymentB2CLogsModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    @Column(name = "phone")
    @Size(max = 20)
    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "postdata")
    private String postData;

    public PaymentB2CLogsModel(BigInteger id, String phone, String postData) {
        this.id = id;
        this.phone = phone;
        this.postData = postData;
    }
}
