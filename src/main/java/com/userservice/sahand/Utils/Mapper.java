package com.userservice.sahand.Utils;

import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.Bases.BasesForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Mapper {
    public static boolean copyFormToEntity(BasesForm form, BasesEntity basesEntity) throws Exception{
        Field[] entityfields = basesEntity.getClass().getDeclaredFields();
        Field[] formFields = form.getClass().getDeclaredFields();
        for (Field field : entityfields) {
            field.setAccessible(true);
            String EFieldName = field.getName();
            for (Field formField : formFields) {
                String fFieldName = formField.getName();
                if (!EFieldName.equals(fFieldName)) continue;
                formField.setAccessible(true);
//               Related Filed
                if(formField.isAnnotationPresent(RelatedFiled.class)){
                    System.out.println(fFieldName);
                    RelatedFiled relatedFiled = formField.getAnnotation(RelatedFiled.class);
                    Class<?> relatedClass = relatedFiled.EntityName();
                    Object id = formField.get(form);
                    relatedClass.getMethods();

                }
                else if(formField.isAnnotationPresent(M2MFiled.class)){
                    System.out.println(fFieldName);
                }
//                Simple Filed
                else{
                    field.set(basesEntity, formField.get(form));
                }
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
