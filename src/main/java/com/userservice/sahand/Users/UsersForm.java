package com.userservice.sahand.Users;

import com.userservice.sahand.Actions.ActionsEntity;
import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.CoreCombo.CoreComboEntity;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Roles.RolesEntity;
import com.userservice.sahand.Utils.RelatedFiled;
import com.userservice.sahand.Utils.RelatedManyToMany;
import com.userservice.sahand.Utils.WhatFiled;

import java.util.Set;

public class UsersForm extends BasesForm {
    private Long personId;
    private String personTitle;
    @RelatedFiled(EntityName = PersonsEntity.class)
    @WhatFiled(type = WhatFiled.whatTypes.ManyToOne)
    public Long getPersonId() {
        return personId;
    }
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    public String getPersonTitle() {
        return personTitle;
    }
    public void setPersonTitle(String personTitle) {
        this.personTitle = personTitle;
    }

    private Long roleId;
    @RelatedFiled(EntityName = RolesEntity.class)
    @WhatFiled(type = WhatFiled.whatTypes.ManyToOne)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    private Long userId;
    @WhatFiled(type = WhatFiled.whatTypes.Long)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    private String userName;
    @WhatFiled()
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private String password;
    @WhatFiled()
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private boolean isSysAdmin;
    @WhatFiled(type = WhatFiled.whatTypes.Boolean)
    public boolean isSysAdmin() {
        return isSysAdmin;
    }

    public void setSysAdmin(boolean sysAdmin) {
        isSysAdmin = sysAdmin;
    }
    private String userAccess;
    @WhatFiled()
    public String getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }
    private Long userStatusId;
    @RelatedFiled(EntityName = CoreComboEntity.class)
    @WhatFiled(type = WhatFiled.whatTypes.ManyToOne)
    public Long getUserStatusId() {
        return userStatusId;
    }
    public void setUserStatusId(Long userStatusId) {
        this.userStatusId = userStatusId;
    }

    private Set<Long> actions;
    @RelatedFiled(EntityName = ActionsEntity.class)
    @WhatFiled(type = WhatFiled.whatTypes.ManyToMany)
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
