package com.dotconnectafrica.shebnks_rest_api.models;

import com.dotconnectafrica.shebnks_rest_api.models.audit.RegisterDateAudit;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "reversal_logs")
public class ReversalLogsModel  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "post_data")
    private String postData;



    @CreatedDate
    @Column(name = "created_at")
    private String created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private String updated_at;

    public ReversalLogsModel(BigInteger id, String postData, String created_at, String updated_at) {
        this.id = id;
        this.postData = postData;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
