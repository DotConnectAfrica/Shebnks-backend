package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.LoanApplicationModel;
import com.dotconnectafrica.shebnks_rest_api.models.SHELoansRequestModel;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SHELoansRequestRepository extends JpaRepository<SHELoansRequestModel, Long> {


    @Query(value = "select *  from  SHELoans_Requests where phone_number = :user order by id desc limit 1 ",
            nativeQuery = true
    )
    SHELoansRequestModel hasAnExistingLoanRequest(String user);

    boolean existsByPhoneNumber(@NotBlank String mobileNumber);

}
