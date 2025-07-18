package com.userservice.sahand.Users;

import com.userservice.sahand.Bases.BasesSimple;
import com.userservice.sahand.Utils.SimpleQuery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SimpleQuery(Query = "select e from UsersEntity e ")
public class UsersSimple extends BasesSimple {


    private Long userId;
    private String userName;
    private boolean isSysAdmin;
    private String userAccess;


    private String userStatusId;
    private String userStatusTitle;


    private Set<Long> actionsId = new HashSet<>();
    private List<String> actionsTitle = new ArrayList<>();

    private String roleId;
    private String roleTitle;


    private String personId;
    private String firstName;
    private String lastName;
    private String companyName;
    private String nationalNumber;


    public UsersSimple(UsersEntity e) {
        this.userId = e.getId();
        this.userName = (e.getUserName() == null || e.getUserName().isEmpty()) ? null : e.getUserName();
        this.isSysAdmin = e.isSysAdmin();
        this.userAccess = e.getUserAccess();

        if (e.getUserStatusId() != null) {
            this.userStatusId = e.getUserStatusId().getCoreComboId() != null
                    ? e.getUserStatusId().getCoreComboId().toString()
                    : "";
            this.userStatusTitle = e.getUserStatusId().getCoreComboTitle();
        } else {
            this.userStatusId = "";
            this.userStatusTitle = "";
        }

        if (e.getActions() != null) {
            e.getActions().forEach(action -> {
                this.actionsId.add(action.getId());
                this.actionsTitle.add(action.getActionName());
            });
        }

        if (e.getRoleId() != null) {
            this.roleId = e.getRoleId().getId() != null ? e.getRoleId().getId().toString() : "";
            this.roleTitle = e.getRoleId().getRoleName();
        } else {
            this.roleId = "";
            this.roleTitle = "";
        }

        if (e.getPersonId() != null) {
            this.personId = e.getPersonId().getId() != null ? e.getPersonId().getId().toString() : "";
            this.firstName = e.getPersonId().getFirstName();
            this.lastName = e.getPersonId().getLastName();
            this.companyName = e.getPersonId().getCompanyName();
            this.nationalNumber = e.getPersonId().getNationalNumber();
        }
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

    public List<String> getActionsTitle() {
        return actionsTitle;
    }

    public void setActionsTitle(List<String> actionsTitle) {
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
