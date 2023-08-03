package com.dotconnectafrica.shebnks_rest_api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Table(name = "mpesa_logs")
public class MpesaLogsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "phone")
    @Size(max = 20)
    private String phone;

    @Column(name = "post_data")
    private String logs;

    @Column(name = "result_type")
    private Integer resultType;

    @Column(name = "result_code")
    private Integer resultCode;

    @Column(name = "result_desc")
    @Size(max = 200)
    private String resultDesc;

    @Column(name = "originator_conversation_id")
    @Size(max = 100)
    private String originatorConversationID;

    @Column(name = "conversation_id")
    @Size(max = 100)
    private String conversationID;

    @Column(name = "transaction_id")
    @Size(max = 100)
    private String transactionID;

}
