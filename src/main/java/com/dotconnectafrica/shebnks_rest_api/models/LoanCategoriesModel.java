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
@Table(name = "loan_categories")
public class LoanCategoriesModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "loan_category_name")
    @Size(max = 20)
    private String loanCategoryName;

    @Column(name = "loan_maximum_amount")
    private Integer loanMaximumAmount;

    @Column(name = "loan_repayment_period")
    @Size(max = 20)
    private String loanRepaymentPeriod;

    @Column(name = "loan_interest")
    private Integer loanInterest;

    @Column(name = "loan_minimum_amount")
    private Integer loanMinimumAmount;


}
