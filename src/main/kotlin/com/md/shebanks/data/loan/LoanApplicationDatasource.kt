package com.md.shebanks.data.loan

import com.md.shebanks.data.user.UserModel
import java.sql.Timestamp
import java.util.*

interface LoanApplicationDatasource {
    var loanId: UUID?
    var userId: UUID
    var amount: Double
    var interestRate: Double
    var loanTerm: Int
    var monthlyPayment: Double
    var loanPurpose: String
    var dateApproved: Timestamp?
    var dateDisbursed: Timestamp?
    var dateDue: Timestamp
    var latePaymentFees: Double
    var amountPaidPerMonth: MutableList<LoanMonthlyPayment>?
    var loanApplicant: UserModel?
    var totalAmountPaid: Double?
    var totalAmount: Double?
    var status: LoanStatusEnum?
    var createdAt: Timestamp?
    var updatedAt: Timestamp?
}