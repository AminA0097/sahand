package com.userservice.sahand.Bases;


import java.util.List;

public interface BasesInterface<T> {
    public List<?> getList(String filter,int start, int end)throws Exception;
    public List<String> getConstraint ();
    public String save (BasesForm basesForm)throws Exception;

}

