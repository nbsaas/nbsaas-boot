package com.nbsaas.boot.rest.enums;

public enum DataState {

    add, update, delete;

    @Override
    public String toString() {
        if (name().equals("add")) {
            return "增加";
        } else if (name().equals("update")) {
            return "更新";
        } else if (name().equals("delete")) {
            return "删除";
        }
        return super.toString();
    }
}
