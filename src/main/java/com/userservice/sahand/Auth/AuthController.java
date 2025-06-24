package com.userservice.sahand.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PostMapping(Roots.SIGN_UP_ROOT)
    public boolean signUp(@RequestBody SignUpForm signUpForm) throws Exception {
        return authService.signUp(signUpForm);
    }
    @GetMapping("/test")
    public String test() throws Exception {
        return "Test Page!";
    }
}
