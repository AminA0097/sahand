package com.userservice.sahand.Actions;

import com.userservice.sahand.Bases.BasesService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ActionsService extends BasesService<ActionsEntity> implements ActionsInterface {
    @Override
    @Transactional
    public String setEntity(ActionsForm actionsForm) throws Exception {
        if(actionsForm.getActionId() == -1){
            actionsForm.setActionId(null);
        }
        return super.save(actionsForm);
    }
}
