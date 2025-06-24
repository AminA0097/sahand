package com.userservice.sahand.Auth;

import com.userservice.sahand.Users.UsersEntity;
import com.userservice.sahand.Users.UsersService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl {

    private UsersService usersService;
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UsersEntity usersEntity = usersService.findUsername(username);
                if (usersEntity == null) {
                    throw new UsernameNotFoundException("User not found: " + username);
                }
                return new CustomUserDetail(usersEntity);
            }
        };
    }
}
