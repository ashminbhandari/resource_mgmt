package com.resource_mgmt.resource_mgmt.model;

import javax.persistence.*;

@Entity
@Table(name="project_column")
public class ProjectColumn {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
    private String column_name;
    private String column_value;

    public ProjectColumn(Project project, String column_name, String column_value) {
        this.project = project;
        this.column_name = column_name;
        this.column_value = column_value;
    }

    public ProjectColumn(Project project, String column_name) {
        this.project = project;
        this.column_name = column_name;
    }

    public ProjectColumn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public String getColumn_value() {
        return column_value;
    }

    public void setColumn_value(String column_value) {
        this.column_value = column_value;
    }
}
