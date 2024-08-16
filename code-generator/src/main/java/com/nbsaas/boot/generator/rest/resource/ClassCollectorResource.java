package com.nbsaas.boot.generator.rest.resource;

import com.nbsaas.boot.generator.api.apis.ClassCollector;

import java.util.ArrayList;
import java.util.List;

public class ClassCollectorResource implements ClassCollector {
    @Override
    public List<Class<?>> getAllClass(Class<?> object) {
        List<Class<?>> result = new ArrayList<>();
        for (Class<?> clazz = object; clazz != Object.class; clazz = clazz.getSuperclass()) {
            result.add(clazz);
        }
        return result;
    }
}
