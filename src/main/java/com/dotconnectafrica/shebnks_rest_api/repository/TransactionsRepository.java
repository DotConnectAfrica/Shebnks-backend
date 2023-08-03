package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.exception.GoodRequestException;
import com.dotconnectafrica.shebnks_rest_api.models.TransactionsModel;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;


@Repository
public interface TransactionsRepository extends PagingAndSortingRepository<TransactionsModel, Long> /*JpaRepository<TransactionsModel, Long>*/ {


    @Query(value = "SELECT ref FROM payment_transactions order by id DESC LIMIT 1",
            nativeQuery = true
    )
    String generateReference();

    @Query(value = "SELECT created_at FROM payment_transactions w where w.user_mobile = ?1 order by id DESC LIMIT 1",
            nativeQuery = true
    )
    String getUserTransactionTimeStamp(String user);


    //findTopByUserOrderByIdDesc


    TransactionsModel findTopByUserAndPaymentRefOrderByIdDesc(String user,  String paymentRef);



    Boolean existsByUser(@NotBlank String user);


    Optional<TransactionsModel> findByRef(@NotBlank String ref);

    Optional<TransactionsModel> findByReference(@NotBlank String reference);

    default TransactionsModel getTransactionByRef(String ref) {
        return findByRef(ref)
                .orElseThrow(() -> new GoodRequestException(new ApiResponse(Boolean.TRUE, "Oops! An error occurred"))) ;
    }

    default TransactionsModel getTransactionByReference(String reference) {
        return findByReference(reference)
                .orElseThrow(() -> new GoodRequestException(new ApiResponse(Boolean.TRUE, "Oops! An error occurred"))) ;
    }

    Optional<TransactionsModel> findById(@NotBlank Long id);


    TransactionsModel findTopByReferenceOrderByIdDesc(String reference);

    Boolean existsByReference(@NotBlank String reference);

}
