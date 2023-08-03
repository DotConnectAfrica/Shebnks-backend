package com.dotconnectafrica.shebnks_rest_api.auth.security.services;


import com.dotconnectafrica.shebnks_rest_api.models.UserModel;
import com.dotconnectafrica.shebnks_rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
    UserModel user = userRepository.findByMobileNumber(phone)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with phone: " + phone));

    return UserDetailsImpl.build(user);
  }

}
