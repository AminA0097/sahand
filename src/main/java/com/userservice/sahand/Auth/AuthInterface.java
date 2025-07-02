package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;

public interface AuthInterface {
    public String login(LoginForm loginForm) throws Exception;
    public String signUp(UsersForm usersForm) throws Exception;

    public String signUpPersons(PersonsForm personsForm) throws Exception;
}
