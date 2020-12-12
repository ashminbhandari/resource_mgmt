package com.itlize.resrcmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.itlize.resrcmgmt.entity.ProjectResource;
import com.itlize.resrcmgmt.repository.ProjectResourceRepository;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService{

    @Autowired
    ProjectResourceRepository projectResourceRepository;

    @Override
    public boolean isHave(int pid, int rid) {
        ProjectResource projectResource = projectResourceRepository.findByProjectAndResource(pid,rid);
        return projectResource!=null;
    }

    @Override
    public List<ProjectResource> getAllResourceByProjectId(int id) {
        return projectResourceRepository.findAllByProject(id);
    }

    @Override
    public void deleteResourceFromProject(int pid, int rid) {
        projectResourceRepository.deleteResource(pid,rid);
    }

    @Override
    public void addResourcesForProject(List<ProjectResource> projectResources) {
        projectResourceRepository.saveAll(projectResources);
    }
}
