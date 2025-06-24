package com.userservice.sahand.Bases;

import com.userservice.sahand.Users.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface BaseRepo<T> extends JpaRepository<T, Long>, QuerydslPredicateExecutor<T>, JpaSpecificationExecutor<T> {

}
