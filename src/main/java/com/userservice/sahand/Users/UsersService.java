package com.userservice.sahand.Users;

import com.userservice.sahand.Auth.SignUpForm;
import com.userservice.sahand.Bases.BasesService;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Persons.PersonsForm;
import com.userservice.sahand.Persons.PersonsInterface;
import com.userservice.sahand.Utils.Mapper;
import com.userservice.sahand.Utils.Remote;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class UsersService extends BasesService<UsersEntity> implements UsersInterface {
    @Autowired
    EntityManager entityManager;
    @Override
    public UsersEntity findUserId(String userId) throws UsernameNotFoundException {
        UsersEntity user = entityManager.
                createQuery("select u from UsersEntity u " +
                                "where u.userId = :userId and u.deleted = false and u.enabled = true",
                        UsersEntity.class).setParameter("userId", userId).getResultList().get(0);
        return user == null ? null : user;
    }
    @Override
    @Transactional
    public UsersEntity findUsername(String username) throws UsernameNotFoundException {
        List<UsersEntity> user = entityManager
                .createQuery("select distinct u from UsersEntity u " +
                                "left join fetch u.actions " +
                                "where u.userName = :username and u.deleted = false and u.enabled = true",
                        UsersEntity.class)
                .setParameter("username", username)
                .getResultList();
        return user.isEmpty() ? null : user.get(0);
    }

    @Override
    public String userRegistration(UsersForm usersForm) throws Exception {
        if(findUsername(usersForm.getUserName()) != null){
            return "-1";
        };
        String id = super.save(usersForm);
        if(id != null){
            return id;
        }
        return "-1";
    }
}
