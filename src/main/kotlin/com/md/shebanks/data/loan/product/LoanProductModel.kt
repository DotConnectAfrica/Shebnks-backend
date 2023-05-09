package com.md.shebanks.data.loan.product

import com.md.shebanks.data.loan.user.UserQualifiedLoanModel
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
@Table(name = "_loan_product_table")
data class LoanProductModel(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    var name: String,

    var minAmount: Double,

    var maxAmount: Double,

    var loanTerm: Int,

    var loanInterest: Double,

    @Column(updatable = false)
    @CreationTimestamp
    var createdAt: Timestamp? = null,

    @UpdateTimestamp
    var updatedAt: Timestamp? = null,

    @OneToOne(mappedBy = "loanProduct")
    private var loan: UserQualifiedLoanModel? = null
)
