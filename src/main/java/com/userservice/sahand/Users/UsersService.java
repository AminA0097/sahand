package com.userservice.sahand.Users;

import com.userservice.sahand.Auth.SignUpForm;
import com.userservice.sahand.Bases.BasesService;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Persons.PersonsInterface;
import com.userservice.sahand.Utils.Remote;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class UsersService extends BasesService<UsersEntity> implements UsersInterface {
    @Autowired
    EntityManager entityManager;
    @Override
    public UsersEntity findUsername(String username) throws UsernameNotFoundException {
        List<UsersEntity> user =  entityManager.
                createQuery("select u from UsersEntity u " +
                                "where u.userName = :username and u.deleted = false and u.enabled = true",
                        UsersEntity.class)
                .setParameter("username", username).getResultList();
        return user.isEmpty() ? null : user.get(0);
    }

    @Override
    @Transactional
    public boolean register(SignUpForm signUpForm) throws Exception {
        PersonsInterface personsInterface = (PersonsInterface) Remote.makeRemote(PersonsInterface.class);
        UsersInterface usersInterface = (UsersInterface) Remote.makeRemote(UsersInterface.class);
        personsInterface.save(signUpForm);
        usersInterface.save(signUpForm);
        return false;
    }
}
