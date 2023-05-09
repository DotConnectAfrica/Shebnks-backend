package com.md.shebanks.data.loan.product

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
data class LoanProductRequest(
    var name: String,

    var minAmount: Double,

    var maxAmount: Double,

    var loanTerm: Int,

    var loanInterest: Double,
)
