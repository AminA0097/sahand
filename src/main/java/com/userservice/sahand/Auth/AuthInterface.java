package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import com.userservice.sahand.Utils.FilterRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface AuthInterface {
    public String login(LoginForm loginForm, HttpServletResponse req) throws Exception;

    public String signUpUsers(UsersForm usersForm) throws Exception;

    public String signUpPersons(PersonsForm personsForm) throws Exception;

    public List getUsersInfo(FilterRequest filterRequest) throws Exception;

    public boolean verifyToken(VerifyToken verifyToken) throws Exception;
}
