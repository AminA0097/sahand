package com.userservice.sahand.CoreCombo;
import com.userservice.sahand.Actions.ActionsForm;
import com.userservice.sahand.Bases.BasesInterface;

public interface CoreComboInterface extends BasesInterface<CoreComboEntity> {
    public String setEntity(CoreComboForm coreComboForm) throws Exception;
}
