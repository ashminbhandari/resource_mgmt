package com.resource_mgmt.resource_mgmt.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="project_resource")
public class ProjectResource {
    @Id
    @GeneratedValue
    private Integer project_resource_id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    public ProjectResource() {
    }

    public ProjectResource(Project project, Resource resource) {
        this.project = project;
        this.resource = resource;
    }
    public Integer getProject_resource_id() {
        return project_resource_id;
    }

    public void setProject_resource_id(Integer project_resource_id) {
        this.project_resource_id = project_resource_id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}

