package com.dotconnectafrica.shebnks_rest_api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Table(name = "seed_fund_application")
public class seedFundApplicationModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private BigInteger application_id;


    @Column(name = "application_date")
    @Size(max = 50)
    private String application_date;

    @Column(name = "application_code")
    @Size(max = 50)
    private String application_code;

    @Column(name = "applicant")
    @Size(max = 50)
    private String applicant;

    @Column(name = "business_name")
    @Size(max = 50)
    private String business_name;

    @Column(name = "bussiness_mobile")
    @Size(max = 50)
    private String bussiness_mobile;

    @Column(name = "bussiness_email")
    @Size(max = 50)
    private String bussiness_email;

    @Column(name = "business_founders")
    @Size(max = 50)
    private String business_founders;

    @Column(name = "bussiness_about")
    @Size(max = 50)
    private String bussiness_about;

    @Column(name = "bussiness_vision_mission")
    @Size(max = 50)
    private String bussiness_vision_mission;

    @Column(name = "proven_traction")
    @Size(max = 50)
    private String proven_traction;

    @Column(name = "funding_reason")
    @Size(max = 50)
    private String funding_reason;

    @Column(name = "fandraised_before")
    @Size(max = 50)
    private String fandraised_before;

    @Column(name = "bussiness_goals")
    @Size(max = 50)
    private String bussiness_goals;

    @Column(name = "bussiness_challenge")
    @Size(max = 50)
    private String bussiness_challenge;

    @Column(name = "bussiness_challenge_solution")
    @Size(max = 50)
    private String bussiness_challenge_solution;

    @Column(name = "assigned_judge")
    @Size(max = 50)
    private String assigned_judge;

    @Column(name = "other_attachements")
    @Size(max = 200)
    private String other_attachements;

    @Column(name = "business_other_info")
    @Size(max = 200)
    private String business_other_info;

    @Column(name = "project_budget")
    @Size(max = 200)
    private String project_budget;

    @Column(name = "ownedbywomen")
    @Size(max = 10)
    private String ownedbywomen;

    @Column(name = "business_share_capital")
    @Size(max = 200)
    private String business_share_capital;

    @Column(name = "bussiness_level")
    @Size(max = 200)
    private String bussiness_level;

    @Column(name = "attachments_link")
    @Size(max = 200)
    private String attachments_link;

    @Column(name = "revenue_amount")
    @Size(max = 200)
    private String revenue_amount;

    @Column(name = "bussiness_sectors")
    @Size(max = 200)
    private String bussiness_sectors;

    @Column(name = "application_received_status")
    private Integer application_received_status = 0;

    @Column(name = "application_rules_status")
    private Integer application_rules_status = 0;

    @Column(name = "application_evaluation_status")
    private Integer application_evaluation_status = 0;

    @Column(name = "application_admin_check_status")
    private Integer application_admin_check_status = 0;

    @Column(name = "application_status")
    private Integer application_status = 0;

    @Column(name = "bussiness_target")
    @Size(max = 500)
    private String bussiness_target;

    @Column(name = "joint_statement")
    @Size(max = 500)
    private String joint_statement;

    @Column(name = "tax_admin_cert")
    @Size(max = 500)
    private String tax_admin_cert;


}
