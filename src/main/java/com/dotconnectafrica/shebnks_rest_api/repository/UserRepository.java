package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.models.LoanApplicationModel;
import com.dotconnectafrica.shebnks_rest_api.models.UserModel;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUserId(@NotBlank int userId);

    Boolean existsByMobileNumberOrEmailAddressOrIdNumber(@NotBlank String MobileNumber, @NotBlank String EmailAddress, @NotBlank String IdNumber);


    Optional<UserModel> findByMobileNumber(@NotBlank String mobileNumber);


    boolean existsByMobileNumber(@NotBlank String mobileNumber);

    boolean existsByUserId(@NotBlank BigInteger userId);

    @Query(value = "select * from App_Users where Mobile_Number= :user limit 1",
            nativeQuery = true
    )
    UserModel getLoanApplicationData(String user);

    @Transactional
    Long deleteByMobileNumber(@NotBlank String mobileNumber);
}
