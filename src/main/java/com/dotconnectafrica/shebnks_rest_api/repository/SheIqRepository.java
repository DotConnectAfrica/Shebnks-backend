package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.LoanApplicationModel;
import com.dotconnectafrica.shebnks_rest_api.models.SheIqModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;


@Repository
public interface SheIqRepository extends JpaRepository<SheIqModel, Long> {

}
