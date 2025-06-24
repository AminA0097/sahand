package com.userservice.sahand.Auth;

public interface AuthInterface {
    public String login(LoginForm loginForm) throws Exception;
    public String signUp(SignUpForm signUpForm) throws Exception;
}
