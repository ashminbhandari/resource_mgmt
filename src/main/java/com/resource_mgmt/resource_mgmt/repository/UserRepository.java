package com.resource_mgmt.resource_mgmt.repository;

import java.util.Optional;

import com.resource_mgmt.resource_mgmt.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

    @Query("select u from User u where u.username = ?#{principal.username}")
    User findCurrentUserInformation();
}

