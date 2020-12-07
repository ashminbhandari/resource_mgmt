package com.itlize.resrcmgmt.service;

import java.util.List;

import com.itlize.resrcmgmt.entity.ProjectColumn;

public interface ProjectColumnService {
    void addValue(String value, int pid,String column_name);
    List<ProjectColumn> getColumnsForProject(int pid);
    void addNewColumn(List<ProjectColumn> projectColumns);
    List<String> getAllColumnName();
    void deleteColumn(String column_name);
}
