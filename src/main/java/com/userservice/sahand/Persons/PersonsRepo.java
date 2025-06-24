package com.userservice.sahand.Persons;


import com.userservice.sahand.Bases.BaseRepo;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepo extends BaseRepo<PersonsEntity>{

}
