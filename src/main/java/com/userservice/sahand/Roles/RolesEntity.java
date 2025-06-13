package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CORE_ROLES")
public class RolesEntity extends BaseEntity {
    @Id
    @Column(name = "FLD_ROLE_ID")
    private long roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;


}
