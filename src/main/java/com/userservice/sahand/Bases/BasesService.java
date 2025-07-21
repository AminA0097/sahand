package com.userservice.sahand.Bases;


import com.userservice.sahand.Utils.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public abstract class BasesService<T> implements BasesInterface<T> {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private FilterUtil filterUtil;
    private static final Pattern FILTER_PATTERN = Pattern.compile("^e\\.([a-zA-Z0-9_.]+)@(.+)$");
    private static final Set<String> SUPPORTED_OP = Set.of("eq", "ne", "in", "gt", "lt");

    @Override
    public List getList(FilterRequest filterRequest) throws Exception {
        Class<?> simpleClass = Remote.getClass(this.getClass(), "Simple");
        String order = filterRequest.getOrder() != null ? filterRequest.getOrder() : null;
        String sort = filterRequest.getSort() != null ? filterRequest.getSort() : null;
        Integer pageNo = (filterRequest.getPageNo() == null || filterRequest.getPageNo() < 0) ? 1 : filterRequest.getPageNo();
        Integer pageSize = (filterRequest.getPageSize() == null || filterRequest.getPageSize() <= 0) ? 10 :
                (filterRequest.getPageSize() > 25 ? 25 : filterRequest.getPageSize());
        return fetch(simpleClass, filterRequest.getFilters(), pageNo, pageSize, order, sort);
    }

    @Override
    public List fetch(Class<?> simpleClass, String filter,
                      int pageNo, int pageSize, String order, String sort) throws Exception {
        Class<?> entityClass = Remote.getClass(this.getClass(), "Entity");
        SimpleQuery simpleQuery = simpleClass.getAnnotation(SimpleQuery.class);
        String query = simpleQuery.Query();
        if (query == null) {
            throw new Exception("Query is not supported");
        }

        String _Query = "select new " + simpleClass.getName() + query;
        StringBuilder queryBuilder = new StringBuilder(_Query);
        StringBuilder filterResult = new StringBuilder();
        if (query.contains("where")) {
            queryBuilder.append(" and ");
        } else {
            queryBuilder.append(" where ");
        }
        queryBuilder.append(" (e.deleted = false)");
        if (filter != null) {
            filterResult = filterUtil.createFilter(filter);
            queryBuilder.append(filterResult.toString());
        }
        if (order == null) {
            queryBuilder.append(" order by ");

        }
        if (order.length() == 0) {
            for (Field field : entityClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    String idFieldName = field.getName();
                    queryBuilder.append(" order by e." + idFieldName);
                    break;
                }
            }
        }
        Query _query = entityManager.createQuery(queryBuilder.toString());
        _query.setFirstResult(pageNo * pageSize);
        _query.setMaxResults(pageSize);
        List res = _query.getResultList();
        return res;
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

    @Override
    public ResponseEntity<?> sendResponse(String status, String... messages) throws Exception {
        Map<String, Object> body = Map.of(
                "status", status,
                "message", List.of(messages)
        );
        return ResponseEntity.ok(body);
    }
}
