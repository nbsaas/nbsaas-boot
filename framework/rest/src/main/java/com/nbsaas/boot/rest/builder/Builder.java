package com.nbsaas.boot.rest.builder;


import com.nbsaas.boot.rest.response.ResponseObject;

import java.util.Map;

/**
 * @author ada
 */
public abstract class Builder {

    public abstract ResponseObject<Map<String, Object>> build();

}
