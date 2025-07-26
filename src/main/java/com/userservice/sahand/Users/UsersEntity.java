package com.userservice.sahand.Users;

import com.userservice.sahand.Actions.ActionsEntity;
import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.CoreCombo.CoreComboEntity;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Roles.RolesEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "CORE_USERS")
@TableGenerator(
        name = "CORE_USER_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "UsersEntitySeq",
        allocationSize = 1
)
public class UsersEntity extends BasesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CORE_USER_SEQ")
    @Column(name = "FLD_USFER_ID")
    private Long userId;

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
    private CoreComboEntity userStatusId;

    @ManyToOne
    @JoinColumn(name = "FLD_PERSON_ID")
    private PersonsEntity personId;

    @ManyToMany
    @JoinTable(
            name = "CORE_USERS_ACTIONS",
            joinColumns = @JoinColumn(name = "FLD_USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FLD_ACTION_ID"))
    private Set<ActionsEntity> actions;

    @ManyToOne
    @JoinColumn(name = "FLD_ROLE_ID")
    private RolesEntity roleId;


    @Override
    public Long getId() {
        return this.userId;
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

    public CoreComboEntity getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(CoreComboEntity userStatusId) {
        this.userStatusId = userStatusId;
    }

    public PersonsEntity getPersonId() {
        return personId;
    }

    public void setPersonId(PersonsEntity personId) {
        this.personId = personId;
    }

    public Set<ActionsEntity> getActions() {
        return actions;
    }

    public void setActions(Set<ActionsEntity> actions) {
        this.actions = actions;
    }

    public RolesEntity getRoleId() {
        return roleId;
    }

    public void setRoleId(RolesEntity roleId) {
        this.roleId = roleId;
    }
}
