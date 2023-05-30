package com.nbsaas.boot.jpa.data.utils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

public class PathUtils {

    public static <T> Path<T> getPath(Root<T> root, String field) {
        String[] fields = field.split("\\.");
        Path<T> temp = root.get(fields[0]);
        for (int i = 1; i < fields.length; i++) {
            temp = temp.get(fields[i]);
        }
        return temp;
    }
}
