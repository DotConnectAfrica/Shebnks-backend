package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.LoanApplicationModel;
import com.dotconnectafrica.shebnks_rest_api.models.UserModel;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplicationModel, Long> {

    @Query(value = "SELECT count(loan_id) FROM loan_application where loan_mobile = :user AND loan_status in (1,2,3) limit 1",
            nativeQuery = true
    )
    int checkForExistingLoan(String user);

    @Query(value = "SELECT count(Loan_ID) FROM loan_application where Loan_Mobile = :user AND Loan_Status in (0) AND (Loan_Application_Date < CURRENT_DATE ) limit 1",
            nativeQuery = true
    )
    int checkForUnprocessedLoan(String user);

    LoanApplicationModel findByLoanCode(@NotBlank String loancode);

    LoanApplicationModel findByLoanId(@NotBlank BigInteger loanId);

    @Query(value = "SELECT * from Loan_Application where Loan_Mobile= :user  and Loan_Status in (1,2,3) order by Loan_Application_Date desc",
            nativeQuery = true
    )
    List<LoanApplicationModel> getUnpaidLoanData(String user);

    @Transactional
    Long deleteAllByLoanMobile(@NotBlank String user);

    boolean existsByLoanMobile(@NotBlank String mobileNumber);


}
