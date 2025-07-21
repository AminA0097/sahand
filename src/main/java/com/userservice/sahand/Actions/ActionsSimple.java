package com.userservice.sahand.Actions;

import com.userservice.sahand.Bases.BasesSimple;
import com.userservice.sahand.Utils.SimpleQuery;

@SimpleQuery(Query = " (e.actionId,e.actionName) from ActionsEntity e")
public class ActionsSimple extends BasesSimple {
    private long actionId;
    private String actionName;

    public ActionsSimple(long actionId, String actionName) {
        this.actionId = actionId;
        this.actionName = actionName;
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
