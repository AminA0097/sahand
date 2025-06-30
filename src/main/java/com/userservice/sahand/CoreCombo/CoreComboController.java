package com.userservice.sahand.CoreCombo;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combo")
public class CoreComboController {
    @Autowired
    private CoreComboInterface coreCombo;
    @PostMapping("/add")
    public String addCombo(@RequestBody CoreComboForm coreComboForm)throws Exception{
        return coreCombo.setEntity(coreComboForm);
    }
}
