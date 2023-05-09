package com.md.shebanks.data.loan

import com.md.shebanks.data.user.UserModel
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.util.*


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_loan_application_table")
data class LoanApplicationModel(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    override var loanId: UUID? = null,
    override var userId: UUID,
    override var amount: Double,
    override var interestRate: Double = 0.0,
    override var loanTerm: Int,
    override var monthlyPayment: Double,
    override var loanPurpose: String,
    override var dateApproved: Timestamp? = null,
    override var dateDisbursed: Timestamp? = null,
    override var dateDue: Timestamp,
    override var latePaymentFees: Double,
    @Enumerated(EnumType.STRING)
    override var status: LoanStatusEnum? = LoanStatusEnum.PENDING,
    @OneToMany(mappedBy = "loanApplied")
    override var amountPaidPerMonth: MutableList<LoanMonthlyPayment>? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    override var loanApplicant: UserModel? = null,
    @Column(updatable = false)
    @CreationTimestamp
    override var createdAt: Timestamp? = null,
    @UpdateTimestamp
    override var updatedAt: Timestamp? = null,
) : LoanApplicationDatasource {

    @Column(insertable = false, updatable = false)
    override var totalAmountPaid: Double? = amountPaidPerMonth?.sumOf { it.amountPaid }

    override var totalAmount: Double? = amount.simpleInterest(interestRate, loanTerm)


}


