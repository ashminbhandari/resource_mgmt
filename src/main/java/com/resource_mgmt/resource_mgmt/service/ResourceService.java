package com.resource_mgmt.resource_mgmt.service;

import com.resource_mgmt.resource_mgmt.entity.Resource;
import com.resource_mgmt.resource_mgmt.repository.ColumnAddedRepository;
import com.resource_mgmt.resource_mgmt.repository.ColumnAddedRowValueRepository;
import com.resource_mgmt.resource_mgmt.repository.ResourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ColumnAddedRepository columnAddedRepository;

    @Autowired
    ColumnAddedRowValueRepository columnAddedRowValueRepository;

    public ResourceService() {
    }

    public Page<Resource> getAllResources(Integer page, Integer size) {
        try {
            Page pageOfResources = resourceRepository.getAll(PageRequest.of(page, size));
            return pageOfResources;
        } catch (Exception e) {
            throw e;
        }
    }

    public Page<Resource> findByKeyword(Integer page, Integer size, String keyword) {
        try {
            Page pageOfResources = resourceRepository.findByKeyword(PageRequest.of(page, size), keyword);
            return pageOfResources;
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<?> updateResource(int resource_id, int resource_code, String resource_name) throws Exception {
        int rowsUpdated = resourceRepository.updateResource(resource_id, resource_code, resource_name);
        if (rowsUpdated > 0) return ResponseEntity.ok("Resource ID "  + resource_id + " has successfully been updated.");
        else throw new Exception(resource_id + " does not exist or some other error occured.");
    }

    public ResponseEntity<?> addColumn(String column_name) {
        try {
            columnAddedRepository.addColumn(column_name);
            return ResponseEntity.ok("Column " + column_name + " has been successfully added to the resource table.");
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<?> addRowValueToColumn(String column_name, int resource_id, String row_value) throws Exception {
        int rows_affected = columnAddedRowValueRepository.addRowValue(column_name, resource_id, row_value);
        if (rows_affected > 0) return ResponseEntity.ok("Row value " + row_value + " has been added to column " + column_name);
        else throw new Exception("Column " + column_name + " does not exist or some other error occured.");
    }
}
