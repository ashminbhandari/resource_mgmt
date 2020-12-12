package com.itlize.resrcmgmt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource {
    @Id
    @GeneratedValue
    private Integer resource_id;

    private String resource_code;

    private String resource_name;

    public Resource() {
    }

    public Resource(String resource_code, String resource_name) {
        this.resource_code = resource_code;
        this.resource_name = resource_name;
    }

    public Integer getResource_id() {
        return resource_id;
    }

    public void setResource_id(Integer resource_id) {
        this.resource_id = resource_id;
    }

    public String getResource_code() {
        return resource_code;
    }

    public void setResource_code(String resource_code) {
        this.resource_code = resource_code;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

}
