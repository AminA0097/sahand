package com.userservice.sahand.Auth;

import com.userservice.sahand.Bases.BasesForm;

import java.util.Set;


public  class SignUpForm extends BasesForm {
    private Long personId;
    private Long userId;
    private String userName;
    private String password;
    private boolean isSysAdmin;
    private String userAccess;
    private Long roleId;
    private Long statusId;
    private Set<Long> actions;

    public Set<Long> getActions() {
        return actions;
    }

    public void setActions(Set<Long> actions) {
        this.actions = actions;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public boolean isSysAdmin() {
        return isSysAdmin;
    }

    public void setSysAdmin(boolean sysAdmin) {
        isSysAdmin = sysAdmin;
    }

    public String getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Override
    public Long getId() {
        return this.personId;
    }
}
