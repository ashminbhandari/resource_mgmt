package com.itlize.resrcmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.itlize.resrcmgmt.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT * FROM project WHERE project_name like %?%",
            nativeQuery = true)
    List<Project> findByProject_nameLike(String project_name);

}
