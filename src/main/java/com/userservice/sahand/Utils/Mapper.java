package com.userservice.sahand.Utils;

import com.userservice.sahand.Bases.BasesForm;
import java.lang.reflect.Field;

public class Mapper {
    public static Object copyFormToEntity(BasesForm form, Class<?> entity) throws Exception{
        Class<?> entityClass =  Remote.getClass(form.getClass(),"Entity");
        Object entityInstance = entityClass.getDeclaredConstructor().newInstance();
        Field[] entityFields = entityClass.getDeclaredFields();
        Field[] formFields = form.getClass().getDeclaredFields();
        for(Field ef : entityFields){
            ef.setAccessible(true);
            String entityFieldName = ef.getName();
            if(!ef.isAnnotationPresent(RelatedFiled.class)){
                for(Field formField : formFields){
                    if(formField.getName().equals(entityFieldName)){
                        Object formFieldValue = formField.get(form);
                        ef.set(entityInstance, formFieldValue);
                        break;
                    }
                }
            }
        }
        return entityInstance;
    }
}
