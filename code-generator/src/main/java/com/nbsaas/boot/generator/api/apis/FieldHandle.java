package com.nbsaas.boot.generator.api.apis;


import com.nbsaas.boot.generator.beans.FormBean;

import java.lang.reflect.Field;

public interface FieldHandle {

    /**
     * 处理字段
     *
     * @param field
     * @param formBean
     */
    void handle(Class<?> object,Field field, FormBean formBean);
}
