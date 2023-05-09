package com.md.shebanks.repository.loan

import com.md.shebanks.data.loan.LoanApplicationModel
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LoanRepository : JpaRepository<LoanApplicationModel, UUID> {

    override fun findAll(sort: Sort): MutableList<LoanApplicationModel>
    override fun findById(id: UUID): Optional<LoanApplicationModel>

    fun findByUserId(id: UUID): Optional<LoanApplicationModel>
}