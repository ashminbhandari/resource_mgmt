package com.resource_mgmt.resource_mgmt.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="resource")
public class Resource {
    @Id
    @GeneratedValue
    private Integer resource_id;

    private Integer resource_code;

    private String resource_name;

    public Resource() {
    }

    public Resource(Integer resource_code, String resource_name) {
        this.resource_code = resource_code;
        this.resource_name = resource_name;
    }

    public Integer getResource_id() {
        return resource_id;
    }

    public void setResource_id(Integer resource_id) {
        this.resource_id = resource_id;
    }

    public Integer getResource_code() {
        return resource_code;
    }

    public void setResource_code(Integer resource_code) {
        this.resource_code = resource_code;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

}
