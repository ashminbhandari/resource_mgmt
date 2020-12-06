package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource,Integer> {

    @Query(value = "SELECT * FROM project_resource WHERE project_id = ?1",
            nativeQuery = true)
    List<ProjectResource> findAllByProject(int pid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM project_resource WHERE project_id = ?1 and resource_id=?2", nativeQuery = true)
    void deleteResource(int pid, int rid);

    @Query(value="select * from project_resource where project_id=?1 and resource_id=?2", nativeQuery = true)
    ProjectResource findByProjectAndResource(int pid, int cid);

}
