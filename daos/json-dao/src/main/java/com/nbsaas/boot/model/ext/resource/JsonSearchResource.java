package com.nbsaas.boot.model.ext.resource;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nbsaas.boot.model.data.mapper.ModelMapper;
import com.nbsaas.boot.model.ext.apis.JsonSearchApi;
import com.nbsaas.boot.model.ext.apis.PermissionCheck;
import com.nbsaas.boot.model.ext.apis.SqlGenerator;
import com.nbsaas.boot.mp.utils.QueryWrapperUtils;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.MapResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;

import java.io.InputStream;

public class JsonSearchResource implements JsonSearchApi {


    private final SqlGenerator sqlGenerator;

    private final ModelMapper modelMapper;

    private final PermissionCheck permissionCheck;


    public JsonSearchResource(SqlGenerator sqlGenerator, ModelMapper modelMapper, PermissionCheck permissionCheck) {
        this.sqlGenerator = sqlGenerator;
        this.modelMapper = modelMapper;
        this.permissionCheck = permissionCheck;
    }

    @Override
    public PageResponse<MapResponse> search(InputStream inputStream) {
        PageResponse<MapResponse> result=new  PageResponse<>();

        JSONObject search = JSON.parseObject(inputStream);
        sqlGenerator.setPermissionCheck(permissionCheck);
        ResponseObject<String> sqlRes = sqlGenerator.generateSql(search);
        if (sqlRes.getCode() != 200) {
            result.setCode(sqlRes.getCode());
            result.setMsg(sqlRes.getMsg());
            return result;
        }


        long pageNo = search.getLongValue("no", 1);
        long size = search.getLongValue("size", 10);

        // 构建查询条件


        // 执行查询
        Page<MapResponse> page = new Page<>(pageNo, size);
        Page<MapResponse> res = modelMapper.page(page, sqlRes.getData());
        return QueryWrapperUtils.handle(res);
    }

    @Override
    public ListResponse<MapResponse> list(InputStream inputStream) {
        ListResponse<MapResponse> result=new  ListResponse<>();
        JSONObject search = JSON.parseObject(inputStream);

        ResponseObject<String> sqlRes = sqlGenerator.generateSql(search);
        if (sqlRes.getCode() != 200) {
            result.setCode(sqlRes.getCode());
            result.setMsg(sqlRes.getMsg());
            return result;
        }
        result.setData(modelMapper.list(sqlRes.getData()));
        return result;
    }

}
