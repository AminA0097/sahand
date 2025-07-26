package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesSimple;
import com.userservice.sahand.Utils.SimpleQuery;

@SimpleQuery(Query = " (e.roleId,e.roleNameTitle,e.roleName) from RolesEntity e")
public class RolesSimple extends BasesSimple {
    private long roleId;
    private String roleName;
    private String roleNameEn;

    public RolesSimple(long roleId, String roleNameTitle, String roleNameEn) {
        this.roleId = roleId;
        this.roleName = roleNameTitle;
        this.roleNameEn = roleNameEn;
    }

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

    public String getRoleNameEn() {
        return roleNameEn;
    }

    public void setRoleNameEn(String roleNameEn) {
        this.roleNameEn = roleNameEn;
    }
}
