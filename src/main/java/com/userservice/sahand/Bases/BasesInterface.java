package com.userservice.sahand.Bases;


import java.util.List;

public interface BasesInterface<T> {
    public List getList(String filter, int pageNo, int pageSize, String order, String sort) throws Exception;

    public List<String> getConstraint();

    public String save(BasesForm basesForm) throws Exception;

    BasesEntity find(String filter) throws Exception;
}

