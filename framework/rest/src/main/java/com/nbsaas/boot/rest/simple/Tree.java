package com.nbsaas.boot.rest.simple;

import java.util.List;

public interface Tree<T> {

    Long getId();


    Long getParent();


    List<T> getChildren();

    void setChildren(List<T> children);
    String getCode();
}
