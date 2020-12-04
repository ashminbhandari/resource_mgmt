package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.entity.Resource;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Resource, Integer> {
}
