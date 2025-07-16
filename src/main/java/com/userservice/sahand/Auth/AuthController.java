package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//        ResponseCookie cookie = ResponseCookie.from("token11231", token)
//                .httpOnly(true)
//                .secure(true)
//                .path("/")
//                .maxAge(1000 * 60 * 15)
//                .sameSite("Lax")
//                .build();
//        res.setHeader("Set-Cookie", cookie.toString());

    }

    @PostMapping("/signup")
    @Operation(summary = "SignUp With UserForm", description = "Return UserId,Before Have To SignUp Person")
    public ResponseEntity<?> signUpUsers(@RequestBody UsersForm usersForm) throws Exception {
        return authService.signUpUsers(usersForm);
//        Amin
    }

    @PostMapping("/signUp/person")
    public ResponseEntity<?> signUpPerson(@RequestBody PersonsForm personsForm) throws Exception {
        return authService.signUpPersons(personsForm);
//        Amin
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "Test Page!";
    }
}
