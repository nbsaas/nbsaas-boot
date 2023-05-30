package com.nbsaas.boot.rest.request;

import java.io.Serializable;

public class LongId implements RequestId {

    private final Long id;

    public LongId(Long id) {
        this.id = id;
    }

    @Override
    public Serializable getId() {
        return id;
    }
}
