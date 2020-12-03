package com.resource_mgmt.resource_mgmt.service;

import com.resource_mgmt.resource_mgmt.model.ProjectResource;

import java.util.List;

public interface ProjectResourceService {
    List<ProjectResource> getAllResourceByProjectId(int id);
    void deleteResourceFromProject(int pid, int cid);
    void addResourcesForProject(List<ProjectResource> projectResources);
}
