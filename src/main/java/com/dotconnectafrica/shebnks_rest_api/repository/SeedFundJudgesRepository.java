package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.seedFundJudgesModel;
import com.dotconnectafrica.shebnks_rest_api.models.seedFundWinnersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeedFundJudgesRepository extends JpaRepository<seedFundJudgesModel, Long> {

}
