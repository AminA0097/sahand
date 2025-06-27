package com.userservice.sahand.Bases;

import com.userservice.sahand.Utils.Mapper;
import com.userservice.sahand.Utils.Remote;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public  class BasesService<T> implements BasesInterface<T> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<?> getList(String filter, int start, int end) throws Exception {
        Class <?> interfaceClass = Remote.getClass(this.getClass(),"Interface");
        Class <?> simpleClass = Remote.getClass(this.getClass(),"Simple");
//        Class <?> formClass = Remote.getClass(this.getClass(),"Form");
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
        Class <?> entityClassName = Remote.getClass(this.getClass(),"Entity");
        BasesEntity basesEntity = (BasesEntity) entityClassName.getDeclaredConstructor().newInstance();
        Mapper.copyFormToEntity(basesForm,basesEntity);
        if (basesEntity.getId() == null || basesEntity.getId() == -1) {
            basesEntity.setDeleted(false);
            basesEntity.setDeletedData(new Date());
            basesEntity.setCreatedBy("Amin");
            basesEntity.setCreatedData(new Date());
            entityManager.persist(basesEntity);
            entityManager.flush();

        }
        else{
            basesEntity.setUpdatedBy("Amin");
            basesEntity.setUpdatedData(new Date());
            entityManager.merge(basesEntity);
            entityManager.flush();

        }
        return basesEntity.getId().toString();

    }
}
