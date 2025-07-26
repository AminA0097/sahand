package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import com.userservice.sahand.UsersSerssion.PrincipalSimple;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthInterface {
    public String login(LoginForm loginForm, HttpServletResponse req) throws Exception;

    public String signUpUsers(UsersForm usersForm) throws Exception;

    public String signUpPersons(PersonsForm personsForm) throws Exception;


    public PrincipalSimple verifyToken() throws Exception;
}
