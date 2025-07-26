package com.userservice.sahand.UsersSerssion;

import com.userservice.sahand.Users.UsersEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrincipalSimple {
    private String username;
    private long userid;
    private long roleId;
    private String roleName;
    private Set<Long> actionsId = new HashSet<>();
    private List<String> actionsTitle = new ArrayList<>();

    public PrincipalSimple(UsersEntity e) {
        this.username = e.getUserName();
        this.userid = e.getUserId();
        this.roleId = e.getRoleId().getRoleId();
        this.roleName = e.getRoleId().getRoleName();
        if (e.getActions() != null) {
            e.getActions().forEach(action -> {
                this.actionsId.add(action.getId());
                this.actionsTitle.add(action.getActionName());
            });
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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

    public Set<Long> getActionsId() {
        return actionsId;
    }

    public void setActionsId(Set<Long> actionsId) {
        this.actionsId = actionsId;
    }

    public List<String> getActionsTitle() {
        return actionsTitle;
    }

    public void setActionsTitle(List<String> actionsTitle) {
        this.actionsTitle = actionsTitle;
    }
}
