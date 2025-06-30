package com.userservice.sahand.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RolesInterface rolesInterface;;
    @PostMapping("/add")
    public String addRole(@RequestBody RolesForm rolesForm) throws Exception{
        String t = ";";
        return rolesInterface.setEntity(rolesForm);
    }
}
