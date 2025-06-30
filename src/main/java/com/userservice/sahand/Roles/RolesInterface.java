package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesInterface;
import com.userservice.sahand.CoreCombo.CoreComboEntity;
import com.userservice.sahand.CoreCombo.CoreComboForm;

public interface RolesInterface extends BasesInterface<RolesEntity> {
    public String setEntity(RolesForm rolesForm) throws Exception;
}
