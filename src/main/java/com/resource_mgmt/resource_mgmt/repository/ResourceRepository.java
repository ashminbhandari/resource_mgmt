package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> { }
