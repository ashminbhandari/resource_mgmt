package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.entity.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    
}
