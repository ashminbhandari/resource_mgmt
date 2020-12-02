package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> { }
