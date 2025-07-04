package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm) throws Exception {
        return authService.login(loginForm);
    }
    @PostMapping("/signup")
    public String signUp(@RequestBody UsersForm usersForm) throws Exception {
        return authService.signUp(usersForm);
//        Amin
    }
    @PostMapping("/signUp/person")
    public String signUpPerson(@RequestBody PersonsForm personsForm) throws Exception {
        return authService.signUpPersons(personsForm);
//        Amin
    }
    @GetMapping("/test")
    public String test() throws Exception {
        return "Test Page!";
    }
}
