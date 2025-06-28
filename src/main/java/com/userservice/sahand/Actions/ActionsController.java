package com.userservice.sahand.Actions;

import com.userservice.sahand.Utils.Remote;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
public class ActionsController {
    @PostMapping("/add")
    public String addAction(@RequestBody ActionsForm actonsForm) throws Exception{
        ActionsInterface actionsInterface = (ActionsInterface) Remote.makeRemote(ActionsInterface.class);
        if(actonsForm.getActionId() == -1){
            actonsForm.setActionId(null);
        }
        return actionsInterface.save(actonsForm);
    }
}
