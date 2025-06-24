package com.userservice.sahand.Action;

public class ActionSimple {
    private long actionId;
    private String actionName;
    public ActionSimple(ActionEntity e) {
        this.actionId = e.getActionId();
        this.actionName = e.getActionName();
    }
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
