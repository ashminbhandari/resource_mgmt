package com.itlize.resrcmgmt.entity;


import java.util.Map;

public class ProjectColumnValue {

    private Project project;
    private Map<String,String> column_value;

    public ProjectColumnValue(Project project, Map<String, String> column_value) {
        this.project = project;
        this.column_value = column_value;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Map<String, String> getColumn_value() {
        return column_value;
    }

    public void setColumn_value(Map<String, String> column_value) {
        this.column_value = column_value;
    }
}
