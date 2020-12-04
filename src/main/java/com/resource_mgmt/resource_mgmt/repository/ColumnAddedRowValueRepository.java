package com.resource_mgmt.resource_mgmt.repository;

import com.resource_mgmt.resource_mgmt.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ColumnAddedRowValueRepository extends JpaRepository<Resource, Integer> {
    @Modifying
    @Query(value = "insert into column_added_row_value (column_added_name,resource_id, row_value) VALUES (:column_name,:resource_id, :row_value)", nativeQuery = true)
    @Transactional
    int addRowValue(String column_name, int resource_id, String row_value);
}