package com.userservice.sahand.Bases;

import com.userservice.sahand.Utils.Mapper;
import com.userservice.sahand.Utils.QueryDsl;
import com.userservice.sahand.Utils.Remote;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public abstract class BasesService<T> implements BasesInterface<T> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getList(String filter, int pageNo, int pageSize, String order, String sort) throws Exception {
        Class<?> entityClass = Remote.getClass(this.getClass(), "Entity");
        QueryDsl queryDsl = new QueryDsl();
        return List.of();
    }

    @Override
    public List<String> getConstraint() {
        List<String> constraints = new ArrayList<>();
        constraints.add("e.deleted@eq1;");
        return constraints;
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
