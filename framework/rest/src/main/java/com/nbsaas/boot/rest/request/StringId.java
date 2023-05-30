package com.nbsaas.boot.rest.request;

import java.io.Serializable;

public class StringId implements RequestId {

    private final String id;

    public StringId(String id) {
        this.id = id;
    }

    @Override
    public Serializable getId() {
        return id;
    }
}
