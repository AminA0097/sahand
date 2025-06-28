package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;

public interface AuthInterface {
    public String login(LoginForm loginForm) throws Exception;
    public String signUpPerson(PersonsForm personsForm) throws Exception;
}
