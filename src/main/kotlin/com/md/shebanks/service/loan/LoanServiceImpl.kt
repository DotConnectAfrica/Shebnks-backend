package com.md.shebanks.service.loan

import com.md.shebanks.data.loan.LoanRequest
import com.md.shebanks.data.response.AppResponse
import com.md.shebanks.repository.loan.LoanDatasource
import com.md.shebanks.repository.loan.LoanRepository
import com.md.shebanks.util.handler.AppException
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull


@RequiredArgsConstructor
@Service
class LoanServiceImpl(val repo: LoanRepository) : LoanDatasource {

    @OptIn(ExperimentalStdlibApi::class)
    override fun requestLoan(request: LoanRequest, userId: String): ResponseEntity<AppResponse> {
        val exits = repo.findByUserId(UUID.fromString(userId)).getOrNull()
        if (exits != null) throw Exception(AppException(message = "User already has running loan"))
//        val loan = LoanApplicationModel(
//            userId = UUID.fromString(userId),
//            amount = request.amount,
//            interestRate = 0.0,
//            loanTerm = 2,
//            monthlyPayment =
//        )

        return super.requestLoan(request, userId)
    }
}