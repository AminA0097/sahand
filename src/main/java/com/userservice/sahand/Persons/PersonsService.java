package com.userservice.sahand.Persons;

import com.userservice.sahand.Bases.BasesService;
import com.userservice.sahand.Users.UsersEntity;
import com.userservice.sahand.Users.UsersInterface;
import org.springframework.stereotype.Service;

@Service
public abstract class PersonsService extends BasesService<PersonsEntity> implements PersonsInterface {

}
