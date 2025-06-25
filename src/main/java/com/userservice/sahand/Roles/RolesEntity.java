package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CORE_ROLES")
public class RolesEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_ROLE_ID")
    private long roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public Long getId() {
        return this.roleId;
    }
}
