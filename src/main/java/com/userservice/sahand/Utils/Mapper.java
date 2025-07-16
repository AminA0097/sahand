package com.userservice.sahand.Utils;

import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.Bases.BasesForm;
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
                setMethod = basesEntity.getClass().getMethod(method.getName());
                Long id = (Long) method.invoke(form);
                System.out.println(id);
            }
        }
        return true;
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
