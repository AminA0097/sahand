package com.userservice.sahand.Bases;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.userservice.sahand.Users.UsersEntity;
import com.userservice.sahand.Utils.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public abstract class BasesService<T> implements BasesInterface<T> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getList(FilterRequest filterRequest) throws Exception {
        String order = filterRequest.getOrder() != null ? filterRequest.getOrder() : null;
        String sort = filterRequest.getSort() != null ? filterRequest.getSort() : null;
        Integer pageNo = (filterRequest.getPageNo() == null || filterRequest.getPageNo() < 0) ? 0 : filterRequest.getPageNo();
        Integer pageSize = (filterRequest.getPageSize() == null || filterRequest.getPageSize() <= 0) ? 10 :
                (filterRequest.getPageSize() > 25 ? 25 : filterRequest.getPageSize());
        return fetch(filterRequest.getFilters(), pageNo, pageSize, order, sort);
    }

    @Override
    public List fetch(String filter, int pageNo, int pageSize, String order, String sort) throws Exception {
        Class<?> entityClass = Remote.getClass(this.getClass(), "Entity");
        Class<?> simpleClass = Remote.getClass(this.getClass(), "Simple");
        QueryDsl queryDsl = new QueryDsl();
        List res = new ArrayList<>();
        SimpleQuery simpleQuery = simpleClass.getAnnotation(SimpleQuery.class);
        String query = simpleQuery.Query();
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);

        List<UsersEntity> _res = entityManager.createQuery(query).getResultList();
        for (Iterator iterator = _res.iterator(); iterator.hasNext(); ) {
            UsersEntity users = (UsersEntity) iterator.next();
            Constructor<?> constructor = simpleClass.getConstructor(entityClass);
            res.add(constructor.newInstance(users));

        }
        return List.of();
    }

    @Override
    @Transactional
    public String save(BasesForm basesForm) throws Exception {
        Class<?> entityClassName = Remote.getClass(this.getClass(), "Entity");
        if (basesForm.getId() == null || basesForm.getId() == -1) {
            BasesEntity basesEntityInject = (BasesEntity) entityClassName.getDeclaredConstructor().newInstance();
            Mapper.copyFormToEntity(basesForm, basesEntityInject);
            basesEntityInject.setCreatedBy("Amin");
            basesEntityInject.setCreatedData(new Date());
            basesEntityInject.setEnabled(true);

            try {
                entityManager.persist(basesEntityInject);
                entityManager.flush();
            } catch (Exception e) {
                return e.getMessage();
            }
            return basesEntityInject.getId().toString();
        }

        if (basesForm.getId() != null && basesForm.getId() != -1) {
            BasesEntity loadedEntity = (BasesEntity) find(" e.id = " + basesForm.getId().toString());
            Mapper.copyFormToEntity(basesForm, loadedEntity);
            loadedEntity.setUpdatedBy("Amin");
            loadedEntity.setUpdatedData(new Date());
            entityManager.merge(loadedEntity);
            entityManager.flush();
        }

        return null;
    }

    @Override
    @Transactional
    public BasesEntity find(String filter) throws Exception {
        Class<?> entityClassName = Remote.getClass(this.getClass(), "Entity");
        String selectPart = "select e from " + entityClassName.getSimpleName() + " e";
        String jpql = selectPart + " where " + filter;
        TypedQuery<BasesEntity> query = entityManager.createQuery(jpql, BasesEntity.class);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }

}
