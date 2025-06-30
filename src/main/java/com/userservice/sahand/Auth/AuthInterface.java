package com.userservice.sahand.Auth;

import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Users.UsersForm;

public interface AuthInterface {
    public String login(LoginForm loginForm) throws Exception;
    public boolean signUp(UsersForm usersForm) throws Exception;
}
