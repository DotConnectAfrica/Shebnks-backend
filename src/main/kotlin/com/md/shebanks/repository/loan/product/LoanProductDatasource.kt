package com.md.shebanks.repository.loan.product

import com.md.shebanks.data.loan.product.LoanProductRequest
import com.md.shebanks.data.response.AppResponse
import org.springframework.http.ResponseEntity

interface LoanProductDatasource {
    fun createLoan(request: LoanProductRequest): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }

    fun loanById(id: String): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }

    fun userLoansById(id: List<String>): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }

    fun allLoans(): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }

    fun deleteLoan(id: String): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }

    fun deleteLoans(): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }


    fun updateLoan(request: LoanProductRequest, id: String): ResponseEntity<AppResponse> {
        throw Exception("Not implemented")
    }
}