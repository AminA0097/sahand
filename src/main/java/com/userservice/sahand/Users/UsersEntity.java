package com.userservice.sahand.Users;

import com.userservice.sahand.Bases.BaseEntity;
import com.userservice.sahand.CoreCombo.CoreComboEntity;
import com.userservice.sahand.Persons.PersonEntity;
import com.userservice.sahand.Action.ActionEntity;
import com.userservice.sahand.Roles.RolesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CORE_USERS")
public class UsersEntity extends BaseEntity {
    @Id
    @Column(name = "FLD_USER_ID")
    private long userId;

    @Column(name = "FLD_USER_NAME")
    private String userName;

    @Column(name = "FLD_USER_PASSWORD")
    private String password;


    @Column(name = "FLD_IS_SYS_ADMIN")
    private boolean isSysAdmin;

    @Column(name = "FLD_USER_ACCESS")
    private String userAccess;

    @ManyToOne
    @JoinColumn(name = "FLD_STATUS")
    private CoreComboEntity coreComboEntity;

    @ManyToOne
    @JoinColumn(name = "FLD_PERSON_ID")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "FLD_ACTION_ID")
    private ActionEntity action;

    @ManyToOne
    @JoinColumn(name = "FLD_ROLE_ID")
    private RolesEntity role;



}
