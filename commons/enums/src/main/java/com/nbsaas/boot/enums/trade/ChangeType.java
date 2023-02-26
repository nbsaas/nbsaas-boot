package com.nbsaas.boot.enums.trade;

import java.io.Serializable;

public class ChangeType implements Serializable {

    private Integer type;

    private String info;

    public static ChangeType from(Integer type, String info) {
        ChangeType result = new ChangeType();
        result.setType(type);
        result.setInfo(info);
        return result;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
