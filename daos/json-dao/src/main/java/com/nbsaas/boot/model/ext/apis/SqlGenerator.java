package com.nbsaas.boot.model.ext.apis;

import com.alibaba.fastjson2.JSONObject;
import com.nbsaas.boot.rest.response.ResponseObject;

public interface SqlGenerator {

    /**
     * 根据json生成sql语句
     *
     */
    ResponseObject<String> generateSql(JSONObject search);


    /**
     * 设置权限检查
     *
     */
    void setPermissionCheck(PermissionCheck permissionCheck);
}
