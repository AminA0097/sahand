package com.userservice.sahand.Auth;

import com.userservice.sahand.Users.UsersForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Roots.MAIN_ROOT)
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping(Roots.LOGIN_ROOT)
    public String login(@RequestBody LoginForm loginForm) throws Exception {
        return authService.login(loginForm);
    }
    @PostMapping(Roots.SIGN_UP)
    public String signUp(@RequestBody UsersForm usersForm) throws Exception {
        return authService.signUp(usersForm);
//        Amin
    }
    @GetMapping("/test")
    public String test() throws Exception {
        return "Test Page!";
    }
}
