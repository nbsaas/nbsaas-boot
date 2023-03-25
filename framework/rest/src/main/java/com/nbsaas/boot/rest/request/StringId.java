package com.nbsaas.boot.rest.request;

import java.io.Serializable;

public class StringId implements RequestId{

    public StringId(String id) {
        this.id = id;
    }

    private String id;

    @Override
    public Serializable getId() {
        return id;
    }
}
