package com.md.shebanks.repository.loan

import com.md.shebanks.data.loan.LoanRequest
import com.md.shebanks.data.response.AppResponse
import org.springframework.http.ResponseEntity

interface LoanDatasource {
    fun requestLoan(request: LoanRequest, userId: String): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }

}