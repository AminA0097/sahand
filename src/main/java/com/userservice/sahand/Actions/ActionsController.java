package com.userservice.sahand.Actions;

import com.userservice.sahand.Utils.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/action")
public class ActionsController {
    @Autowired
    ActionsInterface actionsInterface;

    @PostMapping("/add")
    public String addAction(@RequestBody ActionsForm actonsForm) throws Exception {
        return actionsInterface.setEntity(actonsForm);
    }

    @PostMapping("/getall")
    public List getAllActions(@RequestBody FilterRequest filterRequest) throws Exception {
        return actionsInterface.getList(filterRequest);
    }
}
