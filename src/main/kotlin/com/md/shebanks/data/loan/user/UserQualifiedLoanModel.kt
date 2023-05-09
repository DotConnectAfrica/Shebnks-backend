package com.md.shebanks.data.loan.user

import com.md.shebanks.data.loan.product.LoanProductModel
import com.md.shebanks.data.user.UserModel
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user_qualified_loan_table")
data class UserQualifiedLoanModel(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,
    var userId: UUID,
    var loanId: UUID,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "loanId", referencedColumnName = "id")
    val loanProduct: LoanProductModel? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    var loanApplicant: UserModel? = null,
)
