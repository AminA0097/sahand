package com.userservice.sahand.CoreCombo;

import com.userservice.sahand.Actions.ActionsEntity;
import com.userservice.sahand.Actions.ActionsInterface;
import com.userservice.sahand.Bases.BasesService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CoreComboService extends BasesService<CoreComboEntity> implements CoreComboInterface {
    @Override
    @Transactional
    public String setEntity(CoreComboForm coreComboForm) throws Exception {
        if(coreComboForm.getId() == -1){
            coreComboForm.setCoreComboId(null);
        }
        return super.save(coreComboForm);
    }
}
