package com.nbsaas.boot.model.ext.apis;

public interface PermissionCheck {

    /**
     * 检查当前用户使用拥有该权限
     *
     * @param permission
     * @return
     */
    boolean check(String permission);
}
