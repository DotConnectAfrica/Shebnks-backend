package com.md.shebanks.service.loan.product

import com.md.shebanks.data.DataMapTypeConverter
import com.md.shebanks.data.loan.product.LoanProductModel
import com.md.shebanks.data.loan.product.LoanProductRequest
import com.md.shebanks.data.response.AppResponse
import com.md.shebanks.repository.loan.product.LoanProductDatasource
import com.md.shebanks.repository.loan.product.LoanProductRepository
import com.md.shebanks.util.handler.AppException
import jakarta.transaction.Transactional
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap
import kotlin.jvm.optionals.getOrNull


@RequiredArgsConstructor
@Service
class LoanProductServiceImpl(val repository: LoanProductRepository) : LoanProductDatasource {

    override fun createLoan(request: LoanProductRequest): ResponseEntity<AppResponse> {
        val map = DataMapTypeConverter().map(request)
        for (e in map.entries) {
            if (e.value.isBlank()) throw (AppException("${e.key} cannot be null or empty"))
        }
        val loan = LoanProductModel(
            name = request.name,
            minAmount = request.minAmount,
            maxAmount = request.maxAmount,
            loanTerm = request.loanTerm,
            loanInterest = request.loanInterest
        )
        repository.save(loan)
        return ResponseEntity.ok(
            AppResponse(
                message = "Loan product created successfully",
                status = HttpStatus.OK
            )
        )

    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun loanById(id: String): ResponseEntity<AppResponse> {
        val loan = repository.findById(UUID.fromString(id)).getOrNull()
            ?: throw (AppException("Loan product not found"))
        return ResponseEntity.ok(
            AppResponse(
                message = "success",
                status = HttpStatus.OK,
                data = hashMapOf(
                    "loans" to mutableListOf(
                        hashMapOf(
                            "id" to loan.id,
                            "name" to loan.name,
                            "minAmount" to loan.minAmount,
                            "maxAmount" to loan.maxAmount,
                            "loanTerm" to loan.loanTerm,
                            "loanInterest" to loan.loanInterest
                        )
                    )
                )
            )
        )
    }

    @Transactional
    @OptIn(ExperimentalStdlibApi::class)
    override fun updateLoan(request: LoanProductRequest, id: String): ResponseEntity<AppResponse> {
        val loan = repository.findById(UUID.fromString(id)).getOrNull()
            ?: throw (AppException("Loan product not found"))

        loan.name = request.name
        loan.minAmount = request.minAmount
        loan.maxAmount = request.maxAmount
        loan.loanInterest = request.loanInterest
        loan.loanTerm = request.loanTerm

        return ResponseEntity.ok(
            AppResponse(
                message = "Loan updated successfully",
                status = HttpStatus.OK,
            )
        )
    }

    override fun allLoans(): ResponseEntity<AppResponse> {
        val loans = repository.findAll()
        val loanList = mutableListOf<HashMap<String, Any?>>()
        if (loans.isEmpty()) throw (AppException("Loan products not found"))
        loans.forEach { loan ->
            val loanMap = hashMapOf<String, Any?>()
            loanMap["id"] to loan.id
            loanMap["name"] to loan.name
            loanMap["minAmount"] to loan.minAmount
            loanMap["maxAmount"] to loan.maxAmount
            loanMap["loanTerm"] to loan.loanTerm
            loanMap["loanInterest"] to loan.loanInterest
            loanList.add(loanMap)
        }
        return ResponseEntity.ok(
            AppResponse(
                message = "success",
                status = HttpStatus.OK,
                data = hashMapOf("loans" to loans)
            )
        )
    }

    override fun deleteLoan(id: String): ResponseEntity<AppResponse> {
        repository.deleteById(UUID.fromString(id))
        return ResponseEntity.ok(
            AppResponse(
                message = "Loan deleted successfully",
                status = HttpStatus.OK,
            )
        )
    }

    override fun deleteLoans(): ResponseEntity<AppResponse> {
        repository.deleteAllInBatch()
        return ResponseEntity.ok(
            AppResponse(
                message = "All loans deleted successfully",
                status = HttpStatus.OK,
            )
        )
    }
}