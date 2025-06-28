package com.userservice.sahand.UserSession;

import com.userservice.sahand.Actions.ActionsEntity;
import com.userservice.sahand.Users.UsersEntity;

import java.util.Set;

public class UserSessionSimple {
    public String username;
    public long userid;
    public long roleId;
    public Set<ActionsEntity> actions;

    public UserSessionSimple(UsersEntity e) {
        this.username = e.getUserName();
        this.userid = e.getUserId();
        this.roleId = e.getRole().getRoleId();
        this.actions = e.getActions();
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

    public Set<ActionsEntity> getActions() {
        return actions;
    }

    public void setActions(Set<ActionsEntity> actions) {
        this.actions = actions;
    }
}
