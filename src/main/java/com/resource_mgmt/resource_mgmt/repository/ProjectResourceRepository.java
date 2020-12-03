package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.model.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {

    List<ProjectResource> findAllByProject(int pid);

    void deleteByProjectAndResource(int pid,int rid);


}
