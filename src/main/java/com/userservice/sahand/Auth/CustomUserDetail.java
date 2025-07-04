package com.userservice.sahand.Auth;

import com.userservice.sahand.Users.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetail implements UserDetails {
    private UsersEntity usersEntity;
    public CustomUserDetail(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usersEntity.getRole().getRoleName()));
    }

    @Override
    public String getPassword() {
        return usersEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return usersEntity.getUserName();
    }
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}