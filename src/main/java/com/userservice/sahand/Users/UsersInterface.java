package com.userservice.sahand.Users;

import com.userservice.sahand.Bases.BasesInterface;
import com.userservice.sahand.Persons.PersonsForm;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsersInterface extends BasesInterface<UsersEntity> {
    public UsersEntity findUsername(String username) throws UsernameNotFoundException;
    public boolean userRegistration(UsersForm usersForm) throws Exception;
}
