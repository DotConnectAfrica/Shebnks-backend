package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.PaymentB2CLogsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsB2CLogsRepository extends JpaRepository<PaymentB2CLogsModel, Long> {

}
