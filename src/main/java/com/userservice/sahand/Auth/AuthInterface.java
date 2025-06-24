package com.userservice.sahand.Auth;

public interface AuthInterface {
    public String login(LoginForm loginForm) throws Exception;
    public boolean signUp(SignUpForm signUpForm) throws Exception;
}
