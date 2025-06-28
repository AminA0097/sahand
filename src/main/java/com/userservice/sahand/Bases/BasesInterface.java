package com.userservice.sahand.Bases;


import com.userservice.sahand.Persons.PersonsEntity;

import java.util.List;

public interface BasesInterface<T> {
    public List<?> getList(String filter,int start, int end)throws Exception;
    public List<String> getConstraint ();
    public String save (BasesForm basesForm)throws Exception;
    BasesEntity find(String filter)throws Exception;
}

