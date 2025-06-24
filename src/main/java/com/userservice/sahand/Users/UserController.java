package com.userservice.sahand.Users;

import com.userservice.sahand.Bases.BasesInterface;
import com.userservice.sahand.Utils.Remote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Roots.MAIN_ROOT)
public class UserController {
    @GetMapping(Roots.SHOW_INFO)
    public List<?> getInfo()throws Exception{
        System.out.println("!");
        UsersInterface usersInterface = (UsersInterface) Remote.makeRemote(UsersInterface.class);
        return usersInterface.getList(null,0,0);
    }
}
