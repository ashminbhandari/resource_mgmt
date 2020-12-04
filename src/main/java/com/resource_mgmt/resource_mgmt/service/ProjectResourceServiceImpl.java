package com.resource_mgmt.resource_mgmt.service;

import com.resource_mgmt.resource_mgmt.model.ProjectResource;
import com.resource_mgmt.resource_mgmt.repository.ProjectResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService{

    @Autowired
    ProjectResourceRepository projectResourceRepository;
    @Override
    public List<ProjectResource> getAllResourceByProjectId(int id) {
        return projectResourceRepository.findAllByProject(id);
    }

    @Override
    public void deleteResourceFromProject(int pid, int cid) {
        projectResourceRepository.deleteResource(pid,cid);
    }

    @Override
    public void addResourcesForProject(List<ProjectResource> projectResources) {
        projectResourceRepository.saveAll(projectResources);
    }
}
