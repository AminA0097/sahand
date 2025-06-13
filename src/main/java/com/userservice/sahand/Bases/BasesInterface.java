package com.userservice.sahand.Bases;


import java.util.List;

public interface BasesInterface<T> {
    public List<?> getList(String filter, String order, int start, int end)throws Exception;
}

