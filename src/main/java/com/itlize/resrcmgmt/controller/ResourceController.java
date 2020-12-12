package com.itlize.resrcmgmt.controller;

import com.itlize.resrcmgmt.entity.Resource;
import com.itlize.resrcmgmt.service.ResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/get")
    public Page<Resource> getResources(@RequestParam int page, @RequestParam int size) {
        return resourceService.getAllResources(page, size);
    }

    @GetMapping("/search")
    public Page<Resource> getResources(@RequestParam int page, @RequestParam int size, @RequestParam String keyword) {
        return resourceService.findByKeyword(page, size, keyword);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateResource(@RequestParam int resource_id, @RequestParam int resource_code, @RequestParam String resource_name) throws Exception {
        return resourceService.updateResource(resource_id, resource_code, resource_name);
    }

    @PostMapping("/addColumn")
    public ResponseEntity<?> addColumn(@RequestParam String column_name) {
        return resourceService.addColumn(column_name);
    }

    @PostMapping("/addRowValueToColumnForCertainResource")
    public ResponseEntity<?> addRowValueToColumn(@RequestParam String column_name, int resource_id, String row_value) throws Exception {
        return resourceService.addRowValueToColumn(column_name, resource_id, row_value);
    }
}

