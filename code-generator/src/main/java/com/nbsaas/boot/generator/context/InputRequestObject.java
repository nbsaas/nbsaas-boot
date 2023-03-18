package com.nbsaas.boot.generator.context;

import com.nbsaas.boot.generator.beans.FormBean;
import com.nbsaas.boot.generator.config.Config;
import com.nbsaas.boot.generator.domain.Table;
import com.nbsaas.boot.rest.request.RequestObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class InputRequestObject extends RequestObject {

    private Table table;

    private Config config;
    private FormBean formBean;

    public Object get(Object key) {
        return maps.get(key);
    }

    public Object put(String key, Object value) {
        return maps.put(key, value);
    }

    private Map<String,Object> maps=new HashMap<>();
}
