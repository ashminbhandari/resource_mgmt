package com.itlize.resrcmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.itlize.resrcmgmt.entity.Project;
import com.itlize.resrcmgmt.repository.ProjectRepository;

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
