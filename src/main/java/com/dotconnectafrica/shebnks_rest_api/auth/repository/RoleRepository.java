package com.dotconnectafrica.shebnks_rest_api.auth.repository;


import com.dotconnectafrica.shebnks_rest_api.auth.models.ERole;
import com.dotconnectafrica.shebnks_rest_api.auth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
