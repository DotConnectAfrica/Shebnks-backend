package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.SheIqModel;
import com.dotconnectafrica.shebnks_rest_api.models.UserModel;
import com.dotconnectafrica.shebnks_rest_api.models.seedFundApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SeedFundApplicationRepository extends JpaRepository<seedFundApplicationModel, Long> {

    @Query(value = "select count(Application_ID) from Seed_Fund_Application where Applicant= :user limit 1 ",
            nativeQuery = true
    )
    int checkForActiveApplication(String user);

    @Query(value = "select * from Seed_Fund_Application where Applicant= :user and Application_Status=0 order by Application_Date desc limit 1",
            nativeQuery = true
    )
    seedFundApplicationModel getApplicationStatus(String user);

    //TODO     @Query(value = "select count(Application_ID) from Seed_Fund_Application where Applicant= :user and Application_Rules_Status in (0,1) and Application_Admin_Check_Status in (0,1) and Application_Evaluation_Status in (0,1) and FUNCTION('DATEDIFF', CURRENT_DATE, applicationDate) / 365 < 3  order by Application_Date desc limit 1",
    @Query(value = "select count(Application_ID) from Seed_Fund_Application where Applicant= :user and Application_Rules_Status in (0,1) and Application_Admin_Check_Status in (0,1) and Application_Evaluation_Status in (0,1)  limit 1",
            nativeQuery = true
    )
    int getApplicationCount(String user);

    //TODO     @Query(value = "select count(Application_ID) from Seed_Fund_Application where Applicant= :user and Application_Rules_Status=1 and Application_Admin_Check_Status=1 and Application_Evaluation_Status=1 and FUNCTION('datediff', CURRENT_DATE, Application_Date) / 365  > 3 order by Application_Date desc limit 1",
    @Query(value = "select count(Application_ID) from Seed_Fund_Application where Applicant= :user and Application_Rules_Status=1 and Application_Admin_Check_Status=1 and Application_Evaluation_Status=1  limit 1",
            nativeQuery = true
    )
    int validateApplication(String user);

    @Query(value = "SELECT FUNCTION('datediff', '2022-02-28 00:00:00', '2020-02-28 00:00:00')",
            nativeQuery = true
    )
    int datediff_years();
}
