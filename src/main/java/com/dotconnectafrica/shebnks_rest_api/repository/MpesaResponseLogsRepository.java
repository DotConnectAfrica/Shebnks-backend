package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.MpesaResponseLogsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface MpesaResponseLogsRepository extends JpaRepository<MpesaResponseLogsModel, Long> {


    Optional<MpesaResponseLogsModel> findTopByCheckoutRequestIDOrderByIdDesc(@NotBlank String CheckoutRequestID);

}
