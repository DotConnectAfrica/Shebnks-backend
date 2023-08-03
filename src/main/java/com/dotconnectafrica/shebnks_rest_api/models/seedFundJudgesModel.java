package com.dotconnectafrica.shebnks_rest_api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Table(name = "seedfund_judges")
public class seedFundJudgesModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "email")
    @Size(max = 70)
    private String email;

    @Column(name = "first_name")
    @Size(max = 50)
    private String first_name;

    @Column(name = "middle_name")
    @Size(max = 50)
    private String middle_name;

    @Column(name = "last_name")
    @Size(max = 50)
    private String last_name;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "superuser")
    private Boolean superuser;

    @Column(name = "password_hash")
    @Size(max = 70)
    private String password_hash = "123456";

    @Column(name = "image")
    private String image;
}
