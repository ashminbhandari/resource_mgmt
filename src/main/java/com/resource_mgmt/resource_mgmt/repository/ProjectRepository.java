package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT * FROM project WHERE project_name like %?%",
            nativeQuery = true)
    List<Project> findByProject_nameLike(String project_name);

}
