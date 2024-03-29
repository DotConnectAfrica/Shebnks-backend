package com.dotconnectafrica.shebnks_rest_api.auth.security.services;

import com.dotconnectafrica.shebnks_rest_api.models.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private BigInteger id;

  private String username;



  @JsonIgnore
  private String password;


  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(BigInteger id, String username, String password,
                         Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.authorities = authorities;

  }

  public static UserDetailsImpl build(UserModel user) {
    List<GrantedAuthority> authorities = new ArrayList<>(); /*= user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority("ROLE_USER"))
        .collect(Collectors.toList());*/

    return new UserDetailsImpl(
        user.getUserId(),
        user.getMobileNumber(),
        user.getPassword(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public BigInteger getId() {
    return id;
  }


  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
