package com.resource_mgmt.resource_mgmt.model;

import com.resource_mgmt.resource_mgmt.enums.Role;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue // generation type default is auto
    private Integer user_id;

    private String user_username;

    private String user_password;

    @CreatedDate
    private Date user_timeCreated;

    @LastModifiedDate
    private Date user_lastUpdated;

    @Enumerated(EnumType.STRING)
    private Role user_role;
}
