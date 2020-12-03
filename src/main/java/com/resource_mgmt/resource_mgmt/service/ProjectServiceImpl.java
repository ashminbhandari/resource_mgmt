package com.resource_mgmt.resource_mgmt.service;

import com.resource_mgmt.resource_mgmt.model.Project;
import com.resource_mgmt.resource_mgmt.model.ProjectResource;
import com.resource_mgmt.resource_mgmt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> findAllByKeyword(String key) {
        return projectRepository.findByProject_nameLike(key);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findByProjectId(int id) {
        return projectRepository.findById(id).orElse(new Project());
    }

    @Override
    public void add(Project project) {
        projectRepository.save(project);
    }
}
