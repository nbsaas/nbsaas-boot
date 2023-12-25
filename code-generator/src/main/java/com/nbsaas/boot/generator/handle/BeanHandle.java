package com.nbsaas.boot.generator.handle;


import com.nbsaas.boot.generator.beans.FormBean;

public interface BeanHandle {

    void handle(Class<?> object, FormBean formBean);
}
