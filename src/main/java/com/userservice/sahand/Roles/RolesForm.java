package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesForm;

public class RolesForm extends BasesForm {
    private Long roleId;
    private String roleName;
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

