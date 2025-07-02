package com.userservice.sahand.Users;

import com.userservice.sahand.Actions.ActionsEntity;
import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.CoreCombo.CoreComboEntity;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Roles.RolesEntity;
import com.userservice.sahand.Utils.RelatedFiled;
import com.userservice.sahand.Utils.RelatedManyToMany;

import java.util.Set;

public class UsersForm extends BasesForm {
    @RelatedFiled(EntityName = PersonsEntity.class)
    private Long person;

    @RelatedFiled(EntityName = RolesEntity.class)
    private Long role;
    private Long userId;

    private String userName;

    private String password;

    private boolean isSysAdmin;

    private String userAccess;

    @RelatedFiled(EntityName = CoreComboEntity.class)
    private Long userStatus;

    @RelatedManyToMany(EntityName = ActionsEntity.class,M2mTable = "core_users_actions")
    private Set<Long> actions;

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

    public Long getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Long userStatus) {
        this.userStatus = userStatus;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public Set<Long> getActions() {
        return actions;
    }

    public void setActions(Set<Long> actions) {
        this.actions = actions;
    }

    @Override
    public Long getId() {
        return this.userId;
    }
}
