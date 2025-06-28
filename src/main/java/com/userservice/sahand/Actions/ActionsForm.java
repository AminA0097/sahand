package com.userservice.sahand.Actions;

import com.userservice.sahand.Bases.BasesForm;

public class ActionsForm extends BasesForm {
    private Long actionId;
    private String actionName;
    private String actionNameFa;

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionNameFa() {
        return actionNameFa;
    }

    public void setActionNameFa(String actionNameFa) {
        this.actionNameFa = actionNameFa;
    }

    @Override
    public Long getId() {
        return this.actionId;
    }
}
