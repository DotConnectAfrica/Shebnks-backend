package com.md.shebanks.controller.loan

import com.md.shebanks.data.loan.LoanRequest
import com.md.shebanks.data.response.AppResponse
import com.md.shebanks.repository.loan.LoanDatasource
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequiredArgsConstructor
@RequestMapping("/she/api/v1/loan")
class LoanControllerImpl : LoanDatasource {

    @PostMapping("request/{userId}")
    override fun requestLoan(
        @RequestBody request: LoanRequest,
        @PathVariable userId: String
    ): ResponseEntity<AppResponse> {
        return super.requestLoan(request, userId)
    }
}