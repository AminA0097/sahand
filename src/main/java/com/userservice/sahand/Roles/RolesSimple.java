package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesSimple;
import com.userservice.sahand.Utils.SimpleQuery;

@SimpleQuery(Query = " (e.roleId,e.roleNameTitle) from RolesEntity e")
public class RolesSimple extends BasesSimple {
    private long roleId;
    private String roleName;

    public RolesSimple(long roleId, String roleNameTitle) {
        this.roleId = roleId;
        this.roleName = roleNameTitle;
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
}
