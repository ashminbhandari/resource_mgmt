package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByProject_nameLike(String project_name);

}
