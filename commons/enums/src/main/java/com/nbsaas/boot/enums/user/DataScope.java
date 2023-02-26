package com.nbsaas.boot.enums.user;

public enum DataScope {
    my, myDepartment, myAllDepartment, all;

    @Override
    public String toString() {
        if (name().equals("my")) {
            return "本人相关";
        } else if (name().equals("myDepartment")) {
            return "本部门";
        } else if (name().equals("myAllDepartment")) {
            return "本部门及下属部门";
        } else if (name().equals("all")) {
            return "全部";
        }
        return super.toString();
    }
}
