package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthInterface {
    public ResponseEntity<?> login(LoginForm loginForm, HttpServletResponse req) throws Exception;

    public ResponseEntity<?> signUpUsers(UsersForm usersForm) throws Exception;

    public ResponseEntity<?> signUpPersons(PersonsForm personsForm) throws Exception;

    public ResponseEntity<?> getUserInfo(String userName) throws Exception;

    public ResponseEntity<?> sendResponse(String status, String... messages) throws Exception;

}
