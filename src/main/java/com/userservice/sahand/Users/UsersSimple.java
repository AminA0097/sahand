package com.userservice.sahand.Users;

import com.userservice.sahand.Action.ActionEntity;
import com.userservice.sahand.Action.ActionSimple;

import java.util.List;
import java.util.Set;

public class UsersSimple {
    private String firstName;
    private String lastName;
    private String companyName;
    private String userName;
    private String password;
    private long roleId;
    private String roleName;
    private List<ActionEntity> actions;

    public UsersSimple(UsersEntity e) {
        this.firstName = e.getPerson().getFirstName();
        this.lastName = e.getPerson().getLastName();
        this.companyName = e.getPerson().getCompanyName();
        this.userName = e.getUserName();
        this.password = e.getPassword();
        this.roleId = e.getRole().getRoleId();
        this.roleName = e.getRole().getRoleName();
        this.actions = e.getActions();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<ActionEntity> getActions() {
        return actions;
    }

    public void setActions(List<ActionEntity> actions) {
        this.actions = actions;
    }
}

