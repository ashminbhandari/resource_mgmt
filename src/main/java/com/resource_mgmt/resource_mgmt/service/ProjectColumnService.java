package com.resource_mgmt.resource_mgmt.service;

import com.resource_mgmt.resource_mgmt.entity.ProjectColumn;

import java.util.List;

public interface ProjectColumnService {
    void addValue(String value, int pid,String column_name);
    List<ProjectColumn> getColumnsForProject(int pid);
    void addNewColumn(List<ProjectColumn> projectColumns);
    List<String> getAllColumnName();
    void deleteColumn(String column_name);
}
