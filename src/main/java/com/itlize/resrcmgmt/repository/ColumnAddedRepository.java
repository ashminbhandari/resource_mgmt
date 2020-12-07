package com.itlize.resrcmgmt.repository;

import com.itlize.resrcmgmt.entity.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ColumnAddedRepository extends JpaRepository<Resource, Integer> {
    @Modifying
    @Query(value="insert into column_added (column_added_name) values(:column_name)", nativeQuery=true)
    @Transactional
    int addColumn(String column_name);
}