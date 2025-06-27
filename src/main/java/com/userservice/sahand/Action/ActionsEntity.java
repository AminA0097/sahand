package com.userservice.sahand.Action;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CORE_ACTIONS")
public class ActionsEntity {
    @Id
    @Column(name = "FLD_ACTION_ID")
    private long actionId;

    @Column(name = "ACTION_NAME")
    private String actionName;

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
}
