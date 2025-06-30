package com.userservice.sahand.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Roots.MAIN_ROOT)
public class UserController {
    @Autowired
    UsersInterface usersInterface;
    @GetMapping(Roots.SHOW_INFO)
    public List<?> getInfo()throws Exception{
        return null;
    }
}
