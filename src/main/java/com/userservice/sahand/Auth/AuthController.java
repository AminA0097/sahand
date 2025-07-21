package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import com.userservice.sahand.Utils.FilterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Controller", description = "Authentication Methods!")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm, HttpServletRequest req,
                                   HttpServletResponse res) throws Exception {
        String token = authService.login(loginForm, res);
        if (token != null) {
            return ResponseEntity.ok(Map.of(
                    "token", token
            ));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/signup")
    @Operation(summary = "SignUp With UserForm", description = "Return UserId,Before Have To SignUp Person")
    public String signUpUsers(@RequestBody UsersForm usersForm) throws Exception {
        return authService.signUpUsers(usersForm);
//        Amin
    }

    @PostMapping("/signUp/person")
    public String signUpPerson(@RequestBody PersonsForm personsForm) throws Exception {
        return authService.signUpPersons(personsForm);

    }

    @PostMapping("/getuserinfo")
    public List getUserInfo(@RequestBody FilterRequest filterRequest) throws Exception {
        return authService.getUsersInfo(filterRequest);
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "Test Page!";
    }
}
