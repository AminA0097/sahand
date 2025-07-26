package com.userservice.sahand.Users;

import com.userservice.sahand.Utils.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserController {
    @Autowired
    UsersInterface usersInterface;

    @GetMapping(Roots.SHOW_INFO)
    public List<?> getInfo() throws Exception {
        return null;
    }

    @PostMapping("/getAll")
    public List getUserInfo(@RequestBody FilterRequest filterRequest) throws Exception {
        return usersInterface.getList(filterRequest);
    }
}
