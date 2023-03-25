package com.nbsaas.boot.rest.request;

import java.io.Serializable;

public class LongId implements RequestId{

    public LongId(Long id) {
        this.id = id;
    }

    private Long id;

    @Override
    public Serializable getId() {
        return id;
    }
}
