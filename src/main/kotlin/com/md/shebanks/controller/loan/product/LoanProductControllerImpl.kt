package com.md.shebanks.controller.loan.product

import com.md.shebanks.data.loan.product.LoanProductRequest
import com.md.shebanks.data.response.AppResponse
import com.md.shebanks.repository.loan.product.LoanProductDatasource
import com.md.shebanks.service.loan.product.LoanProductServiceImpl
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequiredArgsConstructor
@RequestMapping("/she/api/v1/loan/product/")
class LoanProductControllerImpl(val serviceImpl: LoanProductServiceImpl) : LoanProductDatasource {

    @PostMapping("create")
    override fun createLoan(@RequestBody request: LoanProductRequest): ResponseEntity<AppResponse> {
        return serviceImpl.createLoan(request)
    }

    @GetMapping("loan/{id}")
    override fun loanById(@PathVariable id: String): ResponseEntity<AppResponse> {
        return serviceImpl.loanById(id)
    }

    @PutMapping("edit/{id}")
    override fun updateLoan(
        @RequestBody request: LoanProductRequest,
        @PathVariable id: String
    ): ResponseEntity<AppResponse> {
        return serviceImpl.updateLoan(request, id)
    }

    @GetMapping("loans")
    override fun allLoans(): ResponseEntity<AppResponse> {
        return serviceImpl.allLoans()
    }

    @DeleteMapping("remove/{id}")
    override fun deleteLoan(@PathVariable id: String): ResponseEntity<AppResponse> {
        return serviceImpl.deleteLoan(id)
    }

    @DeleteMapping("remove/all")
    override fun deleteLoans(): ResponseEntity<AppResponse> {
        return serviceImpl.deleteLoans()
    }

}