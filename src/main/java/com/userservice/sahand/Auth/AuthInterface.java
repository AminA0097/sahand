package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthInterface {
    public String login(LoginForm loginForm, HttpServletRequest req) throws Exception;
    public String signUp(UsersForm usersForm) throws Exception;

    public String signUpPersons(PersonsForm personsForm) throws Exception;
}
