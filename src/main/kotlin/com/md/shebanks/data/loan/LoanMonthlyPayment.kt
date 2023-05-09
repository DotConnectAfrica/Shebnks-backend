package com.md.shebanks.data.loan

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp
import java.util.*


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_loan_monthly_payment_table")
data class LoanMonthlyPayment(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    var loanId: UUID? = null,

    var date: Timestamp = Timestamp(Date().time),

    var amountPaid: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loanId", referencedColumnName = "loanId", insertable = false, updatable = false)
    var loanApplied: LoanApplicationModel? = null
)
