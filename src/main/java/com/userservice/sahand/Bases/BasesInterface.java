package com.userservice.sahand.Bases;


import com.userservice.sahand.Utils.FilterRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BasesInterface<T> {
    public List fetch(Class<?> simpleClass, String filter, int pageNo, int pageSize, String order, String sort) throws Exception;

    public List getList(FilterRequest filterRequest) throws Exception;

    public String save(BasesForm basesForm) throws Exception;

    public String saveEntity(BasesEntity basesEntity) throws Exception;

    BasesEntity find(String filter) throws Exception;

    public ResponseEntity<?> sendResponse(String status, String... messages) throws Exception;
}

