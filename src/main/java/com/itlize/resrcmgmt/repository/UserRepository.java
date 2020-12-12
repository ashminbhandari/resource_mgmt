package com.itlize.resrcmgmt.repository;

import java.util.Optional;

import com.itlize.resrcmgmt.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

    @Query("select u from User u where u.username = ?#{principal.username}")
    User findCurrentUserInformation();
}

