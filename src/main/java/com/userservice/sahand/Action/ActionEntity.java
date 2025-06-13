package com.userservice.sahand.Action;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CORE_ACTIONS")
public class ActionEntity {
    @Id
    @Column(name = "FLD_ACTION_ID")
    private int actionId;

    @Column(name = "ACTION_NAME")
    private String actionName;

}
