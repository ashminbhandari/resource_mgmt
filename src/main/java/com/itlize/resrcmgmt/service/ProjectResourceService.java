package com.itlize.resrcmgmt.service;

import java.util.List;

import com.itlize.resrcmgmt.entity.ProjectResource;

public interface ProjectResourceService {
    List<ProjectResource> getAllResourceByProjectId(int id);
    void deleteResourceFromProject(int pid, int rid);
    void addResourcesForProject(List<ProjectResource> projectResources);
    boolean isHave(int pid, int rid);
}
