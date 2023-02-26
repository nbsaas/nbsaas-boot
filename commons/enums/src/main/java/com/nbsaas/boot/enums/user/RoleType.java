package com.nbsaas.boot.enums.user;

public enum RoleType {
    SYSTEM, CUSTOM;

    @Override
    public String toString() {
        if (name().equals("SYSTEM")) {
            return "系统";
        } else if (name().equals("CUSTOM")) {
            return "自定义";
        }
        return super.toString();
    }
}
