package com.nbsaas.boot.generator.handle.base;


import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.handle.BeanHandle;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseFieldHandle implements BeanHandle {
    @Override
    public void handle(Class<?> object, FormBean context) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fs = clazz.getDeclaredFields();
            if (fs != null) {
                for (Field f : fs) {
                    fields.add(f);
                }
            }
        }
        if (fields.size() > 0) {
            handleField(object,fields, context);
        }
    }

    protected abstract void handleField(Class<?> object,List<Field> fields, FormBean context);
}
