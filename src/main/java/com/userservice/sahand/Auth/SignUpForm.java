package com.userservice.sahand.Auth;

import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Users.UsersEntity;
import com.userservice.sahand.Utils.FormFiled;

public class SignUpForm extends BasesForm {
    @FormFiled(EntityName = UsersEntity.class)
    private Long userId;
    @FormFiled(EntityName = UsersEntity.class)
    private String userName;

    @FormFiled(EntityName = UsersEntity.class)
    private String password;

    @FormFiled(EntityName = UsersEntity.class)
    private boolean isSysAdmin;

    @FormFiled(EntityName = UsersEntity.class)
    private String userAccess;

    @FormFiled(EntityName = UsersEntity.class)
    private Long roleId;

    @FormFiled(EntityName = PersonsEntity.class)
    private String firstName;

    @FormFiled(EntityName = PersonsEntity.class)
    private String lastName;

    @FormFiled(EntityName = PersonsEntity.class)
    private String companyName;

    @FormFiled(EntityName = UsersEntity.class)
    private Long statusId;

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
}
