package com.md.shebanks.repository.loan.product

import com.md.shebanks.data.loan.product.LoanProductModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LoanProductRepository : JpaRepository<LoanProductModel, UUID>