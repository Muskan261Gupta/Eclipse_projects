package com.example.SpringSecurityJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringSecurityJWT.entity.UserClass;

public interface UserRepository extends JpaRepository<UserClass, Integer>{


	UserClass findByUserName(String username);

}
