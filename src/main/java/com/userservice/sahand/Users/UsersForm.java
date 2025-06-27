package com.userservice.sahand.Users;

import com.userservice.sahand.Action.ActionsEntity;
import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.CoreCombo.CoreComboEntity;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Roles.RolesEntity;
import com.userservice.sahand.Utils.RelatedFiled;
import com.userservice.sahand.Utils.RelatedManyToMany;

import java.util.Set;

public class UsersForm extends BasesForm {
    private Long userId;

    private String userName;

    private String password;

    private boolean isSysAdmin;

    private String userAccess;

    @RelatedFiled(EntityName = CoreComboEntity.class)
    private Long userStatus;

    @RelatedFiled(EntityName = PersonsEntity.class)
    private Long person;

    @RelatedFiled(EntityName = RolesEntity.class)
    private Long role;

    @RelatedManyToMany(EntityName = ActionsEntity.class)
    private Set<Long> actions;

    @Override
    public Long getId() {
        return this.userId;
    }
}
