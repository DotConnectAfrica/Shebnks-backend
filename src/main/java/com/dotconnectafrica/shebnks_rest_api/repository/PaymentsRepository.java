package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.exception.GoodRequestException;
import com.dotconnectafrica.shebnks_rest_api.models.PaymentsModel;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface PaymentsRepository extends JpaRepository<PaymentsModel, Long> {

    Boolean existsByTransId(@NotBlank String TransId);

    Optional<PaymentsModel> findTopByTransIdOrderByIdDesc(@NotBlank String transId);

    default PaymentsModel getTransId(String transId) {
        return findTopByTransIdOrderByIdDesc(transId)
                .orElseThrow(() -> new GoodRequestException(new ApiResponse(Boolean.TRUE, "Oops! An error occurred"))) ;
    }
}
