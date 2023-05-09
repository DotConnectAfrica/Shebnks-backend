package com.md.shebanks.data.loan

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
data class LoanRequest(
    var amount: Double,
)
