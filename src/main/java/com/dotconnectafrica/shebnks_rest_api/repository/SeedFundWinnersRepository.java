package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.seedFundApplicationModel;
import com.dotconnectafrica.shebnks_rest_api.models.seedFundWinnersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeedFundWinnersRepository extends JpaRepository<seedFundWinnersModel, Long> {

}
