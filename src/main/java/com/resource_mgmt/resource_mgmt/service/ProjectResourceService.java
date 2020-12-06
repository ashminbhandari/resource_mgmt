package com.resource_mgmt.resource_mgmt.service;

import com.resource_mgmt.resource_mgmt.entity.ProjectResource;

import java.util.List;

public interface ProjectResourceService {
    List<ProjectResource> getAllResourceByProjectId(int id);
    void deleteResourceFromProject(int pid, int rid);
    void addResourcesForProject(List<ProjectResource> projectResources);
    boolean isHave(int pid, int rid);
}
