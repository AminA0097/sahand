package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesSimple;
import com.userservice.sahand.Utils.SimpleQuery;

@SimpleQuery(Query = " (e.roleId,e.roleName) from RolesEntity e")
public class RolesSimple extends BasesSimple {
    private long roleId;
    private String roleName;

    public RolesSimple(long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
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
