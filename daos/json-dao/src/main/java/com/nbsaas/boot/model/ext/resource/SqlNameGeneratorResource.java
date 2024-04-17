package com.nbsaas.boot.model.ext.resource;

import com.alibaba.fastjson2.JSONObject;
import com.nbsaas.boot.model.ext.apis.PermissionCheck;
import com.nbsaas.boot.model.ext.apis.SqlGenerator;
import com.nbsaas.boot.rest.response.ResponseObject;

public class SqlNameGeneratorResource implements SqlGenerator {
    @Override
    public ResponseObject<String> generateSql(JSONObject search) {

        ResponseObject<String> result = new ResponseObject<String>();
        if (!search.containsKey("model")) {
            result.setCode(501);
            result.setMsg("缺少model参数");
            return result;
        }


        return null;
    }

    @Override
    public void setPermissionCheck(PermissionCheck permissionCheck) {

    }
}
