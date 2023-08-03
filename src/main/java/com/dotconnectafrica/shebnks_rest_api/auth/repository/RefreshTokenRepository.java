package com.dotconnectafrica.shebnks_rest_api.auth.repository;

import com.dotconnectafrica.shebnks_rest_api.auth.models.RefreshToken;
import com.dotconnectafrica.shebnks_rest_api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(UserModel user);
}
