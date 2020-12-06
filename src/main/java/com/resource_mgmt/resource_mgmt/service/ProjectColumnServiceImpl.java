package com.resource_mgmt.resource_mgmt.service;

import com.resource_mgmt.resource_mgmt.model.ProjectColumn;
import com.resource_mgmt.resource_mgmt.repository.ProjectColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
