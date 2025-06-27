package com.userservice.sahand.Utils;

import com.userservice.sahand.Auth.SignUpForm;
import com.userservice.sahand.Bases.BasesEntity;
import com.userservice.sahand.Bases.BasesForm;
import com.userservice.sahand.Persons.PersonsForm;

import java.lang.reflect.Field;

public class Mapper {
    public static boolean copyFormToEntity(BasesForm form, BasesEntity basesEntity) throws Exception{
        Field[] fields = basesEntity.getClass().getDeclaredFields();
        Field[] formFields = form.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            for (Field formField : formFields) {
                if (fieldName.equals(formField.getName())) {
                    formField.setAccessible(true);
                    field.set(basesEntity, formField.get(form));
                }
            }
        }
        return true;
    }

    public static boolean findFormToForm(BasesForm basesForm , BasesForm form) throws Exception {
        return true;
    }
}
