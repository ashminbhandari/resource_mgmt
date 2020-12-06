package com.resource_mgmt.resource_mgmt.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue
    private Integer project_id;

    private String project_name;

    public Project() {
    }

    public Project(String project_name) {
        this.project_name = project_name;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public String getProject_name() {
        return project_name;
    }
    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}
