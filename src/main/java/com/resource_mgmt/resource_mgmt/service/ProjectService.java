package com.resource_mgmt.resource_mgmt.service;

import com.resource_mgmt.resource_mgmt.entity.Project;

import java.util.List;


public interface ProjectService {

    List<Project> findAllByKeyword(String key);

    List<Project> findAll();

    Project findByProjectId(int id);

    void add(Project project);
}
