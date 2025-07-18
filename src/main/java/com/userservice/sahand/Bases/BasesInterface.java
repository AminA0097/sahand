package com.userservice.sahand.Bases;


import com.userservice.sahand.Utils.FilterRequest;

import java.util.List;

public interface BasesInterface<T> {
    public List fetch(String filter, int pageNo, int pageSize, String order, String sort) throws Exception;

    public List getList(FilterRequest filterRequest) throws Exception;

    public String save(BasesForm basesForm) throws Exception;

    BasesEntity find(String filter) throws Exception;
}

