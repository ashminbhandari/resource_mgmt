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
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProjectResource {
    @Id
    @GeneratedValue
    private Integer project_resource_id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Resource resource;
}

