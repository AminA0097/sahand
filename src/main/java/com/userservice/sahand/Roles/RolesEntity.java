package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CORE_ROLES")
@TableGenerator(
        name = "CORE_ROLE_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "RolesEntitySeq",
        allocationSize = 1
)
public class RolesEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_ROLE_ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CORE_ROLE_SEQ")
    private Long roleId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "ROLE_NAME_TITLE")
    private String roleNameTitle;

    public String getRoleNameTitle() {
        return roleNameTitle;
    }

    public void setRoleNameTitle(String roleNameTitle) {
        this.roleNameTitle = roleNameTitle;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
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
