package com.userservice.sahand.Actions;

import com.userservice.sahand.Bases.BasesInterface;

public interface ActionsInterface extends BasesInterface<ActionsEntity> {
    public String setEntity(ActionsForm actonsForm) throws Exception;
}
