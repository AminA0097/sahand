package com.userservice.sahand.Utils;

import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.Bases.BasesInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Mapper {
    public static boolean copyFormToEntity(BasesForm form, BasesEntity basesEntity) throws Exception{
        Method[] methods = form.getClass().getMethods();
        Set methodSet = new HashSet();
        for (Method method : methods) {
            if(!method.getName().startsWith("get") && !method.getName().startsWith("is")){
                continue;
            }
            if(!method.isAnnotationPresent(WhatFiled.class)){
                continue;
            }
            methodSet.add(method);
        }

        for(Iterator iterator = methodSet.iterator(); iterator.hasNext();){
            Method setMethod;
            Method method = (Method)iterator.next();
            WhatFiled whatField = method.getAnnotation(WhatFiled.class);
            if(whatField.type().isManyToOne()){
                Long id = (Long) method.invoke(form);
                RelatedFiled relatedFiled = method.getAnnotation(RelatedFiled.class);
                setMethod =  basesEntity.getClass().getMethod(
                        getSetterMethod(method.getName()),relatedFiled.EntityName());
                BasesInterface basesInterface = (BasesInterface) Remote.getRemote(Class.forName(relatedFiled.EntityName().getName().replace("Entity","Interface")));
                BasesEntity entity;
                String filter = relatedFiled.FieldName() + " = " + id.toString();
                entity = basesInterface.find(filter);
                setMethod.invoke(basesEntity, entity);
            }
            else if (whatField.type().isManyToMany()) {
                Set<Long> ids = (Set<Long>) method.invoke(form);
                RelatedFiled relatedFiled = method.getAnnotation(RelatedFiled.class);
                setMethod = basesEntity.getClass().getMethod(
                        getSetterMethod(method.getName()), Set.class
                );
                BasesInterface basesInterface = (BasesInterface) Remote.getRemote(
                        Class.forName(relatedFiled.EntityName().getName().replace("Entity", "Interface"))
                );
                Set<BasesEntity> relatedEntities = new HashSet<>();
                for (Long id : ids) {
                    String filter = relatedFiled.FieldName() + " = " + id.toString();
                    BasesEntity entity = basesInterface.find(filter);
                    if (entity != null) {
                        relatedEntities.add(entity);
                    }
                }

                setMethod.invoke(basesEntity, relatedEntities);
            }
            else{
                WhatFiled.whatTypes types = whatField.type();
                Class<?> _class = whatClass(types.name());
                setMethod = basesEntity.getClass().getMethod(
                        getSetterMethod(method.getName()),_class);
                Object value = method.invoke(form);
                setMethod.invoke(basesEntity, value);
            }

        }
        return true;
    }
    public static Class<?> whatClass(String what) {
        switch (what) {
            case "String":
                return String.class;
            case "Long":
                return Long.class;
            case "Boolean":
                return boolean.class;
            default:
                return null;
        }
    }
    public static String getSetterMethod(String methodName){
        if(methodName.startsWith("get")){
            return methodName.replaceFirst("[g]","s");
        }
        if(methodName.startsWith("is")){
            return methodName.replace("is","set");
        }
        return null;
    }
    public static boolean fillFormToForm(BasesForm fromForm , BasesForm toForm) throws Exception {
        Field[] toFormFields = toForm.getClass().getDeclaredFields();
        Field[] fromFormFields = fromForm.getClass().getDeclaredFields();
        Map<String, Field> fromFieldMap = new HashMap<>();
        for (Field f : fromFormFields) {
            f.setAccessible(true);
            fromFieldMap.put(f.getName(), f);
        }
        for (Field toField : toFormFields) {
            toField.setAccessible(true);
            Field fromField = fromFieldMap.get(toField.getName());
            if (fromField == null) {
                continue;
            }
            try{
                Object value = fromField.get(fromForm);
                if(fromField.getType().equals(toField.getType())){
                    toField.set(toForm, value);
                }
                else if (toField.isAnnotationPresent(RelatedFiled.class)) {
                    System.out.println(toField.getAnnotation(RelatedFiled.class).EntityName());
                }
            }catch (IllegalAccessException e) {
                return false;
            }
            if (fromField != null && fromField.getType().equals(toField.getType())) {
                try {
                    Object value = fromField.get(fromForm);
                    toField.set(toForm, value);
                } catch (IllegalAccessException e) {
                    return false;
                }
            }
        }
        return true;
    }
}
