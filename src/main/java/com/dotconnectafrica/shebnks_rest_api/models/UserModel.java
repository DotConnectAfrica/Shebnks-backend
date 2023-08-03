package com.dotconnectafrica.shebnks_rest_api.models;

import com.dotconnectafrica.shebnks_rest_api.auth.models.Role;
import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "app_users")
public class UserModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private BigInteger userId;

    @Column(name = "first_name")
    @Size(max = 255)
    private String firstName;

    @Column(name = "middle_name")
    @Size(max = 255)
    private String middleName;

    @Column(name = "last_name")
    @Size(max = 255)
    private String lastName;

    @Column(name = "email_address")
    @Size(max = 255)
    private String emailAddress;

    @Column(name = "password")
    @Size(max = 255)
    private String password;

    @Column(name = "balace")
    private Integer balance;

    @Column(name = "currency")
    @Size(max = 30)
    private String currency;

    @Column(name = "card_expiry")
    @Size(max = 30)
    private String cardExpiry;

    @Column(name = "verified_number")
    @Size(max = 30)
    private String verifiedNumber;

    @Column(name = "mobileuuid")
    @Size(max = 30)
    private String mobileuuid;

    @Column(name = "firebase_id")
    @Size(max = 30)
    private String firebaseId;

    @Column(name = "mobile_number")
    @Size(max = 255)
    private String mobileNumber;

    @Column(name = "loan_limit")
    @Size(max = 15)
    private String loanLimit;

    @Column(name = "sheloans")
    private Integer sheloans;

    @Column(name = "shebnks_card_number")
    @Size(max = 100)
    private String shebnksCardNumber;

    @Column(name = "uuid")
    @Size(max = 100)
    private String uuid;

    @Column(name = "profile_image")
    @Size(max = 500)
    private String profileImage;

    @Column(name = "messaging_token")
    private String messagingToken;

    @Column(name = "account_verification_status")
    private Integer accountVerificationStatus = 0;

    @Column(name = "id_number")
    @Size(max = 255)
    private String idNumber;



}
