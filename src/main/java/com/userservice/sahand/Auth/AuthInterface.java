package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import com.userservice.sahand.Utils.FilterRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthInterface {
    public String login(LoginForm loginForm, HttpServletResponse req) throws Exception;

    public ResponseEntity<?> signUpUsers(UsersForm usersForm) throws Exception;

    public ResponseEntity<?> signUpPersons(PersonsForm personsForm) throws Exception;

    public List getUsersInfo(FilterRequest filterRequest) throws Exception;

    public ResponseEntity<?> sendResponse(String status, String... messages) throws Exception;

}
