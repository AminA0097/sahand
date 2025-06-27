package com.userservice.sahand.Users;

import com.userservice.sahand.Auth.SignUpForm;
import com.userservice.sahand.Bases.BasesForm;
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
    public String registration(SignUpForm signUpForm) throws Exception {
        UsersEntity usersEntity = findUsername(signUpForm.getUserName());
        PersonsInterface personsInterface = (PersonsInterface) Remote.makeRemote(PersonsInterface.class);
        UsersInterface usersInterface = (UsersInterface) Remote.makeRemote(UsersInterface.class);
        PersonsForm personsForm = new PersonsForm();
        UsersForm usersForm = new UsersForm();
        Mapper.findFormToForm(signUpForm,personsForm);
        Mapper.findFormToForm(signUpForm,usersForm);
        if(signUpForm.getId() == -1) {
            personsForm.setPersonId(null);
            personsForm.setFirstName(signUpForm.getFirstName());
            personsForm.setLastName(signUpForm.getLastName());
            personsForm.setCompanyName(signUpForm.getCompanyName());
            return personsInterface.save(personsForm);
        }
        return personsInterface.save(signUpForm);
    }
}
