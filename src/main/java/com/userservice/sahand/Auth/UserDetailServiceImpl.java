package com.userservice.sahand.Auth;

import com.userservice.sahand.Users.UsersEntity;
import com.userservice.sahand.Users.UsersService;
import jakarta.persistence.EntityManager;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl {

    private final UsersService usersService;
    @Autowired
    public UserDetailServiceImpl(UsersService usersService) {
        this.usersService = usersService;
    }

    public UserDetailsService getUserDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UsersEntity usersEntity = usersService.findUsername(username);
                if (usersEntity == null) {
                    throw new UsernameNotFoundException("User not found: " + username);
                }
                CustomUserDetail customUserDetail = new CustomUserDetail();
                customUserDetail.setUsername(usersEntity.getUserName());
                customUserDetail.setPassword(usersEntity.getPassword());
                customUserDetail.setRole(usersEntity.getRole().getRoleName());
                return customUserDetail;
            }
        };
    }
}
