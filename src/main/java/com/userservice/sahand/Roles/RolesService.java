package com.userservice.sahand.Roles;

import com.userservice.sahand.Bases.BasesService;
import com.userservice.sahand.CoreCombo.CoreComboEntity;
import com.userservice.sahand.CoreCombo.CoreComboInterface;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RolesService extends BasesService<RolesEntity> implements RolesInterface {
    @Override
    @Transactional
    public String setEntity(RolesForm rolesForm) throws Exception {
        if(rolesForm.getRoleId() == -1){
            rolesForm.setRoleId(null);
        }
        return super.save(rolesForm);
    }
}
