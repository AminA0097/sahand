package com.userservice.sahand.Actions;


import com.userservice.sahand.Bases.BasesEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CORE_ACTIONS")
@TableGenerator(
        name = "CORE_ACTION_SEQ",
        table = "CORE_SEQ",
        pkColumnName = "TABLE_NAME",
        valueColumnName = "SEQ_COUNT",
        pkColumnValue = "ActionsEntitySeq",
        allocationSize = 1
)
public class ActionsEntity extends BasesEntity {
    @Id
    @Column(name = "FLD_ACTION_ID")
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "CORE_ACTION_SEQ")
    private Long actionId;

    @Column(name = "ACTION_NAME")
    private String actionName;

    @Column(name = "ACTION_NAME_FA")
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
