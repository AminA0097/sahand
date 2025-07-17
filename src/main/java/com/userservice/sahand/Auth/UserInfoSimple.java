package com.userservice.sahand.Auth;

import com.userservice.sahand.Bases.BasesSimple;
import com.userservice.sahand.Users.UsersEntity;

import java.util.HashSet;
import java.util.Set;

public class UserInfoSimple extends BasesSimple {
    private Long formId;

    private Long userId;
    private String userName;
    private boolean isSysAdmin;
    private String userAccess;

    private String userStatusId;
    private String userStatusTitle;

    private Set<Long> actionsId;
    private Set<String> actionsTitle;

    private String roleId;
    private String roleTitle;

    private String personId;
    private String firstName;
    private String lastName;
    private String companyName;
    private String nationalNumber;

    public UserInfoSimple(UsersEntity e) {
        this.userId = e.getId();
        this.userName = e.getUserName();
        this.isSysAdmin = e.isSysAdmin();
        this.userAccess = e.getUserAccess();

        this.userStatusId = e.getUserStatusId().getId().toString();
        this.userStatusTitle = e.getUserStatusId().getCoreComboName();

        this.actionsId = new HashSet<>();
        this.actionsTitle = new HashSet<>();

        e.getActions().forEach(action -> {
            this.actionsId.add(action.getId());
            this.actionsTitle.add(action.getActionName());
        });

        this.roleId = e.getRoleId().getId().toString();
        this.roleTitle = e.getRoleId().getRoleName();

        this.personId = e.getPersonId().getId().toString();
        this.firstName = e.getPersonId().getFirstName();
        this.lastName = e.getPersonId().getLastName();
        this.companyName = e.getPersonId().getCompanyName();
        this.nationalNumber = e.getPersonId().getNationalNumber();

    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(String userStatusId) {
        this.userStatusId = userStatusId;
    }

    public String getUserStatusTitle() {
        return userStatusTitle;
    }

    public void setUserStatusTitle(String userStatusTitle) {
        this.userStatusTitle = userStatusTitle;
    }

    public Set<Long> getActionsId() {
        return actionsId;
    }

    public void setActionsId(Set<Long> actionsId) {
        this.actionsId = actionsId;
    }

    public Set<String> getActionsTitle() {
        return actionsTitle;
    }

    public void setActionsTitle(Set<String> actionsTitle) {
        this.actionsTitle = actionsTitle;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }
    
}

