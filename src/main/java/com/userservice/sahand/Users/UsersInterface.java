package com.userservice.sahand.Users;

import com.userservice.sahand.Auth.SignUpForm;
import com.userservice.sahand.Bases.BasesInterface;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsersInterface extends BasesInterface<UsersEntity> {
    public UsersEntity findUsername(String username) throws UsernameNotFoundException;
    public boolean setEntity(SignUpForm signUpForm) throws Exception;
}
