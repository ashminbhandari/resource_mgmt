package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.model.ProjectColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProjectColumnRepository extends JpaRepository<ProjectColumn,Integer> {
    @Query(value="select column_value from project_column where project_id=?1 and column_name=?2",nativeQuery = true)
    String getValue(int pid,String column);

    @Modifying
    @Transactional
    @Query(value="update project_column set column_value=?1 where project_id=?2 and column_name=?3",nativeQuery = true)
    void addValue(String value, int pid,String column);

    @Query(value="select * from project_column where project_id=?1",nativeQuery = true)
    List<ProjectColumn> getByProject_id(int id);

    @Query(value="select distinct column_name from project_column",nativeQuery = true)
    List<String> getAllColumnName();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM project_column WHERE column_name =?1", nativeQuery = true)
    void deleteAllByColumn_name(String column_name);
}
