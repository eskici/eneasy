package com.moss.project.eneasy.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moss.project.eneasy.model.UserEntity;

@Service("assembler")
public class Assembler {

  @Transactional(readOnly = true)
  User buildUserFromUserEntity(UserEntity userEntity) {

    String username = userEntity.getUsername();
    String password = userEntity.getPassword();
//    boolean enabled = userEntity.isActive();
//    boolean accountNonExpired = userEntity.isActive();
//    boolean credentialsNonExpired = userEntity.isActive();
//    boolean accountNonLocked = userEntity.isActive();

     GrantedAuthority[] arr= {new GrantedAuthorityImpl(userEntity.getRole())};

    User user = new User(username, password, true, arr);
    return user;
  }
}