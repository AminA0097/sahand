package com.userservice.sahand.Bases;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasesService<T> implements BasesInterface<T> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<?> getList(String filter, String order, int start, int end) throws Exception {
        return List.of();
    }
}
