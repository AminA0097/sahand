package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthInterface {
    public String login(LoginForm loginForm, HttpServletResponse req) throws Exception;

    public String signUpUsers(UsersForm usersForm) throws Exception;

    public ResponseEntity<?> signUpPersons(PersonsForm personsForm) throws Exception;

    public ResponseEntity<?> sendResponse(String status, String... messages) throws Exception;
}
