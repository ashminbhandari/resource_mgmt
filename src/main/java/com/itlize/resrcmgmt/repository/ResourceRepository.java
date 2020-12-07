package com.itlize.resrcmgmt.repository;

import com.itlize.resrcmgmt.entity.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ResourceRepository extends PagingAndSortingRepository<Resource, Integer> {
    @Query(value = "select resource.resource_id, resource.resource_name, resource.resource_code, column_added_row_value_id, column_added_name, row_value from resource left outer join column_added_row_value carv on resource.resource_id = carv.resource_id", nativeQuery = true)
    Page<Resource> getAll(Pageable pageable);

    @Query("select c from Resource c where c.resource_name like %:keyword% or c.resource_code like %:keyword%")
    Page<Resource> findByKeyword(Pageable pageable, String keyword);

    @Query("update Resource r set r.resource_name = :resource_name, r.resource_code = :resource_code where r.resource_id = :resource_id")
    @Modifying
    @Transactional
    int updateResource(int resource_id, int resource_code, String resource_name);
}

