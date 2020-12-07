package com.itlize.resrcmgmt.service;

import java.util.List;

import com.itlize.resrcmgmt.entity.ProjectColumn;
import com.itlize.resrcmgmt.repository.ProjectColumnRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectColumnServiceImpl implements ProjectColumnService {
    @Autowired
    ProjectColumnRepository projectColumnRepository;
    @Override
    public void addValue(String value, int pid, String column_name) {
        projectColumnRepository.addValue(value,pid,column_name);
    }

    @Override
    public List<ProjectColumn> getColumnsForProject(int pid) {
        return projectColumnRepository.getByProject_id(pid);
    }

    @Override
    public void addNewColumn(List<ProjectColumn> projectColumns) {
        projectColumnRepository.saveAll(projectColumns);
    }

    @Override
    public List<String> getAllColumnName() {
        return projectColumnRepository.getAllColumnName();
    }

    @Override
    public void deleteColumn(String column_name) {
        projectColumnRepository.deleteAllByColumn_name(column_name);
    }
}
