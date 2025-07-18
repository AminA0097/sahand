package com.userservice.sahand.Users;

import com.userservice.sahand.Bases.BasesInterface;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsersInterface extends BasesInterface<UsersEntity> {
    public UsersEntity findUsername(String username) throws Exception;

    public UsersEntity findUserId(String userId) throws UsernameNotFoundException;

    public String userRegistration(UsersForm usersForm) throws Exception;
}
