package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.LoanApplicationModel;
import com.dotconnectafrica.shebnks_rest_api.models.LoanCategoriesModel;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoanCategoriesRepository extends JpaRepository<LoanCategoriesModel, Long> {

    @Query(value = "select * from Loan_Categories where loan_category_name = :loan_category_name  limit 1",
            nativeQuery = true
    )
    LoanCategoriesModel getLoanDetails(String loan_category_name);

    LoanCategoriesModel findByLoanCategoryName(String loan_category_name);

    boolean existsByLoanCategoryName(@NotBlank String LoanCategoryName);


}
