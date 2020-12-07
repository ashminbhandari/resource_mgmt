package com.itlize.resrcmgmt.service;

import java.util.List;

import com.itlize.resrcmgmt.entity.Project;


public interface ProjectService {

    List<Project> findAllByKeyword(String key);

    List<Project> findAll();

    Project findByProjectId(int id);

    void add(Project project);
}
