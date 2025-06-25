package com.userservice.sahand.Users;

import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.CoreCombo.CoreComboEntity;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Action.ActionEntity;
import com.userservice.sahand.Roles.RolesEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CORE_USERS")
public class UsersEntity extends BasesEntity {
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
    private CoreComboEntity userStatus;

    @ManyToOne
    @JoinColumn(name = "FLD_PERSON_ID")
    private PersonsEntity person;

    @ManyToMany
    @JoinTable(
            name = "CORE_USERS_ACTIONS",
    joinColumns = @JoinColumn(name = "FLD_USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "FLD_ACTION_ID"))
    private List<ActionEntity> actions;

    @ManyToOne
    @JoinColumn(name = "FLD_ROLE_ID")
    private RolesEntity role;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public CoreComboEntity getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(CoreComboEntity userStatus) {
        this.userStatus = userStatus;
    }

    public PersonsEntity getPerson() {
        return person;
    }

    public void setPerson(PersonsEntity person) {
        this.person = person;
    }

    public List<ActionEntity> getActions() {
        return actions;
    }

    public void setActions(List<ActionEntity> actions) {
        this.actions = actions;
    }

    public RolesEntity getRole() {
        return role;
    }

    public void setRole(RolesEntity role) {
        this.role = role;
    }

    @Override
    public Long getId() {
        return this.userId;
    }
}
