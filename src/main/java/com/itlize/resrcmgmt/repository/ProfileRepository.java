package com.itlize.resrcmgmt.repository;

import com.itlize.resrcmgmt.entity.Profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    
}
