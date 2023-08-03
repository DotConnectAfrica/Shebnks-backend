package com.dotconnectafrica.shebnks_rest_api.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sheloans_requests")
public class SHELoansRequestModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "user_name")
    @Size(max = 30)
    private String userName;

    @Column(name = "email")
    @Size(max = 30)
    private String email;


    @Column(name = "phone_number")
    @Size(max = 20)
    private String phoneNumber;

    @Column(name = "government_id")
    @Size(max = 20)
    private String governmentId;

    @CreatedDate
    @Column(name = "date_applied")
    private String dateApplied;


    @Column(name = "rejection_message_seen")
    private Boolean rejectionMessageSeen;


    @Column(name = "date_approved")
    private String dateApproved ;

    @Column(name = "approved")
    private Boolean approved;


}
